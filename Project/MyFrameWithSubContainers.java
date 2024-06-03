import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class MyFrameWithSubContainers extends JFrame {
    public MyFrameWithSubContainers() {
        setTitle("带子容器的GUI程序");

        // 获取内容面板
        var contentPane = getContentPane();
        
        // 设置布局管理器为BorderLayout
        contentPane.setLayout(new BorderLayout());

        // 创建一个子容器，使用GridLayout
        JPanel subContainer = new JPanel();
        subContainer.setLayout(new GridLayout(2, 1)); // 2行1列的网格布局

        // 创建按钮
        JButton button1 = new JButton("按钮1");
        JButton button2 = new JButton("按钮2");

        // 把按钮添加到子容器
        subContainer.add(button1);
        subContainer.add(button2);

        // 把子容器添加到内容面板的中央区域
        contentPane.add(subContainer, BorderLayout.CENTER);

        // 设置窗口大小
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MyFrameWithSubContainers frame = new MyFrameWithSubContainers();
        frame.setVisible(true);
    }
}
