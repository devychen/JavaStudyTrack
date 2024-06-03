import javax.swing.*;
import java.awt.event.*;   		// import window adapter
import java.awt.FlowLayout;		// import a FlowLayout layout manager
import java.awt.BorderLayout;	// import a BorderLayout layout manager
import java.awt.GridLayout;		// import a GridLayout layout manager
import javax.swing.BoxLayout;	// import a BoxLayout layout manager
import java.awt.Dimension;		// import Dimension
import javax.swing.JOptionPane;	// import Message dialogs
import javax.swing.event.*;

public class TestFrame11
{
	private JFrame frame;  			// Our toplevel window
	private JLabel aLabel;  		/* Label to display selection */
	private JTextField aTextfield; 	// Textfield to get a String */
	/**
	 * Constructor for TestFrame11
	 * The window has a window listener that terminates the application
	 * when the close window button is clicked. 5 Buttons are displayed
	 * in a BoxLayout
	 */
	TestFrame11()  {				
		frame = new JFrame("Test Frame 11");
		frame.setSize(200,120);
		
		/* Label to display selection */		
		aLabel = new JLabel("Nothing selected");
		aTextfield = new JTextField(40);
		JButton aButton = new JButton("Change Label");
		aButton.addActionListener(new aButtonHandler());
		/*
			Override JFrames default layout manager.
		*/
		
		BoxLayout aBoxLayout = new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS);
		frame.getContentPane().setLayout(aBoxLayout);
		
		/* Add 5 Pixels rigid space between components */
		frame.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));
		frame.getContentPane().add(aLabel);
		frame.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));
		frame.getContentPane().add(aTextfield);
		frame.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));		
		frame.getContentPane().add(aButton);
		
					
		frame.addWindowListener(new MyWindowListener());
				
		frame.setVisible( true );
	}
	
	/**
	 * ActionListeners for the JButtons
	 */
	private class aButtonHandler implements ActionListener  {
		public void actionPerformed(ActionEvent e)  {
			String s = aTextfield.getText();
			if (s.length() > 0)  {
				aLabel.setText(s);
				aTextfield.setText("");
			}
		}
	}
	
	
	/**
	 * Our window listener termiates the program when the close window button 
	 * is clicked. 
	 */	
	private class MyWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
	}
	
	/**
	 * Open a TestFrame11
	 */
	public static void main ( String[] args )
	{
		TestFrame11 aFrame = new TestFrame11();
	}  
}

 
