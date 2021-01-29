import java.io.IOException;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;
import java.util.*;
import org.w3c.dom.Node;

public class XPathMain {
    public static void main(String[] args) throws IOException {
        // "Java -jar CSE-232B-M1.jar milestone1_input_queries.txt"
        String fileName = args[0];
        CharStream charStream = CharStreams.fromFileName(fileName);
        XPathLexer lexer = new XPathLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        XPathParser parser = new XPathParser(tokenStream);
        parser.removeErrorListeners();
        ParseTree parseTree = parser.ap();
        System.out.println(parseTree.toStringTree());
        XPathEvaluator evaluator = new XPathEvaluator();
        List<Node> res = evaluator.visit(parseTree);
        // Node resNode = evaluator.doc.createElement("res");
        // for(Node node : res) {
        //     resNode.appendChild(evaluator.doc.importNode(node, true));
        // }
        
        System.out.println(res.size());
        for (Node node : res) {
            System.out.println(node.getNodeName() + " " + node.getTextContent());
        }
    }
}
