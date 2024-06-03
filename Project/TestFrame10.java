import javax.swing.*;
import java.awt.event.*;   		// 导入窗口适配器
import java.awt.FlowLayout;		// 导入流式布局管理器
import java.awt.BorderLayout;	// 导入边界布局管理器
import java.awt.GridLayout;		// 导入网格布局管理器
import javax.swing.BoxLayout;	// 导入盒式布局管理器
import java.awt.Dimension;		// 导入维度
import javax.swing.JOptionPane;	// 导入消息对话框
import javax.swing.event.*;

public class TestFrame10
{
	private JFrame frame;  	// 我们的顶级窗口
	private JTextField aTextField;  /* 用于显示选择的文本字段 */
	JList aList;				/* 列表组件 */
	/**
	 * TestFrame10的构造函数
	 * 窗口具有一个窗口监听器，当单击关闭窗口按钮时终止应用程序。
	 * 显示了5个按钮，它们采用BoxLayout布局。
	 */
	TestFrame10()  {				
		frame = new JFrame("Test Frame 9");
		frame.setSize(300,300);   // 设置窗口大小
		
		/* 用于编辑选择的文本字段 */		
		
		aTextField = new JTextField(60);	
		/* 为文本字段创建固定大小。否则，当窗口调整大小时，文本字段将会拉伸 */
		aTextField.setMaximumSize(new Dimension(200,40));
			
		/* 要在列表中显示的数据 */
		String[] entries = {"Fuchs","du","hast","die","Gans","gestohlen"};
		
		/*
			为我们的列表创建可更改的ListModel。我们需要这样做是因为
			我们稍后想要从列表中添加或删除字符串！！！
		*/
		DefaultListModel aListModel = new DefaultListModel();
		for (int i=0;i<entries.length;i++)
			aListModel.addElement(entries[i]);				
		/* 创建列表并将其包装到JScrollPane中 */
		aList = new JList(aListModel);
				
		/* 连接列表和选择监听器 */
		aList.addListSelectionListener(new ValueReporter());
		JScrollPane listPane = new JScrollPane(aList);
		JPanel panel1 = new JPanel();
		/*
			覆盖JFrame的默认布局管理器。
		*/
		
		BoxLayout aBoxLayout = new BoxLayout(panel1,BoxLayout.Y_AXIS);
		panel1.setLayout(aBoxLayout);
		
		/* 在组件之间添加5像素的刚性空间 */
		panel1.add(Box.createRigidArea(new Dimension(0,5)));
		panel1.add(aTextField);
		panel1.add(Box.createRigidArea(new Dimension(0,20)));
		panel1.add(listPane);
		
		/* 
			这是按钮的常见大小
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
	 * JButtons的ActionListeners
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
	 * JButtons的ActionListeners
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
	 * 当单击关闭窗口按钮时，我们的窗口监听器终止程序。
	 */	
	private class MyWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
	}
	
	/**
	 * 打开一个TestFrame10
	 */
	public static void main ( String[] args )
	{
		TestFrame10 aFrame = new TestFrame10();
	}  
}
