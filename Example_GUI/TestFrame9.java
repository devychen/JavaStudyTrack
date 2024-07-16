import javax.swing.*;
import java.awt.event.*;   		// import window adapter
import java.awt.FlowLayout;		// import a FlowLayout layout manager
import java.awt.BorderLayout;	// import a BorderLayout layout manager
import java.awt.GridLayout;		// import a GridLayout layout manager
import javax.swing.BoxLayout;	// import a BoxLayout layout manager
import java.awt.Dimension;		// import Dimension
import javax.swing.JOptionPane;	// import Message dialogs
import javax.swing.event.*;

public class TestFrame9
{
	private JFrame frame;  	// Our toplevel window
	private JLabel aLabel;  /* Label to display selection */
	
	/**
	 * Constructor for TestFrame9
	 * The window has a window listener that terminates the application
	 * when the close window button is clicked. 5 Buttons are displayed
	 * in a BoxLayout
	 */
	TestFrame9()  {				
		frame = new JFrame("Test Frame 9");
		frame.setSize(200,100);
		
		/* Label to display selection */		
		aLabel = new JLabel("Nothing selected");
		
		/* Data to display in the list */
		String[] entries = {"Fuchs","du","hast","die","Gans","gestohlen"};
		
		/* Create list and wrap it into a JScrollPane */
		JList aList = new JList(entries);
		/* connect List and SelectionListener */
		aList.addListSelectionListener(new ValueReporter());
		JScrollPane listPane = new JScrollPane(aList);
		
		/*
			Override JFrames default layout manager.
		*/
		
		BoxLayout aBoxLayout = new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS);
		frame.getContentPane().setLayout(aBoxLayout);
		
		/* Add 5 Pixels rigid space between components */
		frame.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));
		frame.getContentPane().add(aLabel);
		frame.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));
		frame.getContentPane().add(listPane);
		
					
		frame.addWindowListener(new MyWindowListener());
				
		frame.setVisible( true );
	}
	
	private class ValueReporter implements ListSelectionListener {
    	public void valueChanged(ListSelectionEvent event) {
      		if (!event.getValueIsAdjusting())  {
				JList l = (JList) event.getSource();								
        		aLabel.setText(l.getSelectedValue().toString());
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
	 * Open a TestFrame9
	 */
	public static void main ( String[] args )
	{
		TestFrame9 aFrame = new TestFrame9();
	}  
}

 
