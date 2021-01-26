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
        String fileName = "test1.txt";
        InputStream fileStream = new FileInputStream(fileName);
        CharStream charStream = CharStreams.fromStream(fileStream);
        XPathLexer lexer = new XPathLexer(charStream); 
        CommonTokenStream tokenStream = new CommonTokenStream((TokenSource)lexer);
        XPathParser parser = new XPathParser((TokenStream)tokenStream);
        parser.removeErrorListeners();
        ParseTree parseTree = parser.ap();
        XPathEvaluator evaluator = new XPathEvaluator();
        List<Node> res = evaluator.visit(parseTree);

        for (Node node : res) {
            System.out.println(node.getNodeName());
        }
        fileStream.close();
    }
}
