# Write a method

public static List<String> findEntryAtPath(String entryName, String path)

which collects the absolute path names of all directory entries equal to `entryName` into a List of Strings. 
The method should start collecting at path `path`. 
The name of the class should be `FilenameFinder`.

Please test your code with unit tests. When you provide `resources` to your unit tests the current directory is always the project root. 
Create a folder `resources` in the project directory. Then put your test directories/files into `resources`. 
In your unit test you can then access the directories under the relative path `"resources/{your test directories/files}"` in your test.

---
Last modified: Wednesday, 18 May 2022, 10:05 AM