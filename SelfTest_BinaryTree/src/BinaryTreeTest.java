import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class BinaryTreeTest extends TestCase {

    private BinaryTree<String> buildBinaryTree() {
    
        // Build your tree
		// ------------- TO DO -------------
		
		return null;
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
