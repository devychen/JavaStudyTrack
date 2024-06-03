import javax.swing.*;
import java.awt.event.*;   		// import window adapter
import java.awt.FlowLayout;		// import a FlowLayout layout manager
import java.awt.BorderLayout;	// import a BorderLayout layout manager

public class TestFrame3
{
	private JFrame frame;  	// Our toplevel window
	
	/**
	 * Constructor for TestFrame3
	 * The window has a window listener that terminates the application
	 * when the close window button is clicked. Two labels are displayed
	 * with a FlowLayout manager
	 */
	TestFrame3()  {
		/*
			Create a toplevel window with window title 
			"Test Frame 3"
		*/
		frame = new JFrame("Test Frame 3");
		frame.setSize(300,200); 	// set window size
						
		/*
			Override JFrames default layout manager.
			
			Components are left aligned and have a horizontal space of
			10 and a vertical space of 20 pixels
		*/
		FlowLayout aFlowLayout = new FlowLayout(FlowLayout.LEFT,10,20);
		frame.getContentPane().setLayout(aFlowLayout);
		
		/*
			Add two label to the content pane of frame
		*/

		JLabel aLabel = new JLabel("Hello World");
		frame.getContentPane().add(aLabel);
		
		JLabel aLabel1 = new JLabel("Hello World2");
		frame.getContentPane().add(aLabel1);
		
		/*
			Add a window listener
		*/	
		frame.addWindowListener(new MyWindowListener());
				
		frame.setVisible( true );  // show window
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
	 * Open a TestFrame3
	 */
	public static void main ( String[] args )
	{
		TestFrame3 aFrame = new TestFrame3();
	}  
}

 
