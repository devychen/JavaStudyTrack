/**
 * A program to translate text into pig latin
 */
import java.util.*;
public class ModifiedPigLatin
{    
    public static void main(String[] args)
    {        
        Scanner keyboard = new Scanner(System.in);
        Scanner lineScan;
        
        String line = "";
        String word = "";
        String pigWord = "";
        boolean firstVowelFound = false;
        int firstVowelIndex = 0;
        char currentLetter;
        
        // read each line
        while (keyboard.hasNextLine())
        {
            line = keyboard.nextLine();
            lineScan = new Scanner(line);
            
            // process each word on the current line
            while (lineScan.hasNext())
            {
                word = lineScan.next();
                
                // initialize loop control variables
                firstVowelIndex = 0;
                firstVowelFound = false;
                
                /*
                 * find the index of the first vowel by iterating each
                 * character in the word.  The loop stops when either
                 * the first vowel is found or the end of the word
                 * is reached.
                 */
                while ((firstVowelIndex < word.length()) && !firstVowelFound)
                {                    
                    currentLetter = word.charAt(firstVowelIndex);
                    switch (currentLetter)
                    {
                        case 'a':
                        case 'e':
                        case 'i':
                        case 'o':
                        case 'u':
                            // this will stop the loop
                            // firstVowelIndex is the index of the 1st vowel
                            firstVowelFound = true;
                            break;
                            
                        default:
                            // not a vowel, look at the next character
                            // on the next iteration of the loop
                            firstVowelIndex++;
                    }
                }   
                
                /*
                 * The while-loop stops when the first vowel is encountered,
                 * so at this point in the code, firstVowelIndex is the index
                 * of the first vowel.  We need to know this so that we can
                 * move all of the characters up to the first vowel to the
                 * end of the word (or just add "lay" if the first vowel is
                 * at index 0).
                 */
                
                /*
                 * If the first letter is a vowel, just append "lay"
                 * Otherwise, move the consonants at the beginning of
                 * the word to the end and append "ay"
                 */
                if (firstVowelIndex == 0)
                {
                    pigWord = word + "lay";
                }
                else
                {
                    pigWord = word.substring(firstVowelIndex) +
                        word.substring(0, firstVowelIndex) + "ay";
                }
                
                System.out.print(pigWord + " ");
            }
            System.out.println();
        }
    }
}