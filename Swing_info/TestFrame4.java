import javax.swing.*;
import java.awt.event.*;   		// import window adapter
import java.awt.FlowLayout;		// import a FlowLayout layout manager
import java.awt.BorderLayout;	// import a BorderLayout layout manager
import java.awt.Dimension;		// import Dimension
public class TestFrame4
{
	private JFrame frame;  	// Our toplevel window
	
	/**
	 * Constructor for TestFrame4
	 * The window has a window listener that terminates the application
	 * when the close window button is clicked. 5 Buttons are displayed
	 * in the 5 areas of a BorderLayout
	 */
	TestFrame4()  {
		/*
			Create a toplevel window with window title 
			"Test Frame 4"
		*/
		frame = new JFrame("Test Frame 4");
		frame.setSize(300,200);
		
		/*
			Add five buttons to the five different parts of the BorderLayout
		*/		
		
		JButton centerButton = new JButton("Center");		
		frame.getContentPane().add(BorderLayout.CENTER,centerButton);
		
		JButton northButton = new JButton("North");		
		frame.getContentPane().add(BorderLayout.NORTH,northButton);
		
		JButton southButton = new JButton("South");		
		frame.getContentPane().add(BorderLayout.SOUTH,southButton);

		JButton eastButton = new JButton("East");		
		frame.getContentPane().add(BorderLayout.EAST,eastButton);
		
		JButton westButton = new JButton("West");		
		frame.getContentPane().add(BorderLayout.WEST,westButton);
		
		/*
			Add a window listener
		*/	
					
		frame.addWindowListener(new MyWindowListener());
				
		frame.setVisible( true );   // show window
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
		TestFrame4 aFrame = new TestFrame4();
	}  
}

 
