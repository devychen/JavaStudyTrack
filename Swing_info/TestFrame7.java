import javax.swing.*;
import java.awt.event.*;   		// import window adapter
import java.awt.FlowLayout;		// import a FlowLayout layout manager
import java.awt.BorderLayout;	// import a BorderLayout layout manager
import java.awt.GridLayout;		// import a GridLayout layout manager
import javax.swing.BoxLayout;	// import a BoxLayout layout manager
import java.awt.Dimension;		// import Dimension

public class TestFrame7
{
	private JFrame frame;  	// Our toplevel window
	
	/**
	 * Constructor for TestFrame7
	 * The window has a window listener that terminates the application
	 * when the close window button is clicked. 5 Buttons are displayed
	 * in a BoxLayout
	 */
	TestFrame7()  {
		frame = new JFrame("Test Frame 7");
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
		
		frame.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));
		
		/* 
			Create a button, set its size and a rigid space, then add it to the 
			frame.
		*/
		JButton firstButton = new JButton("first");		
		firstButton.setMaximumSize(size);
		frame.getContentPane().add(firstButton);
		frame.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));
		
		
		JButton secondButton = new JButton("second");
		secondButton.setMaximumSize(size);		
		frame.getContentPane().add(secondButton);
		frame.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));
		
		JButton thirdButton = new JButton("third");		
		thirdButton.setMaximumSize(size);
		frame.getContentPane().add(thirdButton);
		frame.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));
		
		JButton fourthButton = new JButton("fourth");		
		fourthButton.setMaximumSize(size);
		frame.getContentPane().add(fourthButton);
		
		frame.getContentPane().add(Box.createVerticalGlue());
		
		JButton fifthButton = new JButton("fifth");		
		fifthButton.setMaximumSize(size);
		frame.getContentPane().add(fifthButton);
		
					
		frame.addWindowListener(new MyWindowListener());
				
		frame.setVisible( true );
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
		TestFrame7 aFrame = new TestFrame7();
	}  
}

 
