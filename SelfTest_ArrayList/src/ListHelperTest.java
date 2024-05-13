import junit.framework.TestCase;
import java.io.*;
import java.util.*;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class ListHelperTest extends TestCase {
    
    private String inFileName;
    private String outFileName;
    private List<String> expected;
    private ListHelper listHelper;
    
    protected void setUp() {
        inFileName = "inFile.txt";
        outFileName = "outFile.txt";
        
        // set up expected list
        expected = new ArrayList<String>();
        expected.add("hallo");
        expected.add("how are you");
        expected.add("best regards");
        
        // write expected list to input file
        try {
            PrintWriter inFile = new PrintWriter(new File(inFileName));
            
            for (String s : expected) {
                inFile.println(s);
            }
            inFile.close();
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
        
        // create a FileFunctions object
        listHelper = new ListHelper();        
    }
    
    protected void tearDown() {
        expected = null;
        listHelper = null;
        
        // delete the files that were created
        File aFile = new File(inFileName);
        aFile.delete();
        aFile = new File(outFileName);
        aFile.delete();
    }
    
    /**
     * Test the readFileLineByLine method
     */
    public void testReadFileLineByLine() {
        
        List<String> result;
        
        try {
            // read the input file created in setUp() into result
            result = listHelper.readFileLineByLine(inFileName);
            // should be the same as expected
            assertEquals(expected, result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
    /**
     * Test the printList method
     */
    public void testPrintList() {
        
        List<String> result;
        
        try {
            // redirect System.out to outFileName
            PrintStream oldOut = System.out;
            System.setOut(new PrintStream(new FileOutputStream(outFileName)));
            
            // print expected list
            listHelper.printList(expected, false);
            
            // restore System.out
            System.setOut(oldOut);
            
            // read what was written to System.out into result
            result = listHelper.readFileLineByLine(outFileName);
            
            assertEquals(expected, result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
    /**
     * Test the saveListToFile method
     */
    public void testSaveListToFile() {
        
        List<String> result;
        
        try {            
            // save expected list to file
            listHelper.saveListToFile(expected, outFileName);
            
            // read file back into result
            result = listHelper.readFileLineByLine(outFileName);
            
            assertEquals(expected, result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }    
    
    /**
     * Test the saveStringToFile method
     */
    public void testSaveStringToFile() {
        
        List<String> result;
        String aString = "Hello there";
        
        try {            
            // save a String to a file
            listHelper.saveStringToFile(aString, outFileName);
            
            // read file back into result
            result = listHelper.readFileLineByLine(outFileName);
            
            assertEquals(aString, result.get(0));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }    
}
