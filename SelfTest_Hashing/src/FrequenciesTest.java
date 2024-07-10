
import java.util.ArrayList;
import junit.framework.TestCase;

public class FrequenciesTest extends TestCase {
    
    public void testGetCluster() {
        System.out.println("getCluster");
        try {
            Frequencies instance = new Frequencies("KurtTucholsky.txt");
           
            ArrayList result = instance.getCluster(25);
           
            assertTrue(result.contains("IN");
            assertTrue(result.contains("NICHT");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void testFrequencyOfAWord() {
        System.out.println("frequencyOfAWord");
        try {
            Frequencies instance = new Frequencies("KurtTucholsky.txt");
            int expResult = 20;
            int result = instance.frequencyOfAWord("MIT");
            assertEquals(expResult, result);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void testNumberOfDifferentWords() {
        System.out.println("numberOfDifferentWords");
        try {
            Frequencies instance = new Frequencies("KurtTucholsky.txt");
            int expResult = 929;
            int result = instance.numberOfDifferentWords();
            assertEquals(expResult, result);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void testNumberOfWordTokens() {
        System.out.println("numberOfWordTokens");
        try {
            Frequencies instance = new Frequencies("KurtTucholsky.txt");
            int expResult = 2192;
            int result = instance.numberOfWordTokens();
            assertEquals(expResult, result);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void testGetMaxOccurrences() {
        System.out.println("getMaxOccurrences");
        try {
            Frequencies instance = new Frequencies("KurtTucholsky.txt");
            int expResult = 75;
            int result = instance.getMaxOccurrences();
            assertEquals(expResult, result);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
