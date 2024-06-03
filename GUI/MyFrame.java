import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class MyFrame extends JFrame {
    public MyFrame() {
        // 设置窗口标题
        setTitle("我的第一个GUI程序");

        // 获取内容面板
        var contentPane = getContentPane();

        // 设置布局管理器为FlowLayout
        contentPane.setLayout(new FlowLayout());

        // 创建按钮
        JButton button1 = new JButton("按钮1");
        JButton button2 = new JButton("按钮2");

        // 添加按钮到内容面板
        contentPane.add(button1);
        contentPane.add(button2);

        // 设置窗口大小
        setSize(300, 200);
        
        // 设置关闭操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // 创建窗口实例
        MyFrame frame = new MyFrame();
        // 显示窗口
        frame.setVisible(true);
    }
}
