import java.io.*;


public class Writer {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("/Users/ychen/JavaStudyTrack/output.txt"));
            bw.write("Hello World.\n");
            bw.write("Hello World?\n");
            bw.write("Hello World!\n");
            bw.close();
        }catch(Exception ex){
            return;
        }

    }
}