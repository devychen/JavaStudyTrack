public class Printer <T> {
    // define a type para, after class name but before curly braces.
    // convention `<T>`, in angle brackets.
    // the type of things that this class is able to handle.
    // could use Bound Generic <T extends Animal>, also Bound with interface <T extends Serializable>, note not `implements`

    T thingToPrint;
    // Integer thingToPrint (previously).

    public Printer(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }
    // Again using T to replace `Integer`

    public void print() {
        System.out.println(thingToPrint);
    }
}

// Note the differences between Class Printer and Class IntegerPrinter. ie with/without generic