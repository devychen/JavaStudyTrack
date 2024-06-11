import junit.framework.TestCase;
import java.util.*;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 *
 * @author: 阿夏
 * Task: Add a test method in JosephusTest that plays the game with the people sitting near you.
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

        // TODO
        //  write a test method to play the game with the people sitting in your row
        //  assert that for each starter, the correct winner is returned
        //  test will fail until you write it properly!
        namelist.add("Karen");
        namelist.add("Mike");
        namelist.add("Ellen");
        namelist.add("Alice");
        namelist.add("Bob");
        namelist.add("Charlie");
        namelist.add("David");
        namelist.add("Emma");
        namelist.add("John");

        game.setNames(namelist);

        assertEquals("starter is the 1st name", "John", game.play("Karen"));
        assertEquals("starter is the 2nd name", "Karen", game.play("Mike"));
        assertEquals("starter 3rd", "Mike", game.play("Ellen"));
        assertEquals("starter 4th","Ellen", game.play("Alice"));
        assertEquals("starter 5th","Alice", game.play("Bob"));
        assertEquals("starter 6th","Bob", game.play("Charlie"));
        assertEquals("starter 7th","Charlie", game.play("David"));
        assertEquals("starter 8th","David", game.play("Emma"));


        //fail();

    }
}