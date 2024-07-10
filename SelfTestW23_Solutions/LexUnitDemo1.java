import java.util.*;
import java.io.*;
public class LexUnitDemo1 {
    
    public static LexUnit readLexUnit() {
        Scanner keyboard = new Scanner(System.in);
        Scanner lineScan;
        String line, word, syn;
        LexUnit rval = null;
        
        System.out.print("Enter a word form followed by its synonyms: ");
        line = keyboard.nextLine();
        if (line.length() > 0) {
            lineScan = new Scanner(line);
            word = lineScan.next();
            rval = new LexUnit(word);
            while (lineScan.hasNext()) {
                syn = lineScan.next();
                rval.addSynonym(syn);
            }
        }
        return rval;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        
        LexUnit aLexUnit = new LexUnit("happy");
        aLexUnit.addSynonym("cheerful");
        aLexUnit.addSynonym("sunny");
        aLexUnit.addSynonym("bright");
        String[] synonyms = aLexUnit.getSynonyms();
        System.out.print(aLexUnit.getWordForm() + ": ");
        for (int i=0; i < synonyms.length; i++) {
            System.out.print(" " + synonyms[i]);
        }
        System.out.println("\n" + aLexUnit);
        
        LexUnit[] lexList = new LexUnit[1];
        int numLexUnits = 0;
        Scanner keyboard = new Scanner(System.in);
        LexUnit lex;
        String answer;
        
        System.out.print("Do you want to enter a lexunit? ");
        answer = keyboard.next();
        while (answer.equalsIgnoreCase("yes")) {
            // resize if list is full
            if (numLexUnits >= lexList.length) {
                LexUnit[] tmp = new LexUnit[lexList.length + 2];
                for (int i=0; i < lexList.length; i++) {
                    tmp[i] = lexList[i];
                }
                lexList = tmp;
            }
            lex = readLexUnit();
            lexList[numLexUnits] = lex;
            numLexUnits++;
            System.out.print("Do you want to enter a lexunit? ");
            answer = keyboard.next();
        }
        
        System.out.println("\nYou entered the following lexunits: ");
        for (int i=0; i< numLexUnits; i++) {
            System.out.println(lexList[i]);
        }
    }
}