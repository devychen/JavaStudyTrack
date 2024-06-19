package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


public class GUI extends JFrame {
    private JSlider aSlider, bSlider;
    private JLabel aLabel, bLabel, cLabel, dLabel;
    private JTextField target, url;
    private JTextArea resultArea;
    private JButton searchButton, submitButton;
    private final CorpusBuilder builder = new CorpusBuilder();

    public GUI() {
        // set Size and title
        setSize(1000, 800);
        setTitle("KWIC Searcher");

        // add WindowListener
        addWindowListener(new MyWindowListener());

        // set general layout to a BorderLayout
        BorderLayout mainLayout = new BorderLayout();
        getContentPane().setLayout(mainLayout);

        // setup the 3 regions of the BorderLayout
        setUpNorth();
        setUpCenter();
        setUpEast();


    }

    private void setUpNorth() {
        // Set up a JLabel for the Headline
        dLabel = new JLabel("Enter the url for searching:");
        dLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        dLabel.setPreferredSize(new Dimension(250, 50)); // Adjust label size

        url = new JTextField(40);
        url.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        url.setPreferredSize(new Dimension(200, 20)); // Adjust text field size

        searchButton = new JButton("Submit");
        searchButton.setPreferredSize(new Dimension(100, 50)); // Adjust button size
        searchButton.addActionListener(new searchButtonListener());

        // Nested BoxLayouts (vertical and horizontal) with glue are nice to center components
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.setPreferredSize(new Dimension(700, 100)); // Adjust panel size

        JPanel northCenterPanel = new JPanel();
        northCenterPanel.setLayout(new BoxLayout(northCenterPanel, BoxLayout.X_AXIS));


        northCenterPanel.add(dLabel);
        northCenterPanel.add(url);
        northCenterPanel.add(searchButton);

        northPanel.add(Box.createVerticalStrut(20));
        northPanel.add(northCenterPanel);
        northPanel.add(Box.createVerticalStrut(20));

        northPanel.setBackground(new Color(255, 190, 152));
        northCenterPanel.setBackground(new Color(255, 190, 152));

        // Add the outermost panel to the main layout
        getContentPane().add(northPanel, BorderLayout.NORTH);
    }

    private void setUpCenter() {
        resultArea = new JTextArea();
        resultArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void setUpEast() {
        // set up the main panel for the east. Use a vertical BoxLayout!
        JPanel eastPanel = new JPanel();
        BoxLayout eastLayout = new BoxLayout(eastPanel, BoxLayout.Y_AXIS);
        eastPanel.setLayout(eastLayout);
        Dimension textFieldDim = new Dimension(500, 50);

        submitButton = new JButton("Search");
        submitButton.addActionListener(new SubmitButtonListener());

        aLabel = new JLabel("Enter the word you want to search:");
        aLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        target = new JTextField(20);
        target.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        target.setMaximumSize(textFieldDim);
        bLabel = new JLabel("Choose a left neighbor number:");
        bLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        aSlider = new JSlider(0, 10, 1);
        cLabel = new JLabel("Choose a right neighbor number:");
        cLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        bSlider = new JSlider(0, 10, 1);

        aSlider.setPaintTicks(true);
        aSlider.setMajorTickSpacing(1);
        aSlider.setPaintLabels(true);


        bSlider.setPaintTicks(true);
        bSlider.setMajorTickSpacing(1);
        bSlider.setPaintLabels(true);



        eastPanel.add(aLabel);
        eastPanel.add(target);
        eastPanel.add(Box.createVerticalStrut(10));
        eastPanel.add(bLabel);
        eastPanel.add(aSlider);
        eastPanel.add(cLabel);
        eastPanel.add(bSlider);
        eastPanel.add(Box.createVerticalStrut(30));  // Add some space before the button
        eastPanel.add(submitButton);
        eastPanel.add(Box.createVerticalGlue());


        eastPanel.setBackground(new Color(255, 190, 152));
        // finally add panel to the main layout
        getContentPane().add(eastPanel, BorderLayout.EAST);
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submitButton) {
                try {
                    String word = target.getText();
                    int left = aSlider.getValue();
                    int right = bSlider.getValue();
                    String result = builder.searchWord(word, left, right);
                    resultArea.setText(result);
                    if (result.isEmpty()){
                        JOptionPane.showMessageDialog(getContentPane(), "No such word is found. " );
                    }
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(getContentPane(), "Error: " + e1.getMessage());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(getContentPane(), "Invalid input.");
                } catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(getContentPane(), "Invalid argument.");
                }
            }
        }
    }

    private class searchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == searchButton) {
                try {
                    String urlText = url.getText();
                    String wikiUrl = "https://en.wikipedia.org/wiki";
                    if (urlText.startsWith(wikiUrl)) {
                        builder.setUrl(urlText);
                    JOptionPane.showMessageDialog(getContentPane(), "URL set successfully.");}
                    else{
                        JOptionPane.showMessageDialog(getContentPane(), "Please enter a url for Wikipedia english page!");
                    }
                } catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(getContentPane(), "Invalid URL!");
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

    public static void main(String[] args) {
        GUI sfg = new GUI();
        sfg.setVisible(true);
    }
}