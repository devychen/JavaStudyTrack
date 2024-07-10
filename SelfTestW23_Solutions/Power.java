
/**
 * A class to calculate power of x to the n
 * for positive values of n, using a loop.
 */

import java.util.*;

public class Power {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int x = 0, n = 0;
        int power = 1;

        // Get x from the user
        System.out.print("Enter an integer value for x: ");
        if (keyboard.hasNextInt()) {
            x = keyboard.nextInt();
        } else {
            System.out.println("Invalid input.");
            System.exit(0);
        }

        // Get n from the user
        System.out.print("Enter an integer value for n: ");
        if (keyboard.hasNextInt()) {
            n = keyboard.nextInt();
        } else {
            System.out.println("Invalid input.");
            System.exit(0);
        }

        // Make sure n is positive
        if (n < 0) {
            System.out.println("The exponent must be a positive integer!");
            System.exit(0);
        }

        // Compute the power
        for (int i = 1; i <= n; i++) {
            power *= x;
        }

        System.out.println(x + " to the power of " + n +
                " = " + power);
    }
}