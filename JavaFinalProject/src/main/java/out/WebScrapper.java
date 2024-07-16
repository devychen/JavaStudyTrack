package out;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WebScrapper {
    public String scrapeWikipediaContent(String url) throws IOException {
        // Fetch the Wikipedia page
        Document doc = Jsoup.connect(url).get();

        // Select the content within the "mw-content-text" div
        Element contentElement = doc.selectFirst("#mw-content-text");

        if (contentElement != null) {
            return contentElement.text();
        } else {
            throw new IOException("Unable to find content element on the page");
        }
    }

    public void saveContentToFile(String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("wikipedia_content.txt"))) {
            writer.write(content);
        }
    }
}

