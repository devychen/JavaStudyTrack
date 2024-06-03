import javax.swing.*;
import java.awt.event.*;   		// import window adapter
import java.awt.FlowLayout;		// import a FlowLayout layout manager
import java.awt.BorderLayout;	// import a BorderLayout layout manager
import java.awt.GridLayout;		// import a GridLayout layout manager
import javax.swing.BoxLayout;	// import a BoxLayout layout manager
import java.awt.Dimension;		// import Dimension
import javax.swing.JOptionPane;	// import Message dialogs
import javax.swing.event.*;

public class TestFrame10
{
	private JFrame frame;  	// Our toplevel window
	private JTextField aTextField;  /* Text field to display selection */
	JList aList;				/* list component */
	/**
	 * Constructor for TestFrame10
	 * The window has a window listener that terminates the application
	 * when the close window button is clicked. 5 Buttons are displayed
	 * in a BoxLayout
	 */
	TestFrame10()  {				
		frame = new JFrame("Test Frame 9");
		frame.setSize(300,300);   // Set window size
		
		/* Text field to edit selection */		
		
		aTextField = new JTextField(60);	
		/* Create a fixed size for the text field. Otherwise the text field
		   will stretch when the window is resized */
		aTextField.setMaximumSize(new Dimension(200,40));
			
		/* Data to display in the list */
		String[] entries = {"Fuchs","du","hast","die","Gans","gestohlen"};
		
		/*
			Create a changable ListModel for our List. We need this because
			we later want to add or remove Strings from the list!!!
		*/
		DefaultListModel aListModel = new DefaultListModel();
		for (int i=0;i<entries.length;i++)
			aListModel.addElement(entries[i]);				
		/* Create list and wrap it into a JScrollPane */
		aList = new JList(aListModel);
				
		/* connect List and SelectionListener */
		aList.addListSelectionListener(new ValueReporter());
		JScrollPane listPane = new JScrollPane(aList);
		JPanel panel1 = new JPanel();
		/*
			Override JFrames default layout manager.
		*/
		
		BoxLayout aBoxLayout = new BoxLayout(panel1,BoxLayout.Y_AXIS);
		panel1.setLayout(aBoxLayout);
		
		/* Add 5 Pixels rigid space between components */
		panel1.add(Box.createRigidArea(new Dimension(0,5)));
		panel1.add(aTextField);
		panel1.add(Box.createRigidArea(new Dimension(0,20)));
		panel1.add(listPane);
		
		/* 
			This is the common size of the buttons
		*/
		Dimension size = new Dimension(95,30);
		
		JButton addButton = new JButton("Add");
		addButton.setMaximumSize(size);
		addButton.addActionListener(new addButtonHandler());
	
		JButton rmButton = new JButton("Remove");
		rmButton.setMaximumSize(size);
		rmButton.addActionListener(new rmButtonHandler());
		
		//JButton editButton = new JButton("Edit");
		//editButton.setMaximumSize(size);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setMaximumSize(size);
		quitButton.addActionListener(new quitButtonHandler());
		
		JPanel panel2 = new JPanel();
		panel2.add(Box.createRigidArea(new Dimension(0,5)));
		panel2.add(addButton);
		panel2.add(Box.createRigidArea(new Dimension(0,15)));
		panel2.add(rmButton);
		panel2.add(Box.createRigidArea(new Dimension(0,5)));
		//panel2.add(editButton);
		//panel2.add(Box.createRigidArea(new Dimension(0,5)));
		panel2.add(quitButton);		
		panel2.add(Box.createVerticalGlue());
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
		
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.X_AXIS));
		frame.getContentPane().add(panel1);
		frame.getContentPane().add(Box.createRigidArea(new Dimension(5,0)));
		frame.getContentPane().add(panel2);
					
		frame.addWindowListener(new MyWindowListener());
				
		frame.setVisible( true );
	}
	
	/**
	 * ActionListeners for the JButtons
	 */
	private class addButtonHandler implements ActionListener  {
		public void actionPerformed(ActionEvent e)  {
			String s = aTextField.getText();
			
			if (s.length() > 0)  {
				int numItems = aList.getModel().getSize();
				for (int i = 0; i<numItems; i++) {
					if (aList.getModel().getElementAt(i).equals(s))  {
						JOptionPane.showMessageDialog(frame,"Word is already in list");
						aTextField.setText("");
						return;
					}
				}
				DefaultListModel aListModel = (DefaultListModel)aList.getModel();
				aListModel.addElement(s);
				aTextField.setText("");				
			} 			
		}
	}
	
	private class rmButtonHandler implements ActionListener  {
		public void actionPerformed(ActionEvent e)  {
			int elementIndex = aList.getSelectedIndex();
			if (elementIndex != -1)  {
				if (JOptionPane.showConfirmDialog(frame,"Really delete element??") ==
					 JOptionPane.YES_OPTION) {
					DefaultListModel aListModel = (DefaultListModel)aList.getModel();
					aListModel.remove(elementIndex);
				}
			}
		}
	}
	
	private class quitButtonHandler implements ActionListener  {
		public void actionPerformed(ActionEvent e)  {
			System.exit(0);
		}
	}
	
	/**
	 * ActionListeners for the JButtons
	 */
	private class firstButtonHandler implements ActionListener  {
		public void actionPerformed(ActionEvent e)  {
			JOptionPane.showMessageDialog(frame,"First button was clicked");
		}
	}
	
	private class ValueReporter implements ListSelectionListener {
    	public void valueChanged(ListSelectionEvent event) {
//       		if (!event.getValueIsAdjusting())  {
// 				JList l = (JList) event.getSource();								
//         		aLabel.setText(l.getSelectedValue().toString());
// 			}
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
	 * Open a TestFrame10
	 */
	public static void main ( String[] args )
	{
		TestFrame10 aFrame = new TestFrame10();
	}  
}

 
