public class Handshake {

    public static int handshake(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of people cannot be negative");
        }
        if (n == 0 || n == 1) {
            return 0;
        }
        return (n - 1) + handshake(n - 1);
    }

    public static void main(String[] args) {
        // Sample run to verify the method
        System.out.println(handshake(5)); // Output: 10
    }
}

