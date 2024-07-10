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
        Scanner sc = new Scanner(new File(filename), "UTF-8");
        String word;
        int i = 0;

        while (sc.hasNext()) {
            word = sc.next().toUpperCase();
            word = deleteMarks(word);

            if (word.length() > 0) {
                numberOfWordTokens++;

                if (wf.containsKey(word)) {
                    i = wf.get(word);
                    i++;
                    wf.put(word, i);
                } else {
                    wf.put(word, 1);
                } // if else ..
            } // if
        } // while

        Iterator it = wf.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Integer> me = (Map.Entry<String, Integer>) it.next();
            String key = me.getKey();
            int value = me.getValue();

            if (value > maxOccurrences) {
                maxOccurrences = value;
            }

            if (fcluster.containsKey(value)) {
                fcluster.get(value).add(key);
            } else {
                ArrayList<String> myList = new ArrayList();
                myList.add(key);
                fcluster.put(value, myList);
            }
        } //while
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
        Iterator it = wf.entrySet().iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        } // while
    } //printFrequencies()

    /**
     * Print words (and their frequencies) that appear at least "frequency"
     * times in the text.
     * @param frequency the number of occurrencs that the words should have at least
     */
    public void printMostFrequentWords(int frequency) {
        Iterator it = wf.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Integer> me = (Map.Entry<String, Integer>) it.next();
            int value = me.getValue();
            if (value >= frequency) {
                System.out.println(me);
            }
        } // while
    } //printMostFrequentWords()
    
    /**
     * Gives back an ArrayList which contains all words with the number of appearance of frequency
     * @param number
     * @return 
     */
    public ArrayList<String> getCluster(int number) {
        return fcluster.get(number);
    } //getCluster(int number)

    /**
     * The number of appearance of word
     * @param word
     * @return 
     */
    public int frequencyOfAWord(String word) {
        word = word.toUpperCase();
        return (Integer) wf.get(word);
    } // frequencyOfAWord(String word)
} // class