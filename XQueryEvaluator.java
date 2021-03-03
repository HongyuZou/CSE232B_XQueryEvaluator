import java.util.*;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.regex.*;


public class XQueryEvaluator extends XQueryBaseVisitor<LinkedList<Node>>{
    Document output = null;
    HashMap<String, LinkedList<Node>> context = new HashMap<>();
    Stack<HashMap<String, LinkedList<Node>>> contextStack = new Stack<>();

    public Document getoutput() {
        return this.output;
    }

    private LinkedList<Node> getAllDesc(LinkedList<Node> curNodes) {
        Set<Node> result = new HashSet<>();
        for(int i = 0; i < curNodes.size(); i++) {
            Node node = curNodes.get(i);
            getDescHelper(result, node);
        }
        return new LinkedList<>(result);
    }

    private void getDescHelper(Set<Node> result, Node node) {
        NodeList children = node.getChildNodes();
        for(int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            result.add(child);
            getDescHelper(result, child);
        }
    }

    private LinkedList<Node> getAllChildren(Node node) {
        Set<Node> result = new HashSet<>();
        NodeList children = node.getChildNodes();
        for(int j = 0; j < children.getLength(); j ++) {
            result.add(children.item(j));
        }
        return new LinkedList<>(result);
    }

    @Override
    public LinkedList<Node> visitXqVar(XQueryParser.XqVarContext ctx) {
        return this.context.get(ctx.var().getText());
    }

    @Override
    public LinkedList<Node> visitXqStr(XQueryParser.XqStrContext ctx) {
        String literal = ctx.STR().getText();
        String text = literal.substring(1, literal.length() - 1);
        Node newNode = output.createTextNode(text);
        return new LinkedList<>(Arrays.asList(newNode));
    }

    @Override
    public LinkedList<Node> visitXqAp(XQueryParser.XqApContext ctx) {
        return XPathMain.evaluateXPathAp(ctx.getText());
    }

    @Override
    public LinkedList<Node> visitXqParen(XQueryParser.XqParenContext ctx) {
        return visit(ctx.xq());
    }

    @Override
    public LinkedList<Node> visitXqConcat(XQueryParser.XqConcatContext ctx) {
        Set<Node> res = new HashSet<>();
        res.addAll(visit(ctx.xq(0)));
        res.addAll(visit(ctx.xq(1)));
        return new LinkedList<>(res);
    }

    @Override
    public LinkedList<Node> visitXqDirectChild(XQueryParser.XqDirectChildContext ctx) {
        LinkedList<Node> curNodes = new LinkedList<>(visit(ctx.xq()));
        return XPathMain.evaluateXPathRp(new LinkedList<>(curNodes), ctx.rp().getText()); 
    }

    @Override
    public LinkedList<Node> visitXqIndirectChild(XQueryParser.XqIndirectChildContext ctx) {
        LinkedList<Node> curNodes = new LinkedList<>(visit(ctx.xq()));
        curNodes.addAll(getAllDesc(curNodes));
        return XPathMain.evaluateXPathRp(curNodes, ctx.rp().getText()); 
    }

    @Override 
    public LinkedList<Node> visitXqTag(XQueryParser.XqTagContext ctx) { 
        String tagName = ctx.NAME(0).getText();
        LinkedList<Node> res = visit(ctx.xq());
        Node tagNode = output.createElement(tagName);
        for(Node elementNode : res) {
            tagNode.appendChild(output.importNode(elementNode, true));
        }
        return new LinkedList<>(Arrays.asList(tagNode));
    }
    
    @Override 
    public LinkedList<Node> visitXqClause(XQueryParser.XqClauseContext ctx) { 
        // TODO:
        String returnedQuery = generateRewriteJoin(ctx, ctx.forclause().xq().size());
        HashMap<String, LinkedList<Node>> curContext = new HashMap<>(this.context);
        LinkedList<Node> res = new LinkedList<>();
        this.contextStack.push(curContext);
        visitXqClauseHelper(res, 0, ctx.forclause().xq().size(), ctx);
        this.context = this.contextStack.pop();
        return res;
    }

    public void visitXqClauseHelper(LinkedList<Node> res, int varIdx, int forVarsCnt, XQueryParser.XqClauseContext ctx) {
        // finished for, start evaluate let, where and return
        if(varIdx > forVarsCnt - 1) {
            if(ctx.letclause() != null) {
                visit(ctx.letclause());
            }

            if(ctx.whereclause() == null || !visit(ctx.whereclause()).isEmpty()) {
                res.addAll(visit(ctx.returnclause()));
            }

            return;
        }

        // recursively check for variables
        LinkedList<Node> curRes = visit(ctx.forclause().xq(varIdx));
        for(Node node : curRes) {
            HashMap<String, LinkedList<Node>> curContext = new HashMap<>(this.context);
            this.contextStack.push(curContext);
            this.context.put(ctx.forclause().var(varIdx).getText(), new LinkedList<>(Arrays.asList(node)));
            visitXqClauseHelper(res, varIdx + 1, forVarsCnt, ctx);
            this.context = this.contextStack.pop();
        }
    }

    private String generateRewriteJoin(XQueryParser.XqClauseContext ctx, int forVarsCnt) {
        // group up vars for each xq in join clause
        List<HashSet<String>> varGroups = new ArrayList<HashSet<String>>();
        for(int i = 0; i < forVarsCnt; i ++) {
            String xq = ctx.forclause().xq(i).getText();
            String varName = ctx.forclause().var(i).getText();
            String varParentName = xq.split("/")[0];

            boolean added = false;
            for(Set<String> group : varGroups) {
                if(group.contains(varParentName)) {
                    group.add(varName);
                    added = true;
                }
            }

            // root parent
            if(!added) {
                HashSet<String> newGroup = new HashSet<>();
                newGroup.add(varName);
                varGroups.add(newGroup);
            }
        }

        // check if there is need to join
        if(varGroups.size() < 2) {
            return null;
        }

        // check cond in where clause
        String[] whereConds = ctx.whereclause().cond().getText().split("and");

        // $a eq $b
        // $a eq "John"
        String[][] whereCondsOperands = new String[whereConds.length][2];

        // $a in which group, $b in which group
        // [which condition] [int, int] -> [group index, group index], $a is in group 1 ...
        int[][] opGroups = new int[whereConds.length][2];

        int idx = 0;
        for(String cond : whereConds) {
            String[] operands = cond.split("=|eq");
            whereCondsOperands[idx] = operands;
            
            int[] groupIdx = {-1, -1};
            for(int i = 0; i < varGroups.size(); i ++) {
                Set<String> group = varGroups.get(i);
                if(group.contains(operands[0])) {
                    groupIdx[0] = i;
                }

                if(group.contains(operands[1])) {
                    groupIdx[1] = i;
                }
            }
            opGroups[idx] = groupIdx;
            idx ++;
        }

        return generateJoinQuery(ctx, varGroups, whereCondsOperands, opGroups);
    }

    private String generateJoinQuery(XQueryParser.XqClauseContext ctx, List<HashSet<String>> varGroups, 
                                     String[][] whereCondsOperands, int[][] opGroups) {
        String query = "for $tuple in join (";
        
        // for each join group
        for(int i = 0; i < varGroups.size(); i ++) {
            HashSet<String> curGroup = varGroups.get(i);
            String returnTuple = "<tuple>{";
            query += "for ";

            // for var in xq
            int count = 0;
            for(int j = 0; j < ctx.forclause().var().size(); j ++) {
                String var = ctx.forclause().var(j).getText();
                String xq = ctx.forclause().xq(j).getText();

                if(curGroup.contains(var)) {
                    if(count != 0) {
                        query += ",\n";
                    }
                    query += String.format("%s in %s", var, xq);
                    count ++;

                    // <tuple></tuple> in return for each group
                    if(!returnTuple.equals("<tuple>{")) {
                        returnTuple += ",";
                    }
                    returnTuple += String.format("<%s>{%s}</%s>", var.substring(1), var, var.substring(1));
                }
            }
            returnTuple += "}</tuple>";
            query += "\n";
            
            // where
            int cnt = 0;
            for(int j = 0; j < whereCondsOperands.length; j ++) {
                String[] ops = whereCondsOperands[j];
                if(curGroup.contains(ops[0]) && opGroups[j][1] < 0) {
                    if(cnt == 0) {
                        query += "where ";
                    }

                    if(cnt != 0) {
                        query += "and ";
                    }
                    query += String.format("%s eq %s\n", ops[0], ops[1]);
                    cnt ++;
                }
            }

            // return
            query += String.format("return %s,\n", returnTuple);
        }

        // vars: [sp], [sp]
        String vars1 = "";
        String vars2 = "";
        for(int i = 0; i < whereCondsOperands.length; i ++) {
            String[] ops = whereCondsOperands[i];
            int group1 = opGroups[i][0];
            int group2 = opGroups[i][1];

            if(group1 < 0 || group2 < 0) {continue;}
            if(group2 > group1) {
                vars1 += ops[0].substring(1) + ",";
                vars2 += ops[1].substring(1) + ",";
            } else {
                vars2 += ops[0].substring(1) + ",";
                vars1 += ops[1].substring(1) + ",";
            }
        }
        vars1 = String.format("[%s]", vars1.substring(0, vars1.length() - 1));
        vars2 = String.format("[%s]", vars2.substring(0, vars2.length() - 1));
        query += String.format("%s, %s)", vars1, vars2) + "\n";

        // return
        query += "return ";
        String returnClause = ctx.returnclause().xq().getText();
        Pattern regex = Pattern.compile("\\$[a-zA-Z]+");
		Matcher regexMatcher = regex.matcher(returnClause);
        while (regexMatcher.find()) {
            // Fetching Group from String
            String varName = regexMatcher.group(0);
            String varNameWithoutDollar = varName.substring(1);
            //System.out.println(varName + " " + String.format("$tuple/%s/*", varName));
            returnClause = returnClause.replaceAll("\\" + varName, 
                                        String.format("\\$tuple/%s/*", varNameWithoutDollar));
        }
        
        query += returnClause;
        System.out.println(query);
        return query;
    }

    @Override
    public LinkedList<Node> visitXqLet(XQueryParser.XqLetContext ctx) {
        HashMap<String, LinkedList<Node>> curContext = new HashMap<>(this.context);
        this.contextStack.push(curContext);
        LinkedList<Node> res = visitChildren(ctx);
        this.context = this.contextStack.pop();
        return res;
    }

    @Override 
    public LinkedList<Node> visitForclause(XQueryParser.ForclauseContext ctx) { 
        return null;
    }

    @Override 
    public LinkedList<Node> visitLetclause(XQueryParser.LetclauseContext ctx) { 
        for(int i = 0; i < ctx.var().size(); i++) {
            LinkedList<Node> res = visit(ctx.xq(i));
            this.context.put(ctx.var(i).getText(), new LinkedList<>(res));
        }
        return null;
    }

    @Override
    public LinkedList<Node> visitWhereclause(XQueryParser.WhereclauseContext ctx) { 
        return visit(ctx.cond());
    }

    @Override
    public LinkedList<Node> visitReturnclause(XQueryParser.ReturnclauseContext ctx) { 
        return visit(ctx.xq());
    }

    @Override public LinkedList<Node> visitJoinclause(XQueryParser.JoinclauseContext ctx) { 
        // result tuples
        LinkedList<Node> res = new LinkedList<>();

        // get tuples
        LinkedList<Node> joinRes0 = visit(ctx.xq(0));
        LinkedList<Node> joinRes1 = visit(ctx.xq(1));
        
        // build hashtable on result of first xq, value -> list of tuples
        Map<String, LinkedList<Node>> hashtable = buildHashtable(ctx.varArr(0), joinRes0);
        
        // match result
        XQueryParser.VarArrContext varArr1 = ctx.varArr(1);
        for(Node tuple1 : joinRes1) {
            LinkedList<Node> tupleElements = getAllChildren(tuple1);
            String key = "";

            for(Node ele1 : tupleElements) {
                for(int i = 0; i < varArr1.NAME().size(); i ++) {
                    String varName = varArr1.NAME(i).getText();
                    String nodeName = ele1.getNodeName();
                    
                    // check if it is the element to join, pick values as key in hashtable
                    if(varName.equals(nodeName)) {
                        String eleValue = ele1.getFirstChild().getTextContent();
                        key += eleValue;
                    }
                }
            }

            // cartisian product
            if(hashtable.containsKey(key)) {
                LinkedList<Node> tuples0 = new LinkedList<Node>(hashtable.get(key));
                // add results as tuples to result documents
                for(Node node : tuples0){
                    Node outputNode = output.createElement("tuple");
                    
                    // for xq0
                    for(Node ele : tupleElements) {
                        outputNode.appendChild(output.importNode(ele, true));
                    }

                    // for xq1
                    for(Node ele : getAllChildren(node)) {
                        outputNode.appendChild(output.importNode(ele, true));
                    }

                    res.add(outputNode);
                }
            }
        }

        return res;
    }

    private HashMap<String, LinkedList<Node>> buildHashtable(XQueryParser.VarArrContext varArr,  
                                                             LinkedList<Node> tuples) {
        HashMap<String, LinkedList<Node>> hashtable = new HashMap<>();
        for(Node tuple : tuples) {
            String key = "";
            LinkedList<Node> tupleElements = getAllChildren(tuple);
            
            for(Node ele : tupleElements) {
                for(int i = 0; i < varArr.NAME().size(); i ++) {
                    String varName = varArr.NAME(i).getText();
                    String nodeName = ele.getNodeName();
                    
                    // check if it is the element to join, pick values as key in hashtable
                    if(varName.equals(nodeName)) {
                        String eleValue = ele.getFirstChild().getTextContent();
                        key += eleValue;
                    }
                }
            }

            if(!hashtable.containsKey(key)) {
                hashtable.put(key, new LinkedList<>());
            }
            
            hashtable.get(key).add(tuple);
        }

        return hashtable;
    }

    @Override 
    public LinkedList<Node> visitCondEq1(XQueryParser.CondEq1Context ctx) { 
        LinkedList<Node> res = new LinkedList<>();

        // return cur set of nodes after find one pair of elements equal
        LinkedList<Node> visitRes0 = visit(ctx.xq(0));
        LinkedList<Node> visitRes1 = visit(ctx.xq(1));
        for(Node resNode0 : visitRes0) {
            for(Node resNode1 : visitRes1) {
                if(resNode0.isEqualNode(resNode1)) {
                    res.add(resNode0);
                }
            }
        }
        
        return res;
    }

    @Override 
    public LinkedList<Node> visitCondEq2(XQueryParser.CondEq2Context ctx) { 
        LinkedList<Node> res = new LinkedList<>();

        // return cur set of nodes after find one pair of elements equal
        LinkedList<Node> visitRes0 = visit(ctx.xq(0));
        LinkedList<Node> visitRes1 = visit(ctx.xq(1));
        for(Node resNode0 : visitRes0) {
            for(Node resNode1 : visitRes1) {
                if(resNode0.isEqualNode(resNode1)) {
                    res.add(resNode0);
                }
            }
        }
        
        return res;
    }

    @Override 
    public LinkedList<Node> visitCondIs(XQueryParser.CondIsContext ctx) { 
        LinkedList<Node> res = new LinkedList<>();

        // return cur set of nodes after find one pair of elements equal
        LinkedList<Node> visitRes0 = visit(ctx.xq(0));
        LinkedList<Node> visitRes1 = visit(ctx.xq(1));
        for(Node resNode0 : visitRes0) {
            for(Node resNode1 : visitRes1) {
                if(resNode0.isSameNode(resNode1)) {
                    res.add(resNode0);
                }
            }
        }
        
        return res;
    }

    @Override
    public LinkedList<Node> visitCondEmpty(XQueryParser.CondEmptyContext ctx) {
        LinkedList<Node> visitRes = visit(ctx.xq());
        LinkedList<Node> res = new LinkedList<>();

        if(visitRes.isEmpty()) {
            res.add(output.createTextNode("hehe"));
        }

        return res;
    }

    @Override 
    public LinkedList<Node> visitCondSome(XQueryParser.CondSomeContext ctx) {
        LinkedList<Node> res = new LinkedList<>();
        HashMap<String, LinkedList<Node>> curContext = new HashMap<>(this.context);
        this.contextStack.push(curContext);
        visitCondSomeHelper(0, ctx.var().size(), ctx, res);
        this.context = this.contextStack.pop();
        return res;
    }

    private void visitCondSomeHelper(int varIdx, int varSize, XQueryParser.CondSomeContext ctx, LinkedList<Node> res) {
        if(varIdx > varSize - 1) {
            res.addAll(visit(ctx.cond()));
            return;
        }

        // recursively check for variables
        LinkedList<Node> curRes = visit(ctx.xq(varIdx));
        for(Node node : curRes) {
            HashMap<String, LinkedList<Node>> curContext = new HashMap<>(this.context);
            this.contextStack.push(curContext);
            this.context.put(ctx.var(varIdx).getText(), new LinkedList<>(Arrays.asList(node)));
            visitCondSomeHelper(varIdx + 1, varSize, ctx, res);
            this.context = this.contextStack.pop();
        }
    }

    @Override 
    public LinkedList<Node> visitCondParen(XQueryParser.CondParenContext ctx) { 
        return visit(ctx.cond());
    }

    @Override 
    public LinkedList<Node> visitCondAnd(XQueryParser.CondAndContext ctx) { 
        LinkedList<Node> res = new LinkedList<>();
        if(visit(ctx.cond(0)).isEmpty() || visit(ctx.cond(1)).isEmpty()) {
            return new LinkedList<>();
        }
        res.addAll(visit(ctx.cond(0)));
        res.addAll(visit(ctx.cond(1)));
        return res; 
    }

    @Override 
    public LinkedList<Node> visitCondOr(XQueryParser.CondOrContext ctx) { 
        LinkedList<Node> res = new LinkedList<>();
        res.addAll(visit(ctx.cond(0)));
        res.addAll(visit(ctx.cond(1)));
        return res;
    }

    @Override 
    public LinkedList<Node> visitCondNot(XQueryParser.CondNotContext ctx) { 
        LinkedList<Node> visitRes = visit(ctx.cond());
        LinkedList<Node> res = new LinkedList<>();

        if(visitRes.isEmpty()) {
            res.add(output.createTextNode("hehe"));
        }

        return res;
    }
}
