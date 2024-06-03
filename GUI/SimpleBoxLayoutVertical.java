import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;

public class SimpleBoxLayoutVertical extends JFrame {
    public SimpleBoxLayoutVertical() {
        setTitle("垂直方向的BoxLayout示例");

        var contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        contentPane.add(new JButton("按钮1"));
        contentPane.add(Box.createRigidArea(new Dimension(0, 5))); // 添加一个固定高度的间距
        contentPane.add(new JButton("按钮2"));
        contentPane.add(Box.createVerticalGlue()); // 添加一个可伸缩的垂直空间
        contentPane.add(new JButton("按钮3"));

        setSize(200, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SimpleBoxLayoutVertical frame = new SimpleBoxLayoutVertical();
        frame.setVisible(true);
    }
}
