package de.uni.tuebingen.sfs.java2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilenameFinder {
    /**
     * Collect file or directory names equal to {@code entryName} and store the absolute pathname to the found entry
     * in a List. Start the collection at path {@code path}. If {@code path} is a directory continue collection
     * in its sub directories.
     * @param entryName Name to search for
     * @param path root of search
     * @return List with found items or empty list if nothing was found.
     */
    public static List<String> findEntryAtPath(String entryName, String path) {
        List<String> entryList = new ArrayList<>();

        File fileOrDir = new File(path);

        // Collect all entries into entryList
        realFind(entryList, entryName, fileOrDir);

        return entryList;
    }

    private static void realFind(List<String> entryList, String entryName, File fileOrDir) {
        // If name matches add absolute path to list
        if (fileOrDir.getName().equals(entryName)) {
            entryList.add(fileOrDir.getAbsolutePath());
        }

        // if entry is a directory search all directory members for entryName
        if (fileOrDir.isDirectory()) {
            File[] directoryList = fileOrDir.listFiles();

            if (directoryList == null) {
                return;
            }

            for (File currentFile : directoryList) {
                realFind(entryList, entryName, currentFile);
            }
        }
    }
}
