import junit.framework.TestCase;
import java.util.*;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class JosephusTest extends TestCase {
    
    private Josephus game;
    private ArrayList<String> namelist;
    
    protected void setUp() {
        game = new Josephus();
        namelist = new ArrayList<String>();
    }
    
    protected void tearDown() {
        game = null;
        namelist = null;
    }
    
    /**
     * Test the Josephus game - starter not on the list
     */
    public void testGame1() {
        namelist.add("Karen");
        namelist.add("Mike");
        namelist.add("Ellen");
        
        game.setNames(namelist);
        
        assertEquals("starter not on the list", null, game.play("SpongeBob"));
    }
    
    /**
     * Test the Josephus game - at least 3 players
     */
    public void testGame2() {
        namelist.add("Karen");
        namelist.add("Mike");
        namelist.add("Ellen");
        
        game.setNames(namelist);
        
        assertEquals("winner with 3 names, starter 1st name", "Ellen", game.play("Karen"));
        assertEquals("winner with 3 names, starter 2nd name", "Karen", game.play("Mike"));
        assertEquals("winner with 3 names, starter 3rd name", "Mike", game.play("Ellen"));
    }
}