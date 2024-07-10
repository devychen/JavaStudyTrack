import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilenameFinder {
    public static List<String> findEntryAtPath(String entryName, String path) {
        List<String> result = new ArrayList<>();
        findEntryAtPathHelper(entryName, new File(path), result);
        return result;
    }

    private static void findEntryAtPathHelper(String entryName, File currentDir, List<String> result) {
        if (!currentDir.isDirectory()) {
            return;
        }

        File[] files = currentDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    findEntryAtPathHelper(entryName, file, result);
                }
                if (file.getName().equals(entryName)) {
                    result.add(file.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) {
        // For manual testing purposes
        String entryName = "targetFile.txt";
        String path = "C:/path/to/start";
        List<String> results = findEntryAtPath(entryName, path);
        for (String result : results) {
            System.out.println(result);
        }
    }
}
