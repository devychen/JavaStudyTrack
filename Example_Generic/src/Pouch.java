public class Pouch<T> {
    private T value;
    public Pouch() {}
    public Pouch( T value ) { this.value = value; }
    public void set( T value ) { this.value = value; }
    public T get() { return value; }
    public boolean isEmpty() { return value != null; }
    public void empty() { value = null; }
}