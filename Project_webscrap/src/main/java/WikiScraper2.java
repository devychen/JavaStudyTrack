import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.FileWriter;

public class WikiScraper2 {

    public static void main(String[] args) {
        // url
        String url = "https://en.wikipedia.org/wiki/Java";

        try{
            // connect to url and analyse html
            Document doc = Jsoup.connect(url).get();

            // extract contents
            Element content = doc.getElementById("mw-content-text");

            // extract text
            String text = content.text();

            // write text to a file
            FileWriter writer = new FileWriter("extracted_text2.txt");
            writer.write(text);
            writer.close();

            System.out.println("Web scrapped successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
