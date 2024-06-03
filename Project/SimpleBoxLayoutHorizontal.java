import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;

public class SimpleBoxLayoutHorizontal extends JFrame {
    public SimpleBoxLayoutHorizontal() {
        setTitle("水平方向的BoxLayout示例");

        var contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

        contentPane.add(new JButton("按钮1"));
        contentPane.add(Box.createRigidArea(new Dimension(5, 0))); // 添加一个固定宽度的间距
        contentPane.add(new JButton("按钮2"));
        contentPane.add(Box.createHorizontalGlue()); // 添加一个可伸缩的水平空间
        contentPane.add(new JButton("按钮3"));

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SimpleBoxLayoutHorizontal frame = new SimpleBoxLayoutHorizontal();
        frame.setVisible(true);
    }
}
