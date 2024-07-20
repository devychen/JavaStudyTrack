package Drafts;

// Import necessary packages

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends JFrame {

    /****** THE IVS ******/
    // Labels
    private JLabel inputLabel, urlLabel, lLabel, rLabel;
    // Sliders
    private JSlider lSlider, rSlider;
    // Buttons
    private JButton searchButton, submitButton;
    // Text fields
    private JTextField inputWord, url;
    private JTextArea output;
    // tickbox
    private JCheckBox caseSensitiveCheckBox;

    private final CorpusBuilder cb = new CorpusBuilder();

    /****** THE PANELS ******/
    public GUI() {
        // Size and title
        setSize(1000, 600);
        setTitle("NLP Analyzer for Wikipedia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation

        // Window listener
        addWindowListener(new MyWindowListener());

        // Set BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        add(mainPanel); // Add to frame

        /****** URL PANEL ******/
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(173, 216, 230)); // Set color
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS)); // Set layout

        urlLabel = new JLabel("Enter the URL for searching:");
        urlLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        url = new JTextField(40);
        url.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        url.setPreferredSize(new Dimension(400, 25));

        // Button 1: "Submit"
        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(50, 20)); // Adjust button size
        searchButton.addActionListener(new searchButtonListener());

        panel1.add(urlLabel);
        panel1.add(url);
        panel1.add(searchButton);
        mainPanel.add(panel1);

        /****** WORD PANEL ******/
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(255, 182, 193)); // Set color
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS)); // Set layout

        inputLabel = new JLabel("Enter the word you want to search:");
        inputLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        inputWord = new JTextField(20);
        inputWord.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());

        // Checkbox for case sensitivity
        caseSensitiveCheckBox = new JCheckBox("Case-sensitive");
        caseSensitiveCheckBox.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));

        panel2.add(inputLabel);
        panel2.add(inputWord);
        panel2.add(caseSensitiveCheckBox); // Add checkbox to panel
        panel2.add(submitButton);
        mainPanel.add(panel2);

        /****** CUSTOMIZED PANEL ******/
        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(255, 255, 224)); // Set color
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS)); // Set layout

        lLabel = new JLabel("Choose a left neighbor number:");
        lLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        lSlider = new JSlider(0, 10, 1);
        lSlider.setPaintTicks(true);
        lSlider.setMajorTickSpacing(1);
        lSlider.setPaintLabels(true);

        rLabel = new JLabel("Choose a right neighbor number:");
        rLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        rSlider = new JSlider(0, 10, 1);
        rSlider.setPaintTicks(true);
        rSlider.setMajorTickSpacing(1);
        rSlider.setPaintLabels(true);

        panel3.add(lLabel);
        panel3.add(lSlider);
        panel3.add(Box.createVerticalStrut(10)); // Add space
        panel3.add(rLabel);
        panel3.add(rSlider);
        mainPanel.add(panel3);

        /****** OUTPUT PANEL ******/
        output = new JTextArea();
        output.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        output.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(output);
        scrollPane.setPreferredSize(new Dimension(950, 300)); // Set desired output size

        mainPanel.add(scrollPane);

        /****** SET VISIBLE ******/
        setVisible(true);
    }

    /****** THE LISTENERS ******/
    public class searchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == searchButton) {
                try {
                    String urlText = url.getText();
                    String wikiUrl = "https://en.wikipedia.org/wiki/";
                    if (urlText.startsWith(wikiUrl)) {
                        cb.setUrl(urlText);
                        JOptionPane.showMessageDialog(getContentPane(), "URL set successfully.");
                    } else {
                        JOptionPane.showMessageDialog(getContentPane(), "Please enter a valid URL for the English Wikipedia page!");
                    }
                } catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(getContentPane(), "Invalid URL!");
                }
            }
        }
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submitButton) {
                try {
                    String word = inputWord.getText();
                    int left = lSlider.getValue();
                    int right = rSlider.getValue();
                    boolean isCaseSensitive = caseSensitiveCheckBox.isSelected();
                    String result = cb.search(word, left, right, isCaseSensitive);
                    output.setText(result);
                    if (result.isEmpty()) {
                        JOptionPane.showMessageDialog(getContentPane(), "No such word is found.");
                    }
//                } catch (IOException e1) {
//                    JOptionPane.showMessageDialog(getContentPane(), "Error: " + e1.getMessage());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(getContentPane(), "Invalid input.");
                } catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(getContentPane(), "Invalid argument.");
                }
            }
        }
    }


    private class MyWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            e.getWindow().dispose();
        }
    }

    /****** MAIN METHOD ******/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new); // Use SwingUtilities to create GUI on the Event Dispatch Thread
    }
}
