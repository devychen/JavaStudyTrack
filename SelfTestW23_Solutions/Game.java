import java.util.*;
public class Game {
    
    public static void main(String[] args) {
        
        String name = "";
        int strength = 5, intelligence = 5, luck = 5;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter a name for your character: ");
        name = keyboard.next();

        System.out.print("Enter strength (1-10): ");
        strength = keyboard.nextInt();

        System.out.print("Enter intelligence (1-10): ");
        intelligence = keyboard.nextInt();

        System.out.print("Enter luck (1-10): ");
        luck = keyboard.nextInt();

        if (strength + intelligence + luck > 15) {
            System.out.println("You have given your character too many points!"
                               + " Default values have been assigned:");

            strength = intelligence = luck = 5;
        }

        System.out.println(name + " [strength: " + strength
                           + ", intelligence: " + intelligence
                           + ", luck: " + luck + "]");
    }
}