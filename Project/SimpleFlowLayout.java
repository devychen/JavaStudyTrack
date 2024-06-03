import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class SimpleFlowLayout extends JFrame {
    public SimpleFlowLayout() {
        setTitle("简单的FlowLayout示例");

        // 获取内容面板并设置为FlowLayout
        var contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        // 添加一些按钮
        contentPane.add(new JButton("按钮1"));
        contentPane.add(new JButton("按钮2"));
        contentPane.add(new JButton("按钮3"));
        contentPane.add(new JButton("按钮4"));
        contentPane.add(new JButton("按钮5"));

        // 设置窗口大小和关闭操作
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SimpleFlowLayout frame = new SimpleFlowLayout();
        frame.setVisible(true);
    }
}
