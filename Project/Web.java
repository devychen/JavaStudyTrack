import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Web extends JFrame {
    public Web(){
        setTitle("NLP-Analyzer");
        setSize(800, 400);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Web gui = new Web();
            gui.setVisible(true);
        });
    }
}
