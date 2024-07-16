import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * 理解top-level window
 * 顶级窗口：
 *      是整个应用程序的根窗口，所有其他组件都嵌套在这个窗口内。
 *      它们通常是用户与应用程序交互的主要界面元素。
 */

public class TopLevelWindow extends JFrame {
    public TopLevelWindow() {
        setTitle("顶级窗口示例");

        // 创建一个顶级窗口 (JFrame)
        var contentPane = getContentPane();
        
        // 创建一个子容器 (JPanel)
        JPanel panel = new JPanel();

        // 创建一些子组件 (JButton)
        JButton button1 = new JButton("按钮1");
        JButton button2 = new JButton("按钮2");

        // 把按钮添加到子容器
        panel.add(button1);
        panel.add(button2);

        // 把子容器添加到顶级窗口的内容面板
        contentPane.add(panel);

        // 设置窗口大小和关闭操作
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        TopLevelWindow frame = new TopLevelWindow();
        frame.setVisible(true);
    }
}
