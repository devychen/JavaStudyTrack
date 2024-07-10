import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class FilenameFinderTest {
    @Test
    public void testFindEntryAtPath_NoMatches() {
        List<String> result = FilenameFinder.findEntryAtPath("nonexistentFile.txt", "src/test/resources");
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindEntryAtPath_SingleMatch() {
        List<String> result = FilenameFinder.findEntryAtPath("sample.txt", "src/test/resources");
        assertEquals(1, result.size());
        assertTrue(result.get(0).endsWith("src/test/resources/sample.txt"));
    }

    @Test
    public void testFindEntryAtPath_MultipleMatches() {
        List<String> result = FilenameFinder.findEntryAtPath("duplicateFile.txt", "src/test/resources");
        assertEquals(2, result.size());
        assertTrue(result.get(0).endsWith("src/test/resources/folder1/duplicateFile.txt"));
        assertTrue(result.get(1).endsWith("src/test/resources/folder2/duplicateFile.txt"));
    }

    @Test
    public void testFindEntryAtPath_MatchInSubdirectory() {
        List<String> result = FilenameFinder.findEntryAtPath("subdirFile.txt", "src/test/resources");
        assertEquals(1, result.size());
        assertTrue(result.get(0).endsWith("src/test/resources/subfolder/subdirFile.txt"));
    }
}
