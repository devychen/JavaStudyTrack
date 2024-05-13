/**
 * Commonly used list operations.
 */

import java.util.*;
import java.io.*;

public class ListHelper {
    
    private String encoding;
    
    /**
     * Construct a ListHelper object with the default utf8 encoding
     */
    public ListHelper() {
        encoding = "UTF-8";
    }
    
    /**
     * Construct a FileFunctions object with the given encoding
     * @param anEncoding the file encoding
     */
    public ListHelper(String anEncoding) {
        encoding = anEncoding;
    }
    
    
    /**
     * Get a list of Strings where each String is one line in the file.
     * @param fileName the name of the file to read
     * @return a List containing the lines in the file
     * @throws FileNotFoundException if there is a problem with the file
     */
    public List<String> readFileLineByLine(String fileName)
        throws FileNotFoundException {
        
        /*********  To Do   ***********/

        // stub
        return null;
    }
    
    /**
     * Print a list to the screen, with or without line numbers
     * @param theList the list to print
     * @param withLineNum print line numbers if true
     */
    public <T> void printList(List<T> theList, boolean withLineNum){

        /*********  To Do   ***********/

    }

    /**
     * Save the contents of the List parameter to a file
     * @param theList the list to save
     * @param fileName the name of the file to write to
     * @throws FileNotFoundException if there is a problem with the file
     */
    public <T> void saveListToFile(List<T> theList, String fileName) 
        throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter dest = new PrintWriter(new File(fileName), encoding);
        
        /*********  To Do   ***********/

    }

    /**
     * Save a String to a file
     * @param theString the String to save
     * @param fileName the name of the file
     * @throws FileNotFoundException if file problems occur
     * @throws UnsupportedEncodingException if the file encoding is not supported
     */
    public void saveStringToFile(String theString, String fileName)
        throws FileNotFoundException, UnsupportedEncodingException {
        
        PrintWriter dest = new PrintWriter(new File(fileName), encoding);
        
        /*********  To Do   ***********/

    }
}