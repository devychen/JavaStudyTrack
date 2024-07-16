package out;

import javax.swing.*;
import java.awt.event.*;   		// import window adapter
import java.awt.FlowLayout;		// import a FlowLayout layout manager
import java.awt.BorderLayout;	// import a BorderLayout layout manager
import java.awt.GridLayout;		// import a GridLayout layout manager
import javax.swing.BoxLayout;	// import a BoxLayout layout manager
import java.awt.Dimension;		// import Dimension
import javax.swing.JOptionPane;	// import Message dialogs

public class TestFrame8
{
	private JFrame frame;  	// Our toplevel window
	
	/**
	 * Constructor for TestFrame8
	 * The window has a window listener that terminates the application
	 * when the close window button is clicked. 5 Buttons are displayed
	 * in a BoxLayout
	 */
	TestFrame8()  {
		frame = new JFrame("Test Frame 8");
		frame.setSize(300,200);
		
		/*
			Override JFrames default layout manager.
						
		*/
		BoxLayout aBoxLayout = new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS);
		frame.getContentPane().setLayout(aBoxLayout);
		
		/*
			Add five buttons to the five different parts of the BorderLayout
		*/
		
		/* 
			This is the common size of the buttons
		*/
		Dimension size = new Dimension(80,30);
		
		/* Add 5 Pixels rigid space */
		frame.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));
		
		/* 
			Create a button, set its size and a rigid space, add an ActionListener
			then add it to the frame.
		*/
		
		JButton firstButton = new JButton("first");		
		firstButton.setMaximumSize(size);
		firstButton.addActionListener(new firstButtonHandler());
		frame.getContentPane().add(firstButton);
		frame.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));
		
		/*
			Ditto
		*/
		
		JButton secondButton = new JButton("second");
		secondButton.setMaximumSize(size);	
		secondButton.addActionListener(new secondButtonHandler());	
		frame.getContentPane().add(secondButton);
		frame.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));
		
		JButton thirdButton = new JButton("third");		
		thirdButton.setMaximumSize(size);
		thirdButton.addActionListener(new thirdButtonHandler());
		frame.getContentPane().add(thirdButton);
		frame.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));
		
		JButton fourthButton = new JButton("fourth");		
		fourthButton.setMaximumSize(size);
		fourthButton.addActionListener(new fourthButtonHandler());
		frame.getContentPane().add(fourthButton);
		
		/* 
			Add a stretchable space
		*/
		frame.getContentPane().add(Box.createVerticalGlue());
		
		JButton fifthButton = new JButton("fifth");		
		fifthButton.setMaximumSize(size);
		fifthButton.addActionListener(new fifthButtonHandler());
		frame.getContentPane().add(fifthButton);
		
					
		frame.addWindowListener(new MyWindowListener());
				
		frame.setVisible( true );
	}
	
	/**
	 * ActionListeners for the JButtons
	 */
	private class firstButtonHandler implements ActionListener  {
		public void actionPerformed(ActionEvent e)  {
			JOptionPane.showMessageDialog(frame,"First button was clicked");
		}
	}
	
	private class secondButtonHandler implements ActionListener  {
		public void actionPerformed(ActionEvent e)  {
			JOptionPane.showMessageDialog(frame,"Second button was clicked");
		}
	}
	
	private class thirdButtonHandler implements ActionListener  {
		public void actionPerformed(ActionEvent e)  {
			JOptionPane.showMessageDialog(frame,"Third button was clicked");
		}
	}
	
	private class fourthButtonHandler implements ActionListener  {
		public void actionPerformed(ActionEvent e)  {
			JOptionPane.showMessageDialog(frame,"Fourth button was clicked");
		}
	}
	
	private class fifthButtonHandler implements ActionListener  {
		public void actionPerformed(ActionEvent e)  {
			JOptionPane.showMessageDialog(frame,"Fifth button was clicked");
			new TestFrame8();
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
	 * Open a TestFrame4
	 */
	public static void main ( String[] args )
	{
		TestFrame8 aFrame = new TestFrame8();
	}  
}

 
