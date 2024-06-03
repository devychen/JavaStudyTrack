import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class ListExample extends JFrame {
    public ListExample() {
        setTitle("列表示例");

        // 创建列表
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("选项1");
        listModel.addElement("选项2");
        listModel.addElement("选项3");
        listModel.addElement("选项4");
        JList<String> list = new JList<>(listModel);

        // 创建文本区域
        JTextArea textArea = new JTextArea(10, 20);
        textArea.setEditable(false); // 禁止编辑

        // 添加列表选择监听器
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // 确保只有最终选择生效
                    int selectedIndex = list.getSelectedIndex();
                    if (selectedIndex != -1) { // 确保有选中项
                        String selectedValue = listModel.getElementAt(selectedIndex);
                        // 根据选中的项更新文本区域内容
                        textArea.setText("你选择了：" + selectedValue);
                    }
                }
            }
        });

        // 将列表放入滚动窗格
        JScrollPane scrollPane = new JScrollPane(list);

        // 创建面板，并将列表和文本区域添加到面板中
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.WEST);
        panel.add(textArea, BorderLayout.CENTER);

        // 将面板添加到窗口中
        getContentPane().add(panel);

        // 设置窗口大小和关闭操作
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        ListExample frame = new ListExample();
        frame.setVisible(true);
    }
}
