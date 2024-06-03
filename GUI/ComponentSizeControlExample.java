import javax.swing.*;
import java.awt.*;

// 在该例中，最终两个按钮因为boxlayout根据容器大小和组件布局策略的自行调整，大小一致。
// 为了手动看到效果，见manual例子

public class ComponentSizeControlExample extends JFrame {
    public ComponentSizeControlExample() {
        setTitle("控制组件大小示例");

        // 创建按钮1
        JButton button1 = new JButton("按钮1");

        // 设置按钮1的最小大小
        Dimension minSize = new Dimension(100, 50);
        button1.setMinimumSize(minSize);

        // 创建按钮2
        JButton button2 = new JButton("按钮2");

        // 设置按钮2的最大大小
        Dimension maxSize = new Dimension(150, 100);
        button2.setMaximumSize(maxSize);

        // 将按钮添加到内容面板
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(button1);
        getContentPane().add(button2);

        // 设置窗口大小和关闭操作
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        ComponentSizeControlExample frame = new ComponentSizeControlExample();
        frame.setVisible(true);
    }
}
