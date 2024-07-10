public class PascalTriangle {

    public static int[] pascal(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Row number cannot be negative");
        }
        if (n == 0) {
            return new int[]{1};
        }
        int[] previousRow = pascal(n - 1);
        int[] currentRow = new int[n + 1];
        currentRow[0] = 1;
        currentRow[n] = 1;
        for (int i = 1; i < n; i++) {
            currentRow[i] = previousRow[i - 1] + previousRow[i];
        }
        return currentRow;
    }

    public static void main(String[] args) {
        // Sample run to verify the method
        int[] result = pascal(5);
        for (int i : result) {
            System.out.print(i + " ");
        }
        // Output: 1 5 10 10 5 1
    }
}
