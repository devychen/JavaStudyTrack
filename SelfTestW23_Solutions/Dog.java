/**
 * Dogs have a name.
 * Dogs are born with a hunger level of 30 by default, but could be born with other values.
 * Their hunger level doubles when they play.
 * Their hunger level reduces by half when they eat (use integer division)
 * If the hunger level is >= 50 they say "Grrrrrr"
 *        otherwise they say "woof".
 * Dogs can doTricks, which increases the hunger level by 20.
 * 
 * SelfTest Inheritance
 */
public class Dog extends Animal {
    
    private String name;
    
    public static final int PLAY = 50;
    public static final int DO_TRICKS = 20;
    public static final int HUNGER_POINT = 50;
    

    /**
     * Constructor to set the dog's name.
     * Born with a hunger level of 30.
     * @param aName the dog's name
     */
    public Dog(String aName) {
        super(30);
        name = aName;
    }
    
    /**
     * Constructor to set the dog's name, sleep state and hunger level.
     * @param aName the dog's name
     * @param aHungerLevel the dog's initial hunger level
     */
    public Dog(String aName, int aHungerLevel) {
        super(aHungerLevel);
        name = aName;
    }
    
    /**
     * Dog's hunger level doubles after playing
     */
    public void play() {
        setHungerLevel(getHungerLevel() * 2);
    }   
    
    /**
     * Dog's hunger level decreases by half after eating
     */
    public void eat() {
        setHungerLevel(getHungerLevel() / 2);
    }
    
    /**
     * Dog's hunger level increases by DO_TRICKS when they do tricks
     */
    public void doTricks() {
        setHungerLevel(getHungerLevel() + DO_TRICKS);
    }
    
    /**
     * Say "Grrrr" if hungry, otherwise "woof"
     * @return what the dog says
     */
    public String speak() {
        String rval = "";
        if (getHungerLevel() >= HUNGER_POINT)
            rval = "Grrrrrr";
        else
            rval = "woof";
        return rval;
    }
    
    /**
     * Get animal characteristics and add the dog's name.
     * @return string representation of a dog.
     */
    public String toString() {
        return ("\"" + name + "\" "  + super.toString());
    }
}
