/**
 * manages corpora in form of an ArrayList
 * reads in corpora
 * can modify that ArrayList
 */

package Drafts;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class CorpusLoader {

    private final ArrayList<CorpusBuilder> corpusArray;

    /**
     * constructor
     * initialises corpusArray
     */
    public CorpusLoader() {
        this.corpusArray = new ArrayList<CorpusBuilder>();
    }

    /**
     * returns corpusArray
     *
     * @return corpusArray
     */
    public ArrayList<CorpusBuilder> getCorpusArray() {
        return corpusArray;
    }

    public int getNumOfCorpora() {
        return corpusArray.size();
    }

    /**
     * get corpus at some index in corpusArray
     *
     * @param index of the corpus
     * @return the corpus
     */
    public CorpusBuilder getCorpus(int index) {
        return corpusArray.get(index);
    }

    /**
     * reads in file, gets title & text,
     * creates new CorpusBuilder w/ text, adds to corpusArray
     *
     * @param fileName file to read
     * @param hasTitle whether file has title on 1st line
     */
    public void addCorpusFromFile(String fileName, boolean hasTitle) {

        // initialise vars
        String title = "";

        // use StringBuilder for speed
        StringBuilder text = new StringBuilder();

        // try w/ resources to read in file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            // getting title:
            if (hasTitle) {

                // get title from 1st line of file
                title = br.readLine();

            } else {

                // if file name has extension, title is file name w/o extension
                int extensionIndex = fileName.lastIndexOf(".");
                if (extensionIndex != -1) {
                    title = fileName.substring(0, extensionIndex);

                } else {

                    // otherwise, title is just file name
                    title = fileName;
                }
            }

            // read all text in file
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
            }

        // catching exception for BufferedReader
        } catch (IOException e) {
            e.printStackTrace();
        }

        // create CorpusBuilder w/ extracted title & text
        CorpusBuilder newCorpus = new CorpusBuilder(title, text.toString());

        // check if corpus to add is already in corpusArray
        for (CorpusBuilder corpus : corpusArray) {
            if (this.areEqual(corpus, newCorpus)) {
                return;
            }
        }

        // if corpus to add is new, add to corpusArray
        corpusArray.add(newCorpus);

    }

    /**
     * scrapes text from Wikipedia article, get title & text,
     * creates new CorpusBuilder w/ text, adds to corpusArray
     *
     * @param URL URL to scrape
     */
    public void addCorpusFromWiki(String URL) {

        // initialise vars
        String title = "";
        String text = "";

        // only if URL is a Wikipedia link
        if (URL.toLowerCase().contains("wikipedia")) {

            try {

                // connect to URL
                Document doc = Jsoup.connect(URL).get();

                // get title
                title = doc.title().substring(0, doc.title().indexOf(" - Wikipedia"));

                // extract content based on ID
                Element content = doc.getElementById("mw-content-text");

                // if there is content, get text as described below:
                if (content != null) {

                    // cleanup: remove unwanted data like references & metadata
                    content.select("sup.reference, sup.noprint.Inline-Template, .metadata").remove();

                    // get paragraphs & save the ones that have text to (var) text
                    Elements paragraphs = content.select("p");

                    StringBuilder sb = new StringBuilder();
                    for (Element paragraph : paragraphs) {
                        if (paragraph.hasText()) {
                            sb.append(paragraph.text()).append("\n");
                        }
                    }

                    // remove trailing whitespace from text
                    text = sb.toString().trim();

                }

            // exception if link invalid
            } catch (IOException e) {
                title = "Could not get text from this Wikipedia article";
                text = "Please re-check the input.";
                e.printStackTrace();
            }
        }

        // create CorpusBuilder w/ extracted title & text
        CorpusBuilder newCorpus = new CorpusBuilder(title, text);

        // check if corpus to add is already in corpusArray
        for (CorpusBuilder corpus : corpusArray) {
            if (this.areEqual(corpus, newCorpus)) {
                return;
            }
        }

        // if corpus to add is new, add to corpusArray
        corpusArray.add(newCorpus);

    }

    /**
     * removed a corpus from corpusArray
     *
     * @param index of corpus to remove
     */
    public void removeCorpus(int index) {
        corpusArray.remove(this.getCorpus(index));
    }

    /**
     * checks if 2 corpora are equal by checking if their titles & texts are equal
     *
     * @param aCorpus a corpus for comparison
     * @param anotherCorpus another corpus for comparison
     * @return true if the 2 corpora are equal, false if not
     */
    private boolean areEqual(CorpusBuilder aCorpus, CorpusBuilder anotherCorpus) {
        return (aCorpus.getTitle().equalsIgnoreCase(anotherCorpus.getTitle())); // &&
        // (aCorpus.getText().equalsIgnoreCase(anotherCorpus.getText())));
    }

    /**
     * check if 2 instances of CorpusLoader are equal
     * by comparing references, classes, corpora
     *
     * @param another Object
     * @return true if equal, false if not
     */
    public boolean equals(Object another) {

        // if they are the same object, return true
        if (another == this) {
            return true;
        }

        // if the class types are different, return false
        if (this.getClass() != another.getClass()) {
            return false;
        }

        // convert object to compare to CorpusLoader class type
        CorpusLoader anotherCL = (CorpusLoader) another;

        // check if both have same size & if corpora at same positions in each are the same
        if (this.getNumOfCorpora() == anotherCL.getNumOfCorpora()) {
            for (int i = 0; i < this.getNumOfCorpora(); i++) {
                if (!this.getCorpus(i).getTitle().equalsIgnoreCase(anotherCL.getCorpus(i).getTitle()) &&
                !this.getCorpus(i).getText().equalsIgnoreCase(anotherCL.getCorpus(i).getText())) {
                    return false;
                }
            }
        }

        // return true if they pass all checks
        return true;

    }

    /**
     * returns corpusArray as String
     *
     * @return corpusArray as String
     */
    public String toString() {

        // use StringBuilder
        // represent in [] w/ comma as delimiter
        StringBuilder corpusArrayString = new StringBuilder("[");

        // append titles of corpora to resulting String
        for (int i = 0; i < corpusArray.size(); i++) {
            corpusArrayString.append(corpusArray.get(i).getTitle());
            if (i != corpusArray.size() - 1) {

                // delimit w/ comma
                corpusArrayString.append(", ");
            }
        }

        // close square bracket
        corpusArrayString.append("]");

        return corpusArrayString.toString();
    }
}
