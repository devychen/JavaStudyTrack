/**
   A class to simulate the Josephus problem with a list
   of names read from an input file.  Play the game by choosing
   a player to start the counting and the winner will be printed.
*/
import java.util.*;
import java.io.*;
public class Josephus {

    private int countBy;
    private CircularlyLinkedList<String> circNames;
    private ArrayList<String> allNames;

    public Josephus() {
        circNames = new CircularlyLinkedList<String>();
        allNames = new ArrayList<String>();
        countBy = 7;
    }
    
    /**
     * Set up the linked list with the given names.
     */
    public void setNames(ArrayList<String> someNames) {
        
        // store someNames in variable allNames so we can load them into the
        // circularly linked list before playing
        allNames.clear();
        for (String s : someNames) {
            allNames.add(s);
        }
    }
    
    private void loadNames() {
        
        // load allNames into the circular list
        // circNames will be destroyed when the game is played
        circNames.clear();
        for (String s : allNames) {
            circNames.add(s);
        }
    }

    /**
       Play the game, starting the counting with starter.
       @param starter the player to start the counting
       @return the winner, or null if starter is not on the list
    */ 
    public String play(String starter) {

        try {
            loadNames();
            circNames.advance(starter);

            // Determine and return the winner
            while (circNames.size() > 1) {
                circNames.advance(countBy-1);
                circNames.remove();
            }
            return circNames.getCurrent();
        }
        catch (CircularlyLinkedListException e) {
            return null;
        }
    }
}
