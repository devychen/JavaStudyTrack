# O/I 

**Readers**: <br>
Buffered~, CharArray~, Filter~, InputStream~ (File~), Piped~, String~ <br>
**Writer** <br>
Buffered~, CharArray~, Filter~, OutputStream~ (File~), Piped~, String~, Print~

## BufferedReader
[Documentation](https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html) Used to read text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines. <br>


### Working of br
**Buffer**
- 指缓冲区，一个存储数据的临时区域。
- "buffering characters" 意味着将从字符输入流中读取的字符存储在缓冲区中，而不是立即处理它们。
- 有助于提高读取效率，因为它允许一次读取多个字符，减少了频繁的 I/O 操作，也使得数据可以更高效地传输和处理。

### Methods of br

`read()` to read a single chars. <br>
```
// return its Unicode
BufferedReader reader = new BufferedReader(new FileReader("file.txt")); <br>
int charCode = reader.read();
```

## PrintWriter
[Documentation](https://docs.oracle.com/javase/8/docs/api/java/io/PrintWriter.html)
Used to write output data in a commonly readable form (text).

[Online tutorial](https://www.youtube.com/watch?v=ZKkR1CX3XDU)

### Working of pw
Unlike other writers, PrintWriter converts the primitive data (int, float, char, etc.)
into the text format. It then writes that formatted data into the writer.
- Compared to `BufferedWriter`, it contains methods for printing.
- `BufferedWriter` uses `try..catch` block for exceptions, 
while `PrintWriter` has an additional way that allows the auto-update of the buffer.
```
public class Example {
    public static void main(String[] args) {
        // Use BufferedWriter to read
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("buffered.txt"))) {
            writer.write("Hello, BufferedWriter!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Use PrintWriter to read
        try (PrintWriter writer = new PrintWriter(new FileWriter("print.txt"))) {
            writer.println("Hello, PrintWriter!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Methods of pw
- `print()` - prints the specified data to the writer.
- `println()` - prints the data to the writer along with a new line char at the end.
- `printf()` - prints the formatted string.

### From `Scanner`