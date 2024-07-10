import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class SelfTest4Test extends TestCase {
    
    /**
     * Test handshake.
     */
    public void testHandshake() {
        try {
            SelfTest4.handshake(-1);
            fail();
        }
        catch (IllegalArgumentException e) {
            // good
        }
        
        assertEquals(0, SelfTest4.handshake(0));
        assertEquals(0, SelfTest4.handshake(1));
        assertEquals(1, SelfTest4.handshake(2));
        assertEquals(3, SelfTest4.handshake(3));
        assertEquals(6, SelfTest4.handshake(4));
    }
    
    /**
     * Test pascal.
     */
    public void testPascal() {        
        try {
            SelfTest4.pascal(-1);
            fail();
        }
        catch (IllegalArgumentException e) {
            // good
        }
        
        int[] result; 
        int[][] expected = {
            {1},
            {1,1},
            {1,2,1},
            {1,3,3,1},
            {1,4,6,4,1},
            {1,5,10,10,5,1},
            {1,6,15,20,15,6,1}
        };

        for (int row=0; row<expected.length; row++) {
            result = SelfTest4.pascal(row);
            
            for (int i=0; i<expected[row].length; i++) {
                assertEquals("row: " + row + " element: " + i,
                             expected[row][i], result[i]);
            }
        }
    }
}
