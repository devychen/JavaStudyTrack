import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListenerExample extends JFrame {
    public ButtonListenerExample() {
        setTitle("事件监听器示例");

        // 创建按钮1
        JButton button1 = new JButton("按钮1");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ButtonListenerExample.this, "按钮1被点击了！");
            }
        });

        // 创建按钮2
        JButton button2 = new JButton("按钮2");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ButtonListenerExample.this, "按钮2被点击了！");
            }
        });

        // 创建按钮3
        JButton button3 = new JButton("按钮3");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ButtonListenerExample.this, "按钮3被点击了！");
            }
        });

        // 创建按钮4
        JButton button4 = new JButton("按钮4");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ButtonListenerExample.this, "按钮4被点击了！");
            }
        });

        // 创建按钮5
        JButton button5 = new JButton("按钮5");
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ButtonListenerExample.this, "按钮5被点击了！");
            }
        });

        // 创建垂直箱式布局
        Box vbox = Box.createVerticalBox();
        vbox.add(button1);
        vbox.add(button2);
        vbox.add(button3);
        vbox.add(button4);
        vbox.add(button5);

        // 将布局添加到内容面板
        getContentPane().add(vbox);

        // 设置窗口大小和关闭操作
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        ButtonListenerExample frame = new ButtonListenerExample();
        frame.setVisible(true);
    }
}
