import java.io.*;

public class Copy {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("/Users/ychen/JavaStudyTrack/output-copy.txt"));
            BufferedReader br = new BufferedReader(
                    new FileReader("/Users/ychen/JavaStudyTrack/output.txt"));
            String s;
            while ((s = br.readLine()) != null) {
                bw.write(s + "\n");
            }
            br.close();
        } catch (Exception ex) {
            return;
        }
    }
}
