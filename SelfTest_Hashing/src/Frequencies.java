import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Frequencies {

    private HashMap<String, Integer> wf = new HashMap();
    private HashMap<Integer, ArrayList<String>> fcluster = new HashMap();
    private int maxOccurrences = 0;
    private int numberOfWordTokens = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Frequencies frequencies = new Frequencies("KurtTucholsky.txt");
//        frequencies.printFrequencies();
        System.out.println("");
        System.out.println("Highest frequency: " + frequencies.getMaxOccurrences());
        System.out.println("");
        System.out.println("MOST FREQUENT WORDS:");
        frequencies.printMostFrequentWords(35);
    }

    /**
     * Constructor
     *
     * @param filename
     * @throws FileNotFoundException
     */
    public Frequencies(String filename) throws FileNotFoundException {

        /***************** TODO *****************/

    } // constructor

    public String deleteMarks(String word) {
        word = word.replace(".", "");
        word = word.replace(",", "");
        word = word.replace("?", "");
        word = word.replace("!", "");
        word = word.replace("(", "");
        word = word.replace(")", "");
        word = word.replace("»", "");
        word = word.replace("«", "");
        word = word.replace(":", "");
        word = word.replace(";", "");

        return word;
    } //deleteMarks(String word)
    
    /**
     * The number of different words
     * @return
     */
    public int numberOfDifferentWords() {
        return wf.size();
    } //numberOfDifferentWords()

    /**
     * The absolute number of all words in the text
     * @return
     */
    public int numberOfWordTokens() {
        return numberOfWordTokens;
    } // numberOfWordTokens()

    /**
     * Returns the maximum frequency (i.e., the frequency of
     * the most-frequent word in the text)
     */
    public int getMaxOccurrences() {
        return maxOccurrences;
    } //getMaxOccurrences()

    /**
     * Print all words and their number of appearance 
     */
    public void printFrequencies() {

        /***************** TODO *****************/
        for (Map.Entry<String, Integer> entry : wf.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    } //printFrequencies()

    /**
     * Print words (and their frequencies) that appear at least "frequency"
     * times in the text.
     * @param frequency the number of occurrencs that the words should have at least
     */
    public void printMostFrequentWords(int frequency) {

        /***************** TODO *****************/
        for (Map.Entry<Integer, ArrayList<String>> entry : fcluster.entrySet()) {
            if (entry.getKey() >= frequency) {
                for (String word : entry.getValue()) {
                    System.out.println(word + ": " + entry.getKey());
                }
            }
        }
    } //printMostFrequentWords()
    
    /**
     * Gives back an ArrayList which contains all words with the number of appearance of frequency
     * @param number
     * @return 
     */
    public ArrayList<String> getCluster(int number) {

        /***************** TODO *****************/
        return fcluster.getOrDefault(number, new ArrayList<>());
    } //getCluster(int number)

    /**
     * The number of appearance of word
     * @param word
     * @return 
     */
    public int frequencyOfAWord(String word) {

        /***************** TODO *****************/
        return wf.getOrDefault(word, 0);
    } // frequencyOfAWord(String word)
} // class