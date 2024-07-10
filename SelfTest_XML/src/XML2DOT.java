
import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class XML2DOT {
    public String dotTree = "";
    private int nodeCounter = 0; // Counter to give each node a unique identifier


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
        
        //------------------ TODO --------------------//
        if (aNode == null) {
            return;
        }

        int currentNodeId = nodeCounter++;
        String nodeName = aNode.getNodeName();
        if (aNode.getNodeType() == Node.ELEMENT_NODE) {
            dotTree += "  node" + currentNodeId + " [label=\"" + nodeName + "\"];\n";

            NodeList children = aNode.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE || child.getNodeType() == Node.TEXT_NODE) {
                    int childNodeId = nodeCounter;
                    buildTree(child);
                    if (child.getNodeType() == Node.ELEMENT_NODE ||
                            (child.getNodeType() == Node.TEXT_NODE && !child.getNodeValue().trim().isEmpty())) {
                        dotTree += "  node" + currentNodeId + " -> node" + childNodeId + ";\n";
                    }
                }
            }
        } else if (aNode.getNodeType() == Node.TEXT_NODE) {
            String textContent = aNode.getNodeValue().trim();
            if (!textContent.isEmpty()) {
                dotTree += "  node" + currentNodeId + " [label=\"" + textContent + "\", shape=plaintext];\n";
            }
        }
    }    //buildTree

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
