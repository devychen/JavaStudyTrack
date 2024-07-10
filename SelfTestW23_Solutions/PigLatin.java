/**
 * Course:           Data Structures and Algorithms for Language Processing
 * Assignment:       SelfTest1, exercise 1
 * Author:           Marie Hinrichs; modified by Frank Richter and Verena Henrich
 * Description:      A program to translate a first and last name entered by
 *                   the user into pig latin.
 *
 * Honor Code:       I pledge that this program represents my own work.
 * I received help from:
 *                         no one
 *                         in designing and debugging my program.
 */
import java.util.*;
public class PigLatin 
{
    public static void main(String[] args)
    {       
        String firstName = "";
        String lastName = "";
        String firstNamePig = "";
        String lastNamePig = "";
        String firstChar = "";
        String secondCharUpper = "";
        Scanner keyboard = new Scanner(System.in);
        
        // Get user's first name
        System.out.println("Enter your first name:");
        firstName = keyboard.nextLine();
        
        // Get user's last name
        System.out.println("Enter your last name:");
        lastName = keyboard.nextLine();
        
        /*
         * Convert the first name to lowercase,
         * store the first char,
         * store the second char in a String and convert to upper case
         */
        firstName = firstName.toLowerCase();
        firstChar = firstName.substring(0, 1);
        secondCharUpper = firstName.substring(1, 2).toUpperCase();
        
        /*
         * Translate by concatenating the uppercase second char,
         * the firstName (from index 2 to the end),
         * the first char, and "ay".
         * Store the result in firstNamePig
         */
        firstNamePig = secondCharUpper +
            firstName.substring(2) + firstChar + "ay";
        
        /*
         * Store the first and second characters using the
         * same steps used for the first name
         */        
        lastName = lastName.toLowerCase();
        firstChar = lastName.substring(0, 1);
        secondCharUpper = lastName.substring(1, 2).toUpperCase();
        
        // Translate last name using the same steps used for the first name
        lastNamePig = secondCharUpper +
            lastName.substring(2) +
            firstChar +
            "ay";
        
        // print results
        System.out.println("Your name in pig latin is: " +
                           firstNamePig + " " + lastNamePig);
    }
}