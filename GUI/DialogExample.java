import javax.swing.*;

public class DialogExample {
    public static void main(String[] args) {
        // 创建一个 JFrame 对象作为对话框的父窗口
        JFrame frame = new JFrame();

        // 显示消息框
        JOptionPane.showMessageDialog(frame, "单词已经在列表中。");

        // 显示确认对话框
        int result = JOptionPane.showConfirmDialog(frame, "确定要删除这个元素吗？");
        if (result == JOptionPane.YES_OPTION) {
            System.out.println("用户选择了“是”。");
        } else if (result == JOptionPane.NO_OPTION) {
            System.out.println("用户选择了“否”。");
        } else if (result == JOptionPane.CANCEL_OPTION) {
            System.out.println("用户选择了“取消”。");
        }

        // 显示输入对话框
        String userInput = JOptionPane.showInputDialog(frame, "请输入单词：");
        if (userInput != null) {
            System.out.println("用户输入的单词是：" + userInput);
        } else {
            System.out.println("用户取消了输入。");
        }
    }
}
