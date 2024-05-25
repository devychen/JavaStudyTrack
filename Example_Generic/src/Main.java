// After define the Class `IntegerPrinter`

/*
public class Main {
    public static void main(String[] args) {
        IntegerPrinter printer = new IntegerPrinter(23);
        printer.print();
    }
}
*/



    /*
    this shall print out the number 23
    but what if we want to do the same thing but take in `double`,
    then we will have to create another class `DoublePrinter`
    that is just a copy of `IntegerPrinter` instead of the type.
    And so on for other types.
    Which is redundant.

    So instead, we will use a GENERIC: one class flexible for several types
    We define a Class `Printer` instead of a `IntegerPrinter` (see class file).
    And then replace the `IntegerPrinter` to the new `Printer` in this file.
    i.e.:
    */

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Printer<Integer> printer = new Printer<>(23);    // Printer is a raw type
                                                       // references to generic type Printer<T> should be parameterised
                                                       // i.e. we need tell java we want a printer for integer
        printer.print();

        // we could continue
        Printer<Double> doublePrinter = new Printer<>(33.5); // if ("Hey there") then error as type not fit
        doublePrinter.print();

        // example of applying in ArrayList
        ArrayList<Cat> cats = new ArrayList<>();
        // or: ArrayList<Object> cats = new ArrayList<>();
        Cat.add(new Cat());
        // Cat.add(new Dog());  This will get an error as we specified the type is Cat

    }
}





