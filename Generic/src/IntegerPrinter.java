//First we create the class

public class IntegerPrinter {

    Integer thingToPrint;

    // constructor for this class that takes things to print
    public IntegerPrinter(Integer thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    // a method to actually print out to console:
    public void print() {
        System.out.println(thingToPrint);
    }
}
