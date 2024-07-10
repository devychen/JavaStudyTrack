## Hashing
With the help of Java's HashMaps, we want to create a program "Frequencies" which does some essential statistical analysis on the words which are appearing in a text. The constructor takes the texts filename as argument.

Please note:

- Ignore the difference between words in upper or lower case! That means: ABC is equal to abc. Use the String's function toUpperCase to convert all the words to uppercase!
- Ignore all punctuation marks: use the method Frequencies.deleteMarks to delete punctuation, brackets etc. from the words
- Certainly, you can test your program with any text. But the applied test class contains the values for the file KurtTucholsky.txt.

Files: Frequencies.java, FrequenciesTest.java, KurtTucholksy.txt



## Exercise 1
Complete the constructor of Frequencies.java. It should do the following:

- Open the file which is passed through in parameter filename. Read that file word by word and fill the hashmap wf with the words. Use the method Frequencies.deleteMarksto delete all special characters in every word!

    - The hashmap wf has the following form:
      - Key: the word
      - Value: the number of appearances of that word (frequencies)

- After wf is filled with the words and their number of appearances, the hashmap wf can be used to fill the hashmap fcluster. This hashmap should contain the number of appearances as key and as value an ArrayList with all words with that number of appearance.


## Exercise 2
Fill in the following methods:

- public void printFrequencies(): Print all words and their number of appearance
- public void printMostFrequentWords(int frequency): Print words (and their frequencies) that appear at least frequency times in the text.
- public ArrayList<String> getCluster(int frequency): Gives back an ArrayList which contains all words with the number of appearance of frequency
- public int frequencyOfAWord(String word): The number of appearance of word

Please note: perhaps there are changes on the constructor neccessary for Exercise 2!

---
Last modified: Thursday, 18 May 2017, 3:46 PM