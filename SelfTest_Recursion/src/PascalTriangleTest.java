import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PascalTriangleTest {

    @Test
    public void testPascal() {
        try {
            PascalTriangle.pascal(-1);
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        int[] result;
        int[][] expected = {
                {1},
                {1, 1},
                {1, 2, 1},
                {1, 3, 3, 1},
                {1, 4, 6, 4, 1},
                {1, 5, 10, 10, 5, 1},
                {1, 6, 15, 20, 15, 6, 1}
        };

        for (int row = 0; row < expected.length; row++) {
            result = PascalTriangle.pascal(row);
            for (int i = 0; i < expected[row].length; i++) {
                assertEquals(expected[row][i], result[i],
                        "row: " + row + " element: " + i);
            }
        }
    }
}
