import java.util.*;
public class AnimalDemo {
   
    public static void printAnimals(Animal... animalList) {
        for (Animal anAnimal : animalList) {
            System.out.println(anAnimal);
        }
    }
    
    public static void main(String[] args) {

        Cat aCat = new Cat("Snowflake");
        Dog aDog = new Dog("Spot");
        
        System.out.println("\nAnimals after construction:");
        System.out.println(aCat);
        System.out.println(aDog);
        
        System.out.println("\nAnimals after Snowflake and Spot have played:");
        aCat.play();
        aDog.play();
        printAnimals(aCat, aDog);
        
        System.out.println("\nSnowflake chased mice and Spot did tricks:");
        aCat.catchMice();
        aDog.doTricks();
        printAnimals(aCat, aDog);
        
        System.out.println("\nAnimals after Snowflake and Spot have eaten:");
        aCat.eat();
        aDog.eat();
        printAnimals(aCat, aDog);
    }
}
