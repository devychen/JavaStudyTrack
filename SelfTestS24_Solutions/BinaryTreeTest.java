import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class BinaryTreeTest extends TestCase {

    private BinaryTree<String> buildBinaryTree() {
        // Build your tree
        BinaryTree<String> sent, np, vp, d, n, nn, v, np2, d2, n2, nn2;

        nn = new BinaryTree<String>("NN");
        n = new BinaryTree<String>("N", nn, null);
        d = new BinaryTree<String>("D");
        np = new BinaryTree<String>("NP", d, n);

        v = new BinaryTree<String>("V");
        nn2 = new BinaryTree<String>("NN");
        n2 = new BinaryTree<String>("N", nn2, null);
        d2 = new BinaryTree<String>("D");
        np2 = new BinaryTree<String>("NP", d2, n2);

        vp = new BinaryTree<String>("VP", v, np2);

        sent = new BinaryTree<String>("S", np, vp);
        
        return sent;
    }
    
    /**
     * Test toString method of the BinaryTree class.
     */
    public void testBinaryTreeToString() {
        BinaryTree<String> tree = buildBinaryTree();

        String expected, actual;
        expected = "[S [NP D [N NN]] [VP V [NP D [N NN]]]]";
        actual = tree.toString();
        assertEquals(expected, actual);
    }
    
    /**
     * Test toString method of the BinaryTree class.
     */
    public void testBinaryTreeMirror() {
        BinaryTree<String> tree = buildBinaryTree();
        tree.mirror();

        String expected, actual;
        expected = "[S [VP [NP [N NN] D] V] [NP [N NN] D]]";
        actual = tree.toString();
        assertEquals(expected, actual);
    }
}
