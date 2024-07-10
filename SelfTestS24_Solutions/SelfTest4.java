public class SelfTest4 {
    
    public static int handshake(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n must be positive");
        
        if (n <= 1)
            return 0;
        
        return (n-1) + handshake(n-1);
    }
    
    public static int[] pascal(int n) {
        if (n < 0) 
            throw new IllegalArgumentException("n must be positive");

        // Base case: row == 0, return {1}
        if (n == 0) {
            int[] row = {1};
            return row;
        }
        
        // Create array for this row (to return) and
        // set the first and last elements to 1
        int[] thisRow = new int[n+1];
        thisRow[0] = thisRow[n] = 1;
        
        // Generate the previous row
        int[] prevRow = pascal(n-1);

        // Get the ith element of thisRow (not including the first and last)
        // by adding the elements at positions i-1 and i from the previous row.
        for (int i=1; i<n; i++) {
            thisRow[i] = prevRow[i-1] + prevRow[i];
        }
        
        return thisRow;
    }
}