import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonExample extends JFrame {
    public ButtonExample() {
        setTitle("按钮和事件监听器示例");

        // 创建按钮
        JButton button = new JButton("点击我");

        // 添加事件监听器
        button.addActionListener(new MyActionListener());

        // 将按钮添加到内容面板
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(button);

        // 设置窗口大小和关闭操作
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 自定义事件监听器类
    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 当按钮被点击时，执行这里的代码
            JOptionPane.showMessageDialog(ButtonExample.this, "按钮被点击了！");
        }
    }

    public static void main(String[] args) {
        ButtonExample frame = new ButtonExample();
        frame.setVisible(true);
    }
}
