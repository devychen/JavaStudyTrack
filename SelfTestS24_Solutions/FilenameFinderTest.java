package de.uni.tuebingen.sfs.java2;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FilenameFinderTest {

    @Test
    public void testFind1() {
        List<String> entries = FilenameFinder.findEntryAtPath("bla","src/test/resources/bla");
        assertEquals(2,entries.size());
    }

    @Test
    public void testFind2() {
        List<String> entries = FilenameFinder.findEntryAtPath("bla","src/test/resources/bla/fasel");
        assertEquals(1,entries.size());
    }

    @Test
    public void testFind3() {
        List<String> entries = FilenameFinder.findEntryAtPath("foo","src/test/resources/bla");
        assertEquals(0,entries.size());
    }

    @Test
    public void testFind4() {
        List<String> entries = FilenameFinder.findEntryAtPath("bla","src/test/resources/foo");
        assertEquals(0,entries.size());
    }

    @Test
    public void testFind5() {
        List<String> entries = FilenameFinder.findEntryAtPath("bla","src/test/resources/moo");
        assertEquals(1,entries.size());
    }

    @Test
    public void testFind6() {
        List<String> entries = FilenameFinder.findEntryAtPath("bla","src/test/resources/snook");
        assertEquals(0,entries.size());
    }

    @Test
    public void testFind7() {
        List<String> entries = FilenameFinder.findEntryAtPath("bla","src/test/resources/lunk/bla");
        assertEquals(1,entries.size());
    }

    @Test
    public void testFind8() {
        List<String> entries = FilenameFinder.findEntryAtPath("snook","src/test/resources/snook");
        assertEquals(1,entries.size());
    }
}