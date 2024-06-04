

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * SnowFlakeGUI. A GUI to display snow flakes. It offers multiple ways to set
 * the flakes' parameters such as size, number, background and flake color.
 *
 * @author Chen
 */
@SuppressWarnings("serial")
public class SnowFlakeGUI extends JFrame {

    private SnowFlakeCanvas snowFlakeCanvas;
    private JColorChooser chooser;
    private JButton paintButton;
    private JTextField minBeamLength, maxBeamLength;
    private JComboBox numFlakes;
    private JRadioButton randomColor, fixedColor;
    private JTextField redValue, greenValue, blueValue;
    JLabel redLabel, greenLabel, blueLabel;

    /**
     * Default constructor.
     */
    public SnowFlakeGUI() {
        // set Size and title 
        setSize(1000, 800);
        setTitle("Selftest Swing/GUI");

        // add WindowListener
        addWindowListener(new MyWindowListener());

        // set general layout to a BorderLayout
        BorderLayout mainLayout = new BorderLayout();
        getContentPane().setLayout(mainLayout);

        // set up the 5 regions of the BorderLayout
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
        numFlakes.setEditable(true);    // this allows you to pick a number freely beyond the given selection


        // add the components to the panel.
        // Use flexible (Glue) and fix (Strut) fillers.
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
        colorGroup.add(fixedColor); // 互斥，仅能选择一个
        fixedColor.setSelected(true); // 默认选中

        // connect the buttons to ActionListener
        ColorListener myColorListener = new ColorListener();
        randomColor.addActionListener(myColorListener);
        fixedColor.addActionListener(myColorListener);

        // TODO setup labels and text fields to enter r, g and b value for a fixed color
        redLabel = new JLabel("Red");
        redValue = new JTextField(0);
        redValue.setPreferredSize(textFieldDim);
        redValue.setText("0");
        redValue.setToolTipText("Enter Integers Between 0 and 255!");

        greenLabel = new JLabel("Green");
        greenValue = new JTextField(0);
        greenValue.setPreferredSize(textFieldDim);
        greenValue.setText("0");
        greenValue.setToolTipText("Enter Integers Between 0 and 255!");

        blueLabel = new JLabel("Blue");
        blueValue = new JTextField(0);
        blueValue.setPreferredSize(textFieldDim);
        blueValue.setText("0");
        blueValue.setToolTipText("Enter Integers Between 0 and 255!");

        // add components to the panel.
        eastPanel.add(Box.createVerticalGlue());
        eastPanel.add(randomColor);
        eastPanel.add(fixedColor);
        eastPanel.add(Box.createVerticalStrut(3));

        // TODO add those labels and text fields to the panel
        eastPanel.add(redLabel);
        eastPanel.add(Box.createVerticalStrut(3));
        eastPanel.add(redValue);
        eastPanel.add(Box.createVerticalStrut(15));

        eastPanel.add(greenLabel);
        eastPanel.add(Box.createVerticalStrut(3));
        eastPanel.add(greenValue);
        eastPanel.add(Box.createVerticalStrut(15));

        eastPanel.add(blueLabel);
        eastPanel.add(Box.createVerticalStrut(3));
        eastPanel.add(blueValue);
        eastPanel.add(Box.createVerticalStrut(15));


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
            //TODO implement this method
            try {
                // set parameters
                int minBeam = Integer.parseInt(minBeamLength.getText()); // using `Integer.parseInt`: from string-getText() to int
                int maxBeam = Integer.parseInt(maxBeamLength.getText());

                // show dialog when values do not match
                if (maxBeam < minBeam) {
                    JOptionPane.showMessageDialog(getContentPane(), "Max beam length must be greater than min beam length!");
                    return;
                }
                // check if random color is wanted
                if (randomColor.isSelected()) {
                    snowFlakeCanvas.setFlakeColor(null);
                } // or fixed color
                else {
                    int r = Integer.parseInt(redValue.getText());
                    int g = Integer.parseInt(greenValue.getText());
                    int b = Integer.parseInt(blueValue.getText());

                    snowFlakeCanvas.setFlakeColor(new Color(r, g, b));
                }
                // get requested number of flakes
                int flakes = (Integer) numFlakes.getSelectedItem();
                // get requested background color from color chooser
                Color backGroundColor = chooser.getColor();

                // pass to SnowFlakeCanvas, set canvas manually
                snowFlakeCanvas.setBackground(backGroundColor);
                snowFlakeCanvas.setMinBeamLen(minBeam);
                snowFlakeCanvas.setMaxBeamLen(maxBeam);
                snowFlakeCanvas.setNumFlakes(flakes);

                snowFlakeCanvas.repaint();
            } // thrown e when text field input cannot be parsed as an integer
            catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(getContentPane(), "Beam lengh and color values must be integers!");
            } // when rgb value out of range
            catch (IllegalArgumentException e2) {
                JOptionPane.showMessageDialog(getContentPane(), "RGB value must be 0~255");
            }
        }
    }

    /*
     * ActionListener for the radio buttons
     */
    private class ColorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO implement this method
            if (randomColor.isSelected()) {

                // disable all components for rgb value input
                redLabel.setEnabled(false);
                greenLabel.setEnabled(false);
                blueLabel.setEnabled(false);

                redValue.setEnabled(false);
                greenValue.setEnabled(false);
                blueValue.setEnabled(false);
            } // or enable them
            else {
                redLabel.setEnabled(true);
                greenLabel.setEnabled(true);
                blueLabel.setEnabled(true);

                redValue.setEnabled(true);
                greenValue.setEnabled(true);
                blueValue.setEnabled(true);
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
