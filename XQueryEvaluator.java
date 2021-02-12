import java.util.LinkedList;

import java.util.*;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XQueryEvaluator extends XQueryBaseVisitor<LinkedList<Node>>{
    Document xmlDoc = null;
    Document output = null;
    HashMap<String, LinkedList<Node>> context = new HashMap<>();
    Stack<HashMap<String, LinkedList<Node>>> contextStack = new Stack<>();

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

    @Override
    public LinkedList<Node> visitXqVar(XQueryParser.XqVarContext ctx) {
        return context.get(ctx.getText());
    }

    @Override
    public LinkedList<Node> visitXqStr(XQueryParser.XqStrContext ctx) {
        String literal = ctx.STR().getText();
        String text = literal.substring(1, literal.length() - 1);
        Node newNode = xmlDoc.createTextNode(text);
        return new LinkedList<>(Arrays.asList(newNode));
    }

    @Override
    public LinkedList<Node> visitXqAp(XQueryParser.XqApContext ctx) {
        return XPathMain.evaluateXPath(new LinkedList<>(), ctx.getText());
    }

    @Override
    public LinkedList<Node> visitXqParen(XQueryParser.XqParenContext ctx) {
        return visit(ctx.xq());
    }

    @Override
    public LinkedList<Node> visitXqConcat(XQueryParser.XqConcatContext ctx) {
        LinkedList<Node> res = visit(ctx.xq(0));
        res.addAll(visit(ctx.xq(1)));
        return res;
    }

    @Override
    public LinkedList<Node> visitXqDirectChild(XQueryParser.XqDirectChildContext ctx) {
        LinkedList<Node> curNodes = visit(ctx.xq());
        return XPathMain.evaluateXPath(curNodes, ctx.rp().getText()); 
    }

    @Override
    public LinkedList<Node> visitXqIndirectChild(XQueryParser.XqIndirectChildContext ctx) {
        LinkedList<Node> curNodes = visit(ctx.xq());
        curNodes.addAll(getAllDesc(curNodes));
        return XPathMain.evaluateXPath(curNodes, ctx.rp().getText()); 
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
        LinkedList<Node> res = new LinkedList<Node>();
        visitXqClauseHelper(res, 0, ctx.forclause().xq().size(), ctx);
        return res;
    }

    public void visitXqClauseHelper(LinkedList<Node> res, int varIdx, int forVarsCnt, XQueryParser.XqClauseContext ctx) {
        // finished for, start evaluate let, where and return
        if(varIdx > forVarsCnt - 1) {
            if(ctx.letclause() != null) {
                visit(ctx.letclause());
            }

            if(ctx.whereclause() == null || visit(ctx.whereclause()).size() != 0) {
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
            visitXqClauseHelper(res, varIdx + 1, ctx.forclause().xq().size(), ctx);
            this.contextStack.pop();
        }

        return;
    }

    @Override
    public LinkedList<Node> visitXqLet(XQueryParser.XqLetContext ctx) {
        HashMap<String, LinkedList<Node>> originalContext = new HashMap<>(this.context);
        this.contextStack.push(originalContext);
        LinkedList<Node> res = visitChildren(ctx);
        this.contextStack.pop();
        return res;
    }

    @Override 
    public LinkedList<Node> visitForclause(XQueryParser.ForclauseContext ctx) { 
        return null;
    }

    @Override 
    public LinkedList<Node> visitLetclause(XQueryParser.LetclauseContext ctx) { 
        for(int i = 0; i < ctx.var().size(); i ++) {
            LinkedList<Node> res = visit(ctx.xq(i));
            this.context.put(ctx.var(i).getText(), res);
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
}
