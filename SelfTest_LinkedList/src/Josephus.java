/**
 * A class to simulate the Josephus problem with a list
 * of names read from an input file.  Play the game by choosing
 * a player to start the counting and the winner will be printed.
 *
 * @author 阿夏
 * Task: Write the play method in the Josephus class.
 */
import java.util.*;

public class Josephus {

    private int countBy;
    private CircularlyLinkedList<String> circNames;
    private ArrayList<String> allNames;

    public Josephus() {
        circNames = new CircularlyLinkedList<String>();
        allNames = new ArrayList<String>();
        countBy = 7; // 每逢7的倍数
    }

    /**
     * Set up the linked list with the given names.
     * `setNames`方法负责将提供的姓名列表存储到一个中间列表中，
     * 而`loadNames`方法则负责将存储在中间列表中的姓名加载到循环链表中。
     */
    public void setNames(ArrayList<String> someNames) {

        // store someNames in variable allNames so we can load them into the
        // circularly linked list before playing
        allNames.clear(); // ensure the list is empty
        for (String s : someNames) { // WHY - 读取someNames中的每一个元素并且赋予s。Equals to:
                                     //   for (int i = 0; i < someNames.size(); i++) {
                                     //      String s = someNames.get(i);}
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
            // TODO
            // load names into the circular list
            loadNames();

            // find the starter, move current at starter
            circNames.advance(starter);

            int size = circNames.size();
            // loop until 1 left, count by 7
            while (circNames.size() > 1){
                circNames.advance(countBy - 1);
                circNames.remove();
            }
            return circNames.getCurrent();
        }
        catch (CircularlyLinkedListException e) {
            return null;
        }
    }
}
