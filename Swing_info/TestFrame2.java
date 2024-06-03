import javax.swing.*;
import java.awt.event.*;   	// load window adapter

public class TestFrame2
{
	private JFrame frame;  	// Our toplevel window
	
	/**
	 * Constructor for TestFrame2 
	 * The window has a window listener that terminates the application
	 * when the close window button is clicked. 
	 */
	TestFrame2()  {
		frame = new JFrame("Test Frame 2");
		frame.setSize(200,100);
			
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
	 * Open a TestFrame2
	 */
	public static void main ( String[] args )
	{
		TestFrame2 aFrame = new TestFrame2();
	}  
}

 
