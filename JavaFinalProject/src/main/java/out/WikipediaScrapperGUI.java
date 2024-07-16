package out;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WikipediaScrapperGUI {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Wikipedia Scraper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);

        // Create the panel
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Set the frame visibility to true
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Create JLabel
        JLabel userLabel = new JLabel("Wikipedia URL:");
        userLabel.setBounds(10, 20, 120, 25);
        panel.add(userLabel);

        // Create JTextField
        JTextField userText = new JTextField(20);
        userText.setBounds(140, 20, 220, 25);
        panel.add(userText);

        // Create JButton
        JButton proceedButton = new JButton("Proceed");
        proceedButton.setBounds(140, 60, 120, 25);
        panel.add(proceedButton);

        // Add action listener to the button
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = userText.getText();
                WebScrapper scraper = new WebScrapper();
                try {
                    String content = scraper.scrapeWikipediaContent(url);
                    scraper.saveContentToFile(content);
                    JOptionPane.showMessageDialog(panel, "Content saved to wikipedia_content.txt");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
                }
            }
        });
    }
}
