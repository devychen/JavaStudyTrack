
/**
 * This class contains various methods for manipulating arrays.
 */
public class STArrays {

    /**
     * Returns a string representation of the contents of the specified array.
     * The string representation consists of a list of the array's elements,
     * enclosed in square brackets ("[]"). Adjacent elements are separated by
     * the characters ", " (a comma followed by a space).
     *
     * @param anIntArray Array whose string representation to return.
     *
     * @return A string representation of the contents of the specified array.
     */
    public static String toString(int[] anIntArray) {
        String res = "[";

        for (int i = 0; i < anIntArray.length; i++) {
            res += anIntArray[i];
            if (i < anIntArray.length - 1) {
                res += ", ";
            }
        }

        res += "]";

        return res;
    }

    /**
     * Copies the specified range of the specified array into a new array and
     * returns the new array.
     *
     * @param anIntArray the array from which a slice is to be copied.
     * @param start the initial index of the range to be copied, inclusive.
     * @param end the final index of the range to be copied, exclusive. (This
     * index may lie outside the array.)
     *
     * @return an array with the specified range of the specified array or
     * <b>null</b> when:<br> {@code anIntArray == null}<br>
     * or<br>
     * {@code start < 0 || end > anIntArray.length || start > anIntArray.length}<br>
     * or<br> {@code end < start}<br>
     * or<br> {@code start > end}
     */
    public static int[] slice(int[] anIntArray, int start, int end) {
        if (anIntArray == null) {
            return null;
        }

        if (start < 0 || end > anIntArray.length || start > anIntArray.length) {
            return null;
        }

        if (end < start) {
            return null;
        }

        if (start > end) {
            return null;
        }

        int retLen = end - start;

        int[] ret = new int[retLen];
        for (int j = 0, i = start; i < end; i++, j++) {
            ret[j] = anIntArray[i];
        }

        return ret;
    }

}
