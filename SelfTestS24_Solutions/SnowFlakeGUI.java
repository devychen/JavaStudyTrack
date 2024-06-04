
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * SnowFlakeGUI. A GUI to display snow flakes. It offers multiple ways to set
 * the flakes' parameters such as size, number, background and flake color.
 *
 * @author veit
 */
@SuppressWarnings("serial")
public class SnowFlakeGUI extends JFrame {

    private SnowFlakeCanvas snowFlakeCanvas;
    private JColorChooser chooser;
    private JButton paintButton;
    private JTextField minBeamLength, maxBeamLength;
    private JComboBox numFlakes;
    private JRadioButton randomColor, fixedColor;
    private JTextField red, green, blue;
    JLabel redLabel, greenLabel, blueLabel;

    /**
     * Default constructor.
     */
    public SnowFlakeGUISolution() {
        // set Size and title 
        setSize(1000, 800);
        setTitle("Selftest Swing/GUI");

        // add WindowListener
        addWindowListener(new MyWindowListener());

        // set general layout to a BorderLayout
        BorderLayout mainLayout = new BorderLayout();
        getContentPane().setLayout(mainLayout);


        // setup the 5 regions of the BorderLayout
        setUpNorth();
        setUpCenter();
        setUpSouth();
        setUpWest();
        setUpEast();
    }

    /*
     * Fill the West Section.
     */
    private void setUpWest() {
        // set up the main panel for the west. Use a vertical BoxLayout!
        JPanel westPanel = new JPanel();
        BoxLayout westLayout = new BoxLayout(westPanel, BoxLayout.Y_AXIS);
        westPanel.setLayout(westLayout);

        Dimension textFieldDim = new Dimension(50, 20);


        // set up JLabels and JTextFields (note: you can use html notation to format Strings)
        JLabel minBeamLabel = new JLabel("<html>Minimum<br />Beam Length:</html>");
        minBeamLength = new JTextField(0);
        minBeamLength.setPreferredSize(textFieldDim);
        minBeamLength.setMaximumSize(textFieldDim);
        minBeamLength.setText("5");
        minBeamLength.setToolTipText("Enter only Integers!");

        JLabel maxBeamLabel = new JLabel("<html>Maximum<br />Beam Length:</html>");
        maxBeamLength = new JTextField(0);
        maxBeamLength.setPreferredSize(textFieldDim);
        maxBeamLength.setMaximumSize(textFieldDim);
        maxBeamLength.setText("20");
        maxBeamLength.setToolTipText("Enter only Integers!");

        JLabel backGroundLabel = new JLabel("<html>Background<br />color:</html>");

        // set up the JComboBox to choose the number of flakes
        JLabel numFlakesLabel = new JLabel("<html>Number<br />of Flakes:</html>");
        numFlakes = new JComboBox(new Integer[]{3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45});
        numFlakes.setSelectedIndex(9);
        numFlakes.setPreferredSize(textFieldDim);
        numFlakes.setMaximumSize(textFieldDim);
        //numFlakes.setEditable(true);    // this allows you to pick a number freely beyond the given selection



        // add the components to the panel. Use flexible (Glue) and fix (Strut) fillers.
        westPanel.add(Box.createVerticalGlue());

        westPanel.add(minBeamLabel);
        westPanel.add(Box.createVerticalStrut(3));
        westPanel.add(minBeamLength);

        westPanel.add(Box.createVerticalStrut(15));

        westPanel.add(maxBeamLabel);
        westPanel.add(Box.createVerticalStrut(3));
        westPanel.add(maxBeamLength);

        westPanel.add(Box.createVerticalStrut(15));

        westPanel.add(numFlakesLabel);
        westPanel.add(Box.createVerticalStrut(3));
        westPanel.add(numFlakes);

        westPanel.add(Box.createVerticalGlue());

        westPanel.add(backGroundLabel);

        // finally add the panel to the main layout!
        getContentPane().add(westPanel, BorderLayout.WEST);
    }

    /*
     * Fill the East Section.
     */
    private void setUpEast() {
        // set up the main panel for the east. Use a vertical BoxLayout!
        JPanel eastPanel = new JPanel();
        BoxLayout eastLayout = new BoxLayout(eastPanel, BoxLayout.Y_AXIS);
        eastPanel.setLayout(eastLayout);
        Dimension textFieldDim = new Dimension(50, 20);

        // set up the group of radio buttons 
        ButtonGroup colorGroup = new ButtonGroup();
        randomColor = new JRadioButton("Random Colors");
        fixedColor = new JRadioButton("Set fixed Color");
        colorGroup.add(randomColor);
        colorGroup.add(fixedColor);
        fixedColor.setSelected(true);

        // connect the buttons to ActionListener
        ColorListener myColorListener = new ColorListener();
        randomColor.addActionListener(myColorListener);
        fixedColor.addActionListener(myColorListener);

        // setup labels and text fields to enter r, g and b value for a fixed color

        redLabel = new JLabel("red");
        red = new JTextField(0);
        red.setText("0");
        red.setPreferredSize(textFieldDim);
        red.setMaximumSize(textFieldDim);
        red.setToolTipText("Enter only Integers between 0 and 255!");

        greenLabel = new JLabel("green");
        green = new JTextField(0);
        green.setText("0");
        green.setPreferredSize(textFieldDim);
        green.setMaximumSize(textFieldDim);
        green.setToolTipText("Enter only Integers between 0 and 255!");

        blueLabel = new JLabel("blue");
        blue = new JTextField(0);
        blue.setText("0");
        blue.setPreferredSize(textFieldDim);
        blue.setMaximumSize(textFieldDim);
        blue.setToolTipText("Enter only Integers between 0 and 255!");

        // add components to the panel.
        eastPanel.add(Box.createVerticalGlue());
        eastPanel.add(randomColor);
        eastPanel.add(fixedColor);
        eastPanel.add(Box.createVerticalStrut(3));

        // add those labels and text fields to the panel		
        eastPanel.add(redLabel);
        eastPanel.add(Box.createVerticalStrut(3));
        eastPanel.add(red);
        eastPanel.add(Box.createVerticalStrut(15));

        eastPanel.add(greenLabel);
        eastPanel.add(Box.createVerticalStrut(3));
        eastPanel.add(green);
        eastPanel.add(Box.createVerticalStrut(15));

        eastPanel.add(blueLabel);
        eastPanel.add(Box.createVerticalStrut(3));
        eastPanel.add(blue);
        eastPanel.add(Box.createVerticalGlue());

        // finally add panel to the main layout
        getContentPane().add(eastPanel, BorderLayout.EAST);
    }

    /*
     * Fill the North Section.
     */
    private void setUpNorth() {
        // set up a JLabel for the Headline
        JLabel headLineLabel = new JLabel("SnowFlakeGUI");
        headLineLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

        // nested BoxLayouts (vertical and horizontal) with glue are nice to center components
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        JPanel northCenterPanel = new JPanel();
        northCenterPanel.setLayout(new BoxLayout(northCenterPanel, BoxLayout.X_AXIS));

        northCenterPanel.add(Box.createHorizontalGlue());
        northCenterPanel.add(headLineLabel);
        northCenterPanel.add(Box.createHorizontalGlue());

        northPanel.add(Box.createVerticalStrut(20));
        northPanel.add(northCenterPanel);
        northPanel.add(Box.createVerticalStrut(20));

        // add the outermost panel to the main layout
        getContentPane().add(northPanel, BorderLayout.NORTH);
    }

    /*
     * Fill the Center Section.
     */
    private void setUpCenter() {
        // set up a SnowFlakeCanvas and add it to the center of the main layout
        snowFlakeCanvas = new SnowFlakeCanvas();
        snowFlakeCanvas.setBackground(Color.white);
        getContentPane().add(snowFlakeCanvas, BorderLayout.CENTER);
    }

    /*
     * Fill the South Section.
     */
    private void setUpSouth() {
        // set up a panel for the south. Choose a horizontal BoxLayout.
        JPanel southPanel = new JPanel();
        BoxLayout southLayout = new BoxLayout(southPanel, BoxLayout.X_AXIS);
        southPanel.setLayout(southLayout);

        // set up a color chooser
        chooser = new JColorChooser();
        chooser.setPreviewPanel(new JPanel());
        Dimension dim = new Dimension(400, 300);
        chooser.setMaximumSize(dim);

        // set up the paint button
        paintButton = new JButton("paint");
        paintButton.addActionListener(new PaintButtonListener());

        // add components to the panel
        southPanel.add(chooser);

        southPanel.add(Box.createHorizontalGlue());
        southPanel.add(paintButton);
        southPanel.add(Box.createHorizontalGlue());

        // add the panel to the main layout
        getContentPane().add(southPanel, BorderLayout.SOUTH);
    }

    /*
     * WindowAdapter. So we can close each window at a time.
     */
    private class MyWindowListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            e.getWindow().dispose();
        }
    }

    /*
     * ActionListener for the paint button.
     */
    private class PaintButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // read values from text fields, combo boxes, choosers and radio buttons.
            try {
                // get min and max beam length
                int min = Integer.parseInt(minBeamLength.getText());
                int max = Integer.parseInt(maxBeamLength.getText());

                // show dialog when values do not match
                if (max < min) {
                    JOptionPane.showMessageDialog(getContentPane(), "Max beam length cannot be less than min beam length!");
                    return;
                }
                // check if random color is wanted...
                if (randomColor.isSelected()) {
                    snowFlakeCanvas.setFlakeColor(null);
                } // ... or a fixed color
                else {
                    int r = Integer.parseInt(red.getText());
                    int g = Integer.parseInt(green.getText());
                    int b = Integer.parseInt(blue.getText());

                    snowFlakeCanvas.setFlakeColor(new Color(r, g, b));
                }
                // get requested number of flakes
                int num = (Integer) numFlakes.getSelectedItem();
                // get requested background color from chooser
                Color backGroundColor = chooser.getColor();

                // set canvas accordingly
                snowFlakeCanvas.setBackground(backGroundColor);
                snowFlakeCanvas.setMinBeamLen(min);
                snowFlakeCanvas.setMaxBeamLen(max);
                snowFlakeCanvas.setNumFlakes(num);
                snowFlakeCanvas.repaint();

            } // This Exception is thrown when text field input cannot be parsed as an integer
            catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(getContentPane(), "Beam lengthes and color values must be integers!");
            } // This Exception is thrown when one of rgb values is out of range
            catch (IllegalArgumentException e1) {
                JOptionPane.showMessageDialog(getContentPane(), "RGB values must be between 0 and 255!");
            }

        }
    }

    /*
     * ActionListener for the radio buttons
     */
    private class ColorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (randomColor.isSelected()) {

                // disable all components for rgb value input
                redLabel.setEnabled(false);
                greenLabel.setEnabled(false);
                blueLabel.setEnabled(false);

                red.setEnabled(false);
                green.setEnabled(false);
                blue.setEnabled(false);
            } // or enable them
            else {
                redLabel.setEnabled(true);
                greenLabel.setEnabled(true);
                blueLabel.setEnabled(true);

                red.setEnabled(true);
                green.setEnabled(true);
                blue.setEnabled(true);
            }
        }
    }

    /**
     * Main method. Crate a SnowFlakeGui and show it on the screen.
     *
     * @param args
     */
    public static void main(String[] args) {
        SnowFlakeGUI sfg = new SnowFlakeGUI();
        sfg.setVisible(true);
    }
}
