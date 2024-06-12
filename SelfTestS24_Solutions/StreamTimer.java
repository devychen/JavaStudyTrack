
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The class provides timer methods to compare the runtime of a Stream and a
 * loop search of a corpus.
 *
 * @author saile
 */
public class StreamTimer {

    // The corpus
    private ArrayList<Word> corpus;

    /**
     * Create a StreamTimer from a Negra export file in the current directory
     *
     * @throws java.io.FileNotFoundException When export file is not found.
     */
    public StreamTimer() throws FileNotFoundException {
        this("tuebadz_1-50-utf8.export");
    }

    /**
     * Create a StreamTimer from from a Negra export file in {@code filename}
     *
     * @param fileName Path to NEGRA export file
     * @throws FileNotFoundException When export file is not found.
     */
    public StreamTimer(String fileName) throws FileNotFoundException {
        corpus = new ArrayList<Word>();
        SentenceBuilder build = new SentenceBuilder(fileName);

        while (build.hasNext()) {
            ArrayList<Word> sentence = build.next();
            corpus.addAll(sentence);
        }

    }

    /**
     * Search all occurences of {@code needle} in {@code corpus} with a Stream
     * pipe. Return the runtime of the search. The method must call
     * searchWithStream() to search the corpus.
     *
     * @param needle String to search
     * @param count number of times needle must be searched
     * @return The runtime of the search.
     */
    public long getTimeStreams(String needle, int count) {

        long startTime = System.currentTimeMillis();

        List<Word> wl = null;
        for (int i = 0; i < count; i++) {
            wl = searchWithStreams(needle);
        }

        return System.currentTimeMillis() - startTime;
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
    public long getTimeLoops(String needle, int count) {

        long startTime = System.currentTimeMillis();
        List<String> wl = null;

        for (int i = 0; i < count; i++) {
            wl = searchWithLoop(needle);
        }

        return System.currentTimeMillis() - startTime;
    }

    /*
     Search word form {@code needle} in corpus. Return a list of tags of word from.
     */
    protected List<Word> searchWithStreams(String needle) {
        return corpus.stream().filter(w -> w.getForm().equals(needle)).collect(Collectors.toList());
    }


    /*
     Search word form {@code needle} in corpus. Return a list of tags of word from. Stream must use loops.
     */
    protected List<String> searchWithLoop(String needle) {
        List<String> wl = new ArrayList<>();

        for (Word w : corpus) {
            if (w.getForm().equals(needle)) {
                wl.add(w.getTag());
            }
        }

        return wl;
    }

}
