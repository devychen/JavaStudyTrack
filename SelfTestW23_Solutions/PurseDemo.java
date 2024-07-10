/**
 * Course:      Data Structures
 * Author:      Marie Hinrichs; minimally modified by Frank Richter
 * Name(s):     Sample Solution
 * Description: A class to demonstrate the Purse class.
 *              It creates a Purse object and calls the 
 *              methods in the Purse class.
 */
public class PurseDemo
{    
    public static void main(String[] args)
    {       
        // create a Purse object called bag
        Purse bag = new Purse();
        
        /*
         * add 2 coins of each denomination to bag
         * and print expected and actual results each time
         */
        bag.addOneEuroCoins(2);
        System.out.println("expected total: 2.00 euro,  actual: " +
                           String.format("%.2f", bag.getTotal()));
        
        bag.addFiftyCentCoins(2);
        System.out.println("expected total: 3.00 euro,  actual: " +
                           String.format("%.2f", bag.getTotal()));
        
        bag.addTenCentCoins(2);
        System.out.println("expected total: 3.20 euro,  actual: " +
                           String.format("%.2f", bag.getTotal()));
        
        bag.addOneCentCoins(2);
        System.out.println("expected total: 3.22 euro,  actual: " +
                           String.format("%.2f", bag.getTotal()));
        
        // print the contents of bag
        // this prints the String returned by the toString
        // method in the Purse class
        System.out.println(bag);
    }
}