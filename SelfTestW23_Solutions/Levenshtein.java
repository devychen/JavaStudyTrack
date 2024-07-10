import java.util.Scanner;


/**
 * Class Levenshtein. Represents Levenshtein objects for pairs of words.
 *
 */
public class Levenshtein {
	private static final String SEP_BLOCK = "+\u2014\u2014\u2014";
	
	String word1, word2;
	int[][] table;
	
	/**
	 * Constructor.
	 * @param aWord1 First word for Levenshtein
	 * @param aWord2 Second word for Levenshtein
	 */
	public Levenshtein(String aWord1, String aWord2) {
		word1 = aWord1;
		word2 = aWord2;
		table = table(word1, word2);
	}
	
	/*
	 * Returns the Levenshtein table for two specified words.
	 */
	private static int[][] table(String word1, String word2) {
		// initialise two-dimensional array
		int[][] table = new int[word1.length()+1][word2.length()+1];
		
		// fill first row and column with [0, 1, 2, 3, ...]
		for (int row = 0; row < word1.length() + 1; row++) {
			table[row][0] = row;
		}
		for (int column = 0; column < word2.length() + 1; column++) {
			table[0][column] = column;
		}

		// fill rest of table according to the Levenshtein algorithm
		for (int row = 1; row < word1.length() + 1; row++) {   // for every row ...
			for (int column = 1; column < word2.length() + 1; column++) {  // ... fill every column
				// the two characters that need to be compared
				char c1 = word1.charAt(row    - 1);       // -1, because rows/columns are longer than the words
				char c2 = word2.charAt(column - 1);
				
				int above     = table[row-1][column  ];  // value in the cell above
				int left      = table[row  ][column-1];  // value in the cell to the left
				int leftAbove = table[row-1][column-1];  // value in the cell above to the left
				
				int subst = (c1==c2) ? 0 : 1;            // substitution value: 0 or 1
						
				table[row][column] = min(above+1, left+1, leftAbove+subst);
			}
		}
		return table;
	}
	
	/*
	 * Returns the minimum of 3 integers.
	 */
	private static int min(int i1, int i2, int i3) {
		return Math.min(i1, Math.min(i2, i3));
	}
	
	/*
	 * Looks up the Levenshtein distance in the table and returns it.
	 */
	public int distance() {
		return table[word1.length()][word2.length()];  // value in the right bottom corner
	}
	
	/*
	 * Returns the initial row of the pretty printed table.
	 * returns:
	 * "|   |   | w | o | r | d | 2 |"
	 */
	private String initialRowString() {
		StringBuilder s = new StringBuilder();
		s.append("|   |   ");
		for (int i = 0; i < word2.length(); i++) {
			s.append("| " + word2.charAt(i) + " ");
		}
		s.append("|");
		return s.toString();
	}
	
	/*
	 * Returns a separator line of the pretty printed table.
	 * returns:
	 * "+---+---+---+---+---+---+---+"
	 */
	private String separatorLine() {
		
		StringBuilder s = new StringBuilder();
		s.append(SEP_BLOCK);
		s.append(SEP_BLOCK);
		for (int i = 0; i < word2.length(); i++) {
			s.append(SEP_BLOCK);
		}
		s.append("+");
		return s.toString();
	}
	
	/*
	 * Returns the row with index rowIndex of the pretty printed table.
	 * i.e. returns:
	 * "| d | 4 | 3 | 2 | 1 | 0 | 1 |"
	 */
	private String rowString(int rowIndex) {
		StringBuilder s = new StringBuilder();
		if (rowIndex == 0)   // no char yet -> " "
			s.append("|   ");
		else
			s.append("| " + word1.charAt(rowIndex-1) + " ");
		for (int num : table[rowIndex]) {
			s.append("|");
			if (num/10 < 1) {           // keep it pretty for double digit numbers
				s.append(" ");
			}
			s.append(num + " ");
		}
		s.append("|");
		return s.toString();
	}
	
	/**
	 * Pretty prints the table to the screen.
	 * 
	 * output:
	 * "+---+---+---+---+---+---+---+
	 *  |   |   | w | o | r | d | 2 |
	 *  +---+---+---+---+---+---+---+
	 *  |   | 0 | 1 | 2 | 3 | 4 | 5 |
	 *  +---+---+---+---+---+---+---+
	 *  | w | 1 | 0 | 1 | 2 | 3 | 4 |
	 *  +---+---+---+---+---+---+---+
	 *  | o | 2 | 1 | 0 | 1 | 2 | 3 |
	 *  +---+---+---+---+---+---+---+
	 *  | r | 3 | 2 | 1 | 0 | 1 | 2 |
	 *  +---+---+---+---+---+---+---+
	 *  | d | 4 | 3 | 2 | 1 | 0 | 1 |
	 *  +---+---+---+---+---+---+---+
	 *  | 1 | 5 | 4 | 3 | 2 | 1 | 1 |
	 *  +---+---+---+---+---+---+---+"
	 */
	public void printTable() {
		// first row: word2 (above the actual table)
		System.out.println(separatorLine());
		System.out.println(initialRowString());
		System.out.println(separatorLine());
		
		// prints each row in table followed by a separator line
		for (int row = 0; row < table.length; row++) {
			System.out.println(rowString(row));
			System.out.println(separatorLine());
		}
	}
	
	

	/**
	 * Main method. Keeps reading 2 words from the user and printing Levenshtein table
	 * and distance to the screen.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String word1, word2;
		Levenshtein lev;
		
		System.out.println("Welcome to Levenshtein!");
		
		while (true)
		{
			System.out.println("Enter two words! ('q' to quit)");
			
			// read two words
			word1 = keyboard.next();
			
			if (word1.equalsIgnoreCase("q")) {
				System.out.println("Goodbye!");
				keyboard.close();
				break;
			}
			
			word2 = keyboard.next();
			keyboard.nextLine();
			
			lev = new Levenshtein(word1, word2);
			lev.printTable();
			System.out.println("Levenshtein distance: " + lev.distance() + "\n");
		} 
		keyboard.close();
	}

}
