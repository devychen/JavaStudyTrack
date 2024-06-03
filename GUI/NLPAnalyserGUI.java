import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NLPAnalyserGUI extends JFrame {
    private JTextField inputTextField;
    private JButton searchButton, clearButton;
    private JTextArea resultTextArea;
    private JLabel exactItemLabel, caseSensitiveLabel;
    private JSlider leftNeighboursSlider, rightNeighboursSlider;

    public NLPAnalyserGUI() {
        setTitle("NLP Analyser");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem fileMenuItem1 = new JMenuItem("Open");
        JMenuItem fileMenuItem2 = new JMenuItem("Save");
        fileMenu.add(fileMenuItem1);
        fileMenu.add(fileMenuItem2);
        menuBar.add(fileMenu);

        JMenu preferencesMenu = new JMenu("Preferences");
        JMenuItem preferencesMenuItem1 = new JMenuItem("General");
        JMenuItem preferencesMenuItem2 = new JMenuItem("Language");
        preferencesMenu.add(preferencesMenuItem1);
        preferencesMenu.add(preferencesMenuItem2);
        menuBar.add(preferencesMenu);

        JMenu themeMenu = new JMenu("Theme");
        JMenuItem themeMenuItem1 = new JMenuItem("Light");
        JMenuItem themeMenuItem2 = new JMenuItem("Dark");
        themeMenu.add(themeMenuItem1);
        themeMenu.add(themeMenuItem2);
        menuBar.add(themeMenu);

        setJMenuBar(menuBar);

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Top Panel
        JPanel topPanel = new JPanel(new FlowLayout());
        inputTextField = new JTextField(20);
        searchButton = new JButton("Search");
        topPanel.add(inputTextField);
        topPanel.add(searchButton);

        // Left Bottom Panel
        // Left Bottom Panel
        JPanel leftBottomPanel = new JPanel(new GridLayout(8, 1));
        leftBottomPanel.setBorder(BorderFactory.createTitledBorder("Java Searching for:"));
        JLabel javaSearchLabel = new JLabel("Java Searching for:");
        exactItemLabel = new JLabel("Exact Item");
        caseSensitiveLabel = new JLabel("Case-sensitive");
        leftBottomPanel.add(javaSearchLabel);
        leftBottomPanel.add(exactItemLabel);
        leftBottomPanel.add(caseSensitiveLabel);
        leftBottomPanel.add(new JLabel(""));
        leftBottomPanel.add(new JLabel("Displaying:"));
        leftNeighboursSlider = new JSlider(0, 10, 2);
        rightNeighboursSlider = new JSlider(0, 10, 2);
        leftBottomPanel.add(leftNeighboursSlider);
        leftBottomPanel.add(rightNeighboursSlider);

        // Right Bottom Panel
        JPanel rightBottomPanel = new JPanel(new BorderLayout());
        rightBottomPanel.setBorder(BorderFactory.createTitledBorder("Search Results"));
        resultTextArea = new JTextArea(10, 30);
        resultTextArea.setEditable(false);
        rightBottomPanel.add(new JScrollPane(resultTextArea), BorderLayout.CENTER);
        clearButton = new JButton("Clear Search");
        rightBottomPanel.add(clearButton, BorderLayout.SOUTH);

        // Copyright Label
        JLabel copyrightLabel = new JLabel("© 2024 Java Group 11. All rights reserved.");
        mainPanel.add(copyrightLabel, BorderLayout.SOUTH);

        // Adding panels to the main panel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(leftBottomPanel, BorderLayout.WEST);
        mainPanel.add(rightBottomPanel, BorderLayout.CENTER);

        // Adding main panel to the frame
        add(mainPanel);

        // ActionListener for Search Button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform search operation here
                // Dummy implementation
                resultTextArea.setText("Search results will appear here...");
            }
        });

        // ActionListener for Clear Button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear search results
                resultTextArea.setText("");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NLPAnalyserGUI();
            }
        });
    }
}
