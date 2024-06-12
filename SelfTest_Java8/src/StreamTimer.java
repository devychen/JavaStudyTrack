import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The class provides timer methods to compare
 * the runtime of a Stream and a loop search of a corpus.
 *
 * @author saile
 *
 * Task:
 * - Complete the protected method
 * - Add a driver program which
 *      runs getTimeStreams() and getTimeLoops() 1 and 1000 times
 *      and searches for "AWO".
 * - Print the runtime
 *
 * @author hawon
 */

public class StreamTimer {

    // The corpus
    // why - an arraylist to store the `Word` object, using to store words in sentences
    //  a constructor
    private ArrayList<Word> corpus;

    /**
     * Create a StreamTimer from a Negra export file in the current directory
     *
     * @throws java.io.FileNotFoundException When export file is not found.
     */
    // why- constructor
    public StreamTimer() throws FileNotFoundException {
        this("tuebadz_1-50-utf8.export");
    }

    /**
     * Create a StreamTimer from a Negra export file in {@code filename}
     *
     * @param fileName Path to NEGRA export file
     * @throws FileNotFoundException When export file is not found.
     */
    // why - constructor
    public StreamTimer(String fileName) throws FileNotFoundException {
        corpus = new ArrayList<Word>();
        SentenceBuilder build = new SentenceBuilder(fileName);

        // why - 使用sentencebuilder对象读取文件内容，构建语料库
        while (build.hasNext()) {
            ArrayList<Word> sentence = build.next();
            corpus.addAll(sentence);
        }

    }

    /**
     * Search all occurrences of {@code needle} in {@code corpus} with a Stream pipe.
     * Return the runtime of the search.
     * The method must call searchWithStream() to search the corpus.
     *
     * @param needle String to search
     * @param count number of times needle must be searched
     * @return The runtime of the search.
     */
    // why- runtime, by java streams
    public long getTimeStreams(String needle, int count) {

        long startTime = System.currentTimeMillis(); // why-记录搜索开始时间

        List<Word> wl = null; // why - results list
        for (int i = 0; i < count; i++) {  // why - loop to search 'needle'
            wl = searchWithStreams(needle);
        }

        return System.currentTimeMillis() - startTime; // why - return search runtime
    }


    /**
     * Search all occurences of {@code needle} in {@code corpus} with loops.
     * Return the runtime of the search. The method must call searchWithLoop()
     * to search the corpus.
     *
     * @param needle String to search
     * @param count number of times needle must be searched
     * @return The runtime of the search.
     */
    // why- runtime, by traditional loop
    //  to compare performances (性能比较)
    public long getTimeLoops(String needle, int count) {

        long startTime = System.currentTimeMillis();
        List<String> wl = null;

        for (int i = 0; i < count; i++) {
            wl = searchWithLoop(needle);
        }

        return System.currentTimeMillis() - startTime;
    }

    /*
     Search word form {@code needle} in corpus. Return a list of Words matching needle.
     */
    // why- helper method
    protected List<Word> searchWithStreams(String needle) {
        // TODO
        // Build a new list to store `Word` object matching the needle
        List<Word> result = new ArrayList();
        // Use Stream API to filter the corpus
        // 1. Convert the corpus to a stream
        // 2. Use the filter method to filter out Word objects whose form matches the needle
        // 3. Collect the matching Word objects into the result list
        result = corpus.stream()
                        .filter(word -> word.getForm().equals(needle))
                        .collect(Collectors.toList());
        //  return result list
        return result;
    }


    /*
     Search word form {@code needle} in corpus. Return a list of tags of word from.
     Stream must use loops.
     */
    // why- helper method
    protected List<String> searchWithLoop(String needle) {
        // TODO
        // Create a new list to store the tags of Words matching the needle
        List<String> result = new ArrayList();
        // Use a traditional loop to traverse the corpus
        // 1. In the loop, check if the form of the current Word object matches the needle
        // 2. If it matches, add the tag of the Word object to the result list
        for (Word word : corpus) {
            if (word.getForm().equals(needle)) {
                result.add(word.getForm());
            }
        }
        // Return the result list
        return result;
    }

    // TODO- add a driver method
    public static void main(String[] args) throws FileNotFoundException {
        // create a streamtimer object
        StreamTimer timer = new StreamTimer();
        // define search term
        String searchTerm = "AWO";
        // define times
        int[] counts = {1, 1000};
        // run helper methods
        for (int count : counts){
            long streamTime = timer.getTimeStreams(searchTerm, count);
            long loopTime = timer.getTimeLoops(searchTerm, count);
            System.out.println("Stream searching for " + searchTerm + " " + count + " times.");
            System.out.println("Stream search runtime: " + streamTime);
            System.out.println("Loop search time: " + loopTime);
        }

    }

}
