/*
 * BorderLayout是一种布局管理器，它将容器分为五个区域，每个区域可以放置一个组件。每个区域最多只能包含一个组件。
 * 这五个区域分别是：
 * BorderLayout.NORTH（北部）
 * BorderLayout.SOUTH（南部）
 * BorderLayout.EAST（东部）
 * BorderLayout.WEST（西部）
 * BorderLayout.CENTER（中部）
 * 如果你在同一个区域添加多个组件，只有最后一个组件会被显示。
 * 如果你想在某个区域放置多个组件，可以创建一个容器（比如JPanel），然后将多个组件添加到这个容器，再将容器添加到这个区域。
 * 
 * vs FlowLayout
 * BorderLayout：
 *     将容器分成五个区域（北、南、东、西、中），每个区域最多只能包含一个组件。
 *     可以使用JPanel等容器在一个区域中放置多个组件。
 *     适合用于需要将界面分成多个固定区域的情况。
 * FlowLayout：
 *     按顺序排列组件，类似于文本在一行中排列，当一行放不下时会自动换行。
 *     适合用于简单的组件排列，比如按钮的排列。
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class SimpleBorderLayout extends JFrame {
    public SimpleBorderLayout() {
        setTitle("简单的BorderLayout示例");

        // 获取内容面板并设置为BorderLayout
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        // 创建一些按钮并添加到不同的区域
        contentPane.add(BorderLayout.NORTH, new JButton("北部"));
        contentPane.add(BorderLayout.SOUTH, new JButton("南部"));
        contentPane.add(BorderLayout.EAST, new JButton("东部"));
        contentPane.add(BorderLayout.WEST, new JButton("西部"));
        contentPane.add(BorderLayout.CENTER, new JButton("中部"));

        // 设置窗口大小和关闭操作
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SimpleBorderLayout frame = new SimpleBorderLayout();
        frame.setVisible(true);
    }
}
