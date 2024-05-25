import java.io.*;

public class Reader {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(
                    new FileReader("/Users/ychen/JavaStudyTrack/output.txt"));
            String s;
            while ((s = br.readLine()) != null) {  // when reach the end of the file
                // this `br.readLine()` will return to null.
                System.out.println(s);
            }
            br.close();
        } catch(Exception ex){
            return;
        }
    }
}
