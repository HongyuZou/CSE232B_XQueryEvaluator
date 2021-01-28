import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenSource;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.util.*;
import org.w3c.dom.Node;

public class XPathMain {
    public static void main(String[] args) throws IOException {
        // "Java -jar CSE-232B-M1.jar milestone1_input_queries.txt"
        String fileName = args[0];
        System.out.println(fileName); 
        InputStream fileStream = new FileInputStream(fileName);
        ANTLRInputStream charStream = new ANTLRInputStream(fileStream);
        XPathLexer lexer = new XPathLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        XPathParser parser = new XPathParser((TokenStream)tokenStream);
        parser.removeErrorListeners();
        ParseTree parseTree = parser.ap();
        XPathEvaluator evaluator = new XPathEvaluator();
        List<Node> res = evaluator.visit(parseTree);
        Node resNode = evaluator.doc.createElement("res");
        for(Node node : res) {
            resNode.appendChild(evaluator.doc.importNode(node, true));
        }
        
        for (Node node : res) {
            System.out.println(node.getNodeName());
        }
        fileStream.close();
    }
}
