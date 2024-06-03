import javax.swing.*;
import java.awt.event.*;   		// import window adapter
import java.awt.FlowLayout;		// import a FlowLayout layout manager
import java.awt.BorderLayout;	// import a BorderLayout layout manager
import java.awt.GridLayout;		// import a GridLayout layout manager
import java.awt.Dimension;		// import Dimension

public class TestFrame61
{
	private JFrame frame;  	// Our toplevel window
	
	/**
	 * Constructor for TestFrame5
	 * The window has a window listener that terminates the application
	 * when the close window button is clicked. 5 Buttons are displayed
	 * in a GridLayout
	 */
	TestFrame61()  {
		frame = new JFrame("Test Frame 61");
		frame.setSize(300,200);
		
		/*
			Override JFrames default layout manager.
						
		*/
		GridLayout aGridLayout = new GridLayout();
		frame.getContentPane().setLayout(aGridLayout);
		
		/*
			Add five buttons to the five different parts of the BorderLayout
		*/
		
		Dimension size = new Dimension(30,20);
		
		JButton firstButton = new JButton("first");		
		firstButton.setMaximumSize(size);
		frame.getContentPane().add(firstButton);
		
		JButton secondButton = new JButton("second");		
		frame.getContentPane().add(secondButton);
		
		JButton thirdButton = new JButton("third");	
		thirdButton.addActionListener(new thirdButtonHandler());	
		frame.getContentPane().add(thirdButton);

		JButton fourthButton = new JButton("fourth");		
		frame.getContentPane().add(fourthButton);
		
		JButton fifthButton = new JButton("filfth");		
		fifthButton.addActionListener(new fifthButtonHandler());
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
	
	 private class fifthButtonHandler implements ActionListener  {
        public void actionPerformed(ActionEvent e)  {
        	JOptionPane.showMessageDialog(frame,"Fifth button was clicked");
            
            GridLayout g = (GridLayout) frame.getContentPane().getLayout();
            System.out.println("A: "+g.getRows());
            System.out.println("B: "+g.getColumns());
            
            frame.getContentPane().removeAll();
            
            g.setRows(3);
            
			Dimension size = new Dimension(30,20);
		
			JButton firstButton = new JButton("alpha");		
			firstButton.setMaximumSize(size);
			frame.getContentPane().add(firstButton);
			
			JButton secondButton = new JButton("beta");		
			frame.getContentPane().add(secondButton);
			
			JButton thirdButton = new JButton("blocker");		
			frame.getContentPane().add(thirdButton);
	
			JButton fourthButton = new JButton("tiger");		
			frame.getContentPane().add(fourthButton);
			
			JButton fifthButton = new JButton("saft");		
			frame.getContentPane().add(fifthButton);
			
			frame.getContentPane().add(new JButton("lemone")); 
			           
            frame.getContentPane().add(new JButton("birne")); 
            
            
        }
    }
        
    private class thirdButtonHandler implements ActionListener  {
        public void actionPerformed(ActionEvent e)  {
        	JOptionPane.showMessageDialog(frame,"Third button was clicked");
            
            GridLayout g = (GridLayout) frame.getContentPane().getLayout();
            
            int n=g.getRows();
            
            if (n==2)
            	g.setRows(3);
            else
            	g.setRows(2);
            
            //frame.invalidate();
            frame.getContentPane().doLayout();
            //g.layoutContainer(frame.getContentPane());
        }
    }
          
	/**
	 * Open a TestFrame4
	 */
	public static void main ( String[] args )
	{
		TestFrame61 aFrame = new TestFrame61();
	}  
}

 
