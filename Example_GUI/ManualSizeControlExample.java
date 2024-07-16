import javax.swing.*;
import java.awt.*;

public class ManualSizeControlExample extends JFrame {
    public ManualSizeControlExample() {
        setTitle("手动控制组件大小示例");

        // 创建按钮1
        JButton button1 = new JButton("按钮1");
        button1.setPreferredSize(new Dimension(100, 50));

        // 创建按钮2
        JButton button2 = new JButton("按钮2");
        button2.setPreferredSize(new Dimension(150, 100));

        // 将按钮1添加到内容面板的左侧
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(button1, BorderLayout.WEST);

        // 将按钮2添加到内容面板的右侧
        getContentPane().add(button2, BorderLayout.EAST);

        // 设置窗口大小和关闭操作
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        ManualSizeControlExample frame = new ManualSizeControlExample();
        frame.setVisible(true);
    }
}
