
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class
 */
public class STArraysTest {

    @Test
    public void testToString() throws Exception {
        int[] intArray = {1, 3, 7, 13};
        String expected = "[1, 3, 7, 13]";
        String actual = STArrays.toString(intArray);
        assertEquals(expected, actual);
    }

    @Test
    public void testToString1() throws Exception {
        int[] intArray = {};
        String expected = "[]";
        String actual = STArrays.toString(intArray);
        assertEquals(expected, actual);
    }

    @Test
    public void testToString2() throws Exception {
        int[] intArray = {1};
        String expected = "[1]";
        String actual = STArrays.toString(intArray);
        assertEquals(expected, actual);
    }

    @Test
    public void testSlice1() throws Exception {
        int[] intArray = {1, 3, 7, 13};
        int start = 1;
        int end = 3;

        int[] expected = {3, 7};

        int[] actual = STArrays.slice(intArray, start, end);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSlice2() throws Exception {
        int[] intArray = {1, 3, 7, 13};
        int start = 1;
        int end = 1;

        int[] expected = {};

        int[] actual = STArrays.slice(intArray, start, end);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSlice3() throws Exception {
        int[] intArray = {1, 3, 7, 13};
        int start = 1;
        int end = 2;

        int[] expected = {3};

        int[] actual = STArrays.slice(intArray, start, end);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSlice4() throws Exception {
        int[] intArray = {1, 3, 7, 13};
        int start = 2;
        int end = 3;

        int[] expected = {7};

        int[] actual = STArrays.slice(intArray, start, end);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSlice5() throws Exception {
        int[] intArray = {1, 3, 7, 13};
        int start = 0;
        int end = 1;

        int[] expected = {1};

        int[] actual = STArrays.slice(intArray, start, end);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSlice6() throws Exception {
        int[] intArray = {1, 3, 7, 13};
        int start = -1;
        int end = 1;

        int[] expected = null;

        int[] actual = STArrays.slice(intArray, start, end);

        assertNull(actual);
    }

    @Test
    public void testSlice7() throws Exception {
        int[] intArray = {1, 3, 7, 13};
        int start = 3;
        int end = 7;

        int[] expected = null;

        int[] actual = STArrays.slice(intArray, start, end);

        assertNull(actual);
    }

    @Test
    public void testSlice8() throws Exception {
        int[] intArray = {1, 3, 7, 13};
        int start = 3;
        int end = 1;

        int[] expected = null;

        int[] actual = STArrays.slice(intArray, start, end);

        assertNull(actual);
    }

    @Test
    public void testSlice9() throws Exception {
        int[] intArray = {1, 3, 7, 13};
        int start = 3;
        int end = 4;

        int[] expected = {13};

        int[] actual = STArrays.slice(intArray, start, end);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSlice10() throws Exception {
        int[] intArray = {1, 3, 7, 13};
        int start = 4;
        int end = 5;

        int[] expected = null;

        int[] actual = STArrays.slice(intArray, start, end);

        assertArrayEquals(expected, actual);
    }
}
