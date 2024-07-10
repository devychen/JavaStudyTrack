/**
 * Cats have a name.
 * Cats are born with a hunger level of 10 by default, but could be born with other values.
 * Their hunger level increases by 20 when they play.
 * Their hunger level increases by 2 when they relax.
 * Their hunger level increases by 10 when they sleep.
 * Their hunger level reduces to zero when they eat.
 * If the hunger level is >= 85 they say "REOW",
 *     if 30 <= hunger level < 85, they say "meow",
 *     otherwise they say  "purrrr"
 * Cats can catchMice, which decreases the hunger level by half.
 * 
 * SelfTest Inheritance
 */
public class Cat extends Animal {
    
    private String name;
    
    public static final int PLAY = 20;
    public static final int HUNGER_POINT = 30;
    public static final int EXTREME_HUNGER_POINT = 85; 
    
    /**
     * Constructor to set the cat's name.
     * Born with a hunger level of 10.
     * @param aName the cat's name
     */
    public Cat(String aName) {
        super(10);
        name = aName;
    }
    
    /**
     * Constructor to set the cat's name, sleep state and hunger level.
     * @param aName the cat's name
     * @param aHungerLevel the cat's initial hunger level
     */
    public Cat(String aName, int aHungerLevel) {
        super(aHungerLevel);
        name = aName;
    }
    
    /**
     * Cat's hunger level increases by PLAY after playing
     */
    public void play() {
        setHungerLevel(getHungerLevel() + PLAY);
    }   
    
    /**
     * Cat's hunger level decreases by half when they catch mice.
     */
    public void catchMice() {
        setHungerLevel(getHungerLevel() / 2);
    }
    
    /**
     * Say "REOW" if very hungry, "meow" if mildly hungry, otherwise "purrrr"
     * @return what the cat says
     */
    public String speak() {
        String rval = "";
        int level = getHungerLevel();
        if (level >= EXTREME_HUNGER_POINT)
            rval = "REOW";
        else if (level >= HUNGER_POINT)
            rval = "meow";
        else
            rval = "purrrr";
        return rval;
    }
    
    /**
     * Get animal characteristics and add the cat's name.
     * @return string representation of a cat.
     */
    public String toString() {
        return ("\"" + name + "\" "  + super.toString());
    }
}

