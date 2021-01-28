import java.util.LinkedList;

import java.util.*;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.antlr.v4.runtime.tree.xpath.XPath;

    
public class XPathEvaluator extends XPathBaseVisitor<LinkedList<Node>> {
    LinkedList<Node> curNodes = new LinkedList<>();
    Document doc;

    /**
     *  take an xml file name, return an Document Object
     * @param fileName
     * @return
     */
    private Document parseXML(String fileName) {
        File xmlFile = new File(fileName);
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        // build document builder
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // parse xml file
        Document xmlDoc = null;
        try {
            xmlDoc = builder.parse(xmlFile);
            doc = xmlDoc;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return xmlDoc;
    }

    /**
     * Get descendents of current nodes
     * @return descendents
     */
    private LinkedList<Node> getAllDesc() {
        LinkedList<Node> result = new LinkedList<>();
        for(int i = 0; i < this.curNodes.size(); i ++) {
            Node node = curNodes.get(i);
            getDescHelper(result, node);
        }
        return result;
    }

    private void getDescHelper(List<Node> res, Node node) {
        NodeList child = node.getChildNodes();
        for(int i = 0; i < child.getLength(); i ++) {
            Node temp = child.item(i);
            res.add(temp);
            getDescHelper(res, temp);
        }
    }

    /**
     * Get all direct children of curNodes
     * @return children
     */
    private LinkedList<Node> getAllChildren() {
        LinkedList<Node> result = new LinkedList<>();
        for(int i = 0; i < this.curNodes.size(); i ++) {
            Node node = curNodes.get(i);
            //System.out.println("getRoot: " + node.getNodeName());
            for(int j = 0; j < node.getChildNodes().getLength(); j ++) {
                //System.out.println("getChild: " + node.getChildNodes().item(j).getNodeName());
                result.add(node.getChildNodes().item(j));
            }
        }
        return result;
    }

    /**
     * Get all direct parent of curNodes (duplicates?)
     * @return children
     */
    private LinkedList<Node> getAllParent() {
        LinkedList<Node> result = new LinkedList<>();
        for(int i = 0; i < this.curNodes.size(); i ++) {
            Node node = curNodes.get(i);   
            result.add(node.getParentNode());
        }
        return result;
    }

    @Override 
    public LinkedList<Node> visitDirectChild(XPathParser.DirectChildContext ctx) { 
        String fileName = ctx.FILENAME().getText();
        Document xmlDoc = parseXML(fileName);
        xmlDoc.getDocumentElement().normalize();
        curNodes.add(xmlDoc);
        //System.out.println("hehe1: " + curNodes.size());
        return visit(ctx.rp());
    }

    @Override
    public LinkedList<Node> visitIndirectChild(XPathParser.IndirectChildContext ctx) { 
        String fileName = ctx.FILENAME().getText();
        Document xmlDoc = parseXML(fileName);
        xmlDoc.getDocumentElement().normalize();
        curNodes.add(xmlDoc);

        // add all desendents
        LinkedList<Node> descendants = getAllDesc();
        this.curNodes = descendants;
        return visit(ctx.rp()); 
    }

    // modified
    @Override public LinkedList<Node> visitTagName(XPathParser.TagNameContext ctx) { 
        LinkedList<Node> res = new LinkedList<>();
        for(Node node : getAllChildren()) {
            //System.out.println("hehe3: " + node.getNodeName());
            if(node.getNodeName().equals(ctx.NAME().getText())) {
                res.add(node);
            }
        }
        return res; 
    }

    @Override 
    public LinkedList<Node> visitAll(XPathParser.AllContext ctx) { 
        return getAllChildren();
    }

    @Override public LinkedList<Node> visitCurrent(XPathParser.CurrentContext ctx) { 
        return this.curNodes;
    }

    @Override public LinkedList<Node> visitParent(XPathParser.ParentContext ctx) { 
        return getAllParent(); 
    }

    @Override public LinkedList<Node> visitText(XPathParser.TextContext ctx) { 
        return getAllChildren();
    }

    @Override public LinkedList<Node> visitAttr(XPathParser.AttrContext ctx) { 
        String attrName = ctx.NAME().getText();
        LinkedList<Node> res = new LinkedList<>();
        for(int i = 0; i < curNodes.size(); i ++) {
            Node node = curNodes.get(i);
            if(node.hasAttributes()) {
                String attribute = ((Element)node).getAttribute(attrName);
                if(attribute.length() > 0) {
                    res.add(node);
                }
            }
        }
        
        return res; 
    }

    @Override public LinkedList<Node> visitParenRP(XPathParser.ParenRPContext ctx) { 
        return visit(ctx.rp());
    }

    // modified rp / rp
    @Override public LinkedList<Node> visitDirectChildRP(XPathParser.DirectChildRPContext ctx) { 
        curNodes = visit(ctx.rp(0));
        curNodes = visit(ctx.rp(1)); 
        return curNodes; 
    }

    // modified rp // rp
    // is short for /descendant-or-self::node()/
    @Override public LinkedList<Node> visitIndirectChildRP(XPathParser.IndirectChildRPContext ctx) { 
        curNodes = visit(ctx.rp(0));
        curNodes.addAll(getAllDesc());
        curNodes = visit(ctx.rp(1));
        return curNodes;
    }

    // modified rp [ f ]
    @Override public LinkedList<Node> visitFilter(XPathParser.FilterContext ctx) { 
        curNodes = visit(ctx.rp());
        return visit(ctx.f()); 
    }

    @Override public LinkedList<Node> visitConcat(XPathParser.ConcatContext ctx) { 
        LinkedList<Node> res = new LinkedList<>();
        LinkedList<Node> original = this.curNodes;
        res.addAll(visit(ctx.rp(0)));
        curNodes = original;
        res.addAll(visit(ctx.rp(1)));
        curNodes = res;
        return curNodes;
    }

    // TODO: double check
    @Override public LinkedList<Node> visitRpFt(XPathParser.RpFtContext ctx) {
        LinkedList<Node> original = this.curNodes;
        LinkedList<Node> visitRes = visit(ctx.rp());
        this.curNodes = original;
        return visitRes; 
    }

    // TODO: not sure if result should contains duplicates
    @Override public LinkedList<Node>  visitEq1(XPathParser.Eq1Context ctx) { 
        LinkedList<Node> original = this.curNodes;

        // return cur set of nodes after find one pair of elements equal
        LinkedList<Node> visitRes0 = visit(ctx.rp(0));
        this.curNodes = original;
        LinkedList<Node> visitRes1 = visit(ctx.rp(1));
        this.curNodes = original;
        for(Node resNode0 : visitRes0) {
            for(Node resNode1 : visitRes1) {
                if(resNode0.isEqualNode(resNode1)) {
                    return original;
                }
            }
        }
  
        return new LinkedList<>();  
    }

    @Override public LinkedList<Node>  visitEq2(XPathParser.Eq2Context ctx) { 
        LinkedList<Node> original = this.curNodes;

        // return cur set of nodes after find one pair of elements equal
        LinkedList<Node> visitRes0 = visit(ctx.rp(0));
        this.curNodes = original;
        LinkedList<Node> visitRes1 = visit(ctx.rp(1));
        this.curNodes = original;
        for(Node resNode0 : visitRes0) {
            for(Node resNode1 : visitRes1) {
                if(resNode0.isEqualNode(resNode1)) {
                    return original;
                }
            }
        }
  
        return new LinkedList<>();  
    }

    @Override public LinkedList<Node>  visitStr(XPathParser.StrContext ctx) { 
        LinkedList<Node> original = this.curNodes;
        String text = ctx.NAME().getText();

        // return cur set of nodes after find one pair of elements equal
        LinkedList<Node> visitRes = visit(ctx.rp());
        this.curNodes = original;
        for(Node resNode : visitRes) {
            if(resNode.getNodeType() == Node.TEXT_NODE) {
                if(resNode.getTextContent().equals(text)) {
                    return original;
                }
            }
        }
  
        return new LinkedList<>();  
    }


    // TODO: not sure if result should contains duplicates
    @Override public LinkedList<Node>  visitIs(XPathParser.IsContext ctx) { 
        LinkedList<Node> original = this.curNodes;

        // return cur set of nodes after find one pair of elements equal
        LinkedList<Node> visitRes0 = visit(ctx.rp(0));
        this.curNodes = original;
        LinkedList<Node> visitRes1 = visit(ctx.rp(1));
        this.curNodes = original;
        for(Node resNode0 : visitRes0) {
            for(Node resNode1 : visitRes1) {
                if(resNode0.isSameNode(resNode1)) {
                    return original;
                }
            }
        }

        return new LinkedList<>();  
    }

    @Override public LinkedList<Node> visitParenFt(XPathParser.ParenFtContext ctx) { 
        LinkedList<Node> visitRes = visit(ctx.f()); 
        return visitRes; 
    }

    // TODO: double check
    @Override public LinkedList<Node> visitOr(XPathParser.OrContext ctx) { 
        if(visit(ctx.f(0)).isEmpty() && visit(ctx.f(1)).isEmpty()) {
            return new LinkedList<Node>();
        }
        return curNodes;
    }

    // TODO: double check
    @Override public LinkedList<Node> visitAnd(XPathParser.AndContext ctx) { 
        if(visit(ctx.f(0)).isEmpty() || visit(ctx.f(1)).isEmpty()) {
            return new LinkedList<Node>();
        }
        return curNodes;
    }

     // TODO: double check
    @Override public LinkedList<Node> visitNot(XPathParser.NotContext ctx) { 
        if(!visit(ctx.f()).isEmpty()) {
            return new LinkedList<Node>();
        }
        return curNodes;
    }


}
