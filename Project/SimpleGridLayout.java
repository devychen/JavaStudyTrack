/*
 * GridLayout是一种将组件按照网格形式排列的布局管理器，
 * 适合于需要规整排列组件的情况。
 * 每个单元格都有相同的大小，并且每个单元格只能包含一个组件。
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class SimpleGridLayout extends JFrame {
    public SimpleGridLayout() {
        setTitle("GridLayout示例");

        // 创建GridLayout布局管理器，2行3列
        getContentPane().setLayout(new GridLayout(2, 3));

        // 添加按钮到布局中
        getContentPane().add(new JButton("按钮1"));
        getContentPane().add(new JButton("按钮2"));
        getContentPane().add(new JButton("按钮3"));
        getContentPane().add(new JButton("按钮4"));
        getContentPane().add(new JButton("按钮5"));
        getContentPane().add(new JButton("按钮6"));

        // 设置窗口大小和关闭操作
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SimpleGridLayout frame = new SimpleGridLayout();
        frame.setVisible(true);
    }
}
