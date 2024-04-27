# BufferedReader 
Reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines. <br>

[Documentation](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html) <br>

**Buffer**
- 指缓冲区，一个存储数据的临时区域。
- "buffering characters" 意味着将从字符输入流中读取的字符存储在缓冲区中，而不是立即处理它们。
- 有助于提高读取效率，因为它允许一次读取多个字符，减少了频繁的 I/O 操作，也使得数据可以更高效地传输和处理。

Methods

`read()` to read a single chars. <br>
```
// return its Unicode
BufferedReader reader = new BufferedReader(new FileReader("file.txt")); <br>
int charCode = reader.read();
```