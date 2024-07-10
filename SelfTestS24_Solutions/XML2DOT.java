import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class XML2DOT {
    public String dotTree = "";

    public XML2DOT(String xml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(xml));

            Node root = document.getDocumentElement();

            dotTree = "digraph G {\n";

            buildTree(root);

            dotTree = dotTree + "}\n";

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } //catch
    } //constructor
    
    /**
     * Takes the root node of a DOM object and builds up a String "dotTree"
     * which contains the representation of the DOM object in the DOT language.
     *
     */
    private void buildTree(Node aNode) {
        // Remember: If a node has type 1, it is the start of an XML tag.
        // If it has type 3, it is the text content of an XML element.
        
        // If aNode has type 1, it is the start of an XML tag.
        if (aNode.getNodeType() == 1) {
            dotTree += aNode.hashCode() + " [label=\"" + aNode.getNodeName().trim()
                       + "\"];\n";
            if (aNode.getParentNode().getNodeType() == 1) {
                dotTree += aNode.getParentNode().hashCode() + " -> "
                           + aNode.hashCode() + ";\n";
            } else {
                System.out.println(aNode);
            }
        }

        // If aNode has type 3, it is the text content of an XML element.
        if (aNode.getNodeType() == 3 && !aNode.getTextContent().trim().equals("")) {
            dotTree += aNode.hashCode() + " [label=\"" + aNode.getTextContent().trim()
                       + "\"];\n";
            if (aNode.getParentNode().getNodeType() == 1) {
                dotTree += aNode.getParentNode().hashCode() + " -> " + aNode.hashCode()
                           + ";\n";
            }
        }

        // Iterate thourg all children and call method buildTree recursively.
        for (int i=0; i < aNode.getChildNodes().getLength(); i++) {
            Node childNode = aNode.getChildNodes().item(i);
            buildTree(childNode);
        }
    } //buildTree

    /*
     * Saves the dottree to a file
     *
     */
    public void saveToFile(String filename) {
        try {
            FileWriter f = new FileWriter(filename);
            f.write(dotTree);
            f.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }//catch
    } //saveToFile

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 2) {

            System.out.println("XML input: " + args[0]);
            System.out.println("Dot output: " + args[1]);

            System.out.println("----------------------");

            XML2DOT parser = new XML2DOT(args[0]);

            System.out.println(parser.dotTree);
            parser.saveToFile(args[1]);

            System.out.println("----------------------");

            System.out.println("Done, file " + args[1] + " was written.");

        } else {
            System.out.println("Usage: xmlfile dotfile");
        }
    } //main
}
