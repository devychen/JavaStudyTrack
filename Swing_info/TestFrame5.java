import javax.swing.*;
import java.awt.event.*;   		// import window adapter
import java.awt.FlowLayout;		// import a FlowLayout layout manager
import java.awt.BorderLayout;	// import a BorderLayout layout manager
import java.awt.GridLayout;		// import a GridLayout layout manager
import java.awt.Dimension;		// import Dimension

public class TestFrame5
{
	private JFrame frame;  	// Our toplevel window
	
	/**
	 * Constructor for TestFrame5
	 * The window has a window listener that terminates the application
	 * when the close window button is clicked. 5 Buttons are displayed
	 * in a GridLayout
	 */
	TestFrame5()  {
		frame = new JFrame("Test Frame 5");
		frame.setSize(300,200);
		
		/*
			Override JFrames default layout manager.
						
		*/
		GridLayout aGridLayout = new GridLayout(2,3);
		frame.getContentPane().setLayout(aGridLayout);
		/*
			Add five buttons to the five different parts of the BorderLayout
		*/
		
		
		JButton firstButton = new JButton("first");		
		frame.getContentPane().add(firstButton);
		
		JButton secondButton = new JButton("second");		
		frame.getContentPane().add(secondButton);
		
		JButton thirdButton = new JButton("third");		
		frame.getContentPane().add(thirdButton);

		JButton fourthButton = new JButton("fourth");		
		frame.getContentPane().add(fourthButton);
		
		JButton fifthButton = new JButton("fifth");		
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
		TestFrame5 aFrame = new TestFrame5();
	}  
}

 
