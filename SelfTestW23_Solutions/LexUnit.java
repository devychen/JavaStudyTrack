/**
 * LexUnit that uses arrays to store synonyms
 */
public class LexUnit {
    private String wordForm;
    private String[] synonyms;
    private int numSynonyms;
  
    /**
     * Construct an empty LexUnit
     */
    public LexUnit() {
        wordForm = "";
        numSynonyms = 0;
        synonyms = new String[2];
    }
    
    /**
     * Construct a LexUnit with a wordForm
     * @param wordForm the word form
     */
    public LexUnit(String wordForm) {
        this();
        setWordForm(wordForm);
    }
    
    /**
     * Get the word form for this lexical unit.
     * @return the wordForm
     */
    public String getWordForm() {
        return wordForm;
    }
    
    /**
     * Set the word form for this lexical unit.
     * @param wordForm the word form for this lexical unit
     */
    public void setWordForm(String wordForm) {
        this.wordForm = wordForm;
    }
    
    /**
     * Get the synonyms for this lexical unit.
     * @return an array of synonyms of this lex unit
     */
    public String[] getSynonyms() {
        String[] rval = new String[numSynonyms];
        for (int i=0; i < numSynonyms; i++) {
            rval[i] = synonyms[i];
        }
        return rval;
    }
    
    /**
     * Get the number of synonyms for this lexical unit.
     * @return the number of synonyms
     */
    public int getNumSynonyms() {
        return numSynonyms;
    }

    /**
     * Add a synonym for this lexical unit.
     * @param aSynonym the synonym to add
     */
    public void addSynonym(String aSynonym) {
        if (numSynonyms >= synonyms.length) {
            String[] tmp = new String[numSynonyms + 3];
            for (int i=0; i < numSynonyms; i++) {
                tmp[i] = synonyms[i];
            }
            synonyms = tmp;
        }
        synonyms[numSynonyms] = aSynonym;
        numSynonyms++;
    }

    /**
     * Return a String representation of this LexUnit
     * @return a String representation of this lex unit
     */
    public String toString() {
        String rval = wordForm + ":";
        for (int i=0; i < numSynonyms; i++) {
            rval += " " + synonyms[i];
        }
        return rval;
    }
}