public class GenericPouchMain {
public static void main(String[] args) {
// Pouch which holds a String
Pouch<String> stringPouch = new Pouch<>("Umu");
// Pouch which holds an Integer
Pouch<Integer> integerPouch = new Pouch<>(Integer.valueOf("12"));
//Pouch which holds a Pouch which holds a String
Pouch<Pouch<String>> pouchPouch = new Pouch<>(new Pouch<>("Fasel"));
System.out.println("Pouch value: "+stringPouch.get());
System.out.println("Pouch value: "+integerPouch.get());
System.out.println("Pouch value: "+pouchPouch.get());
}
}