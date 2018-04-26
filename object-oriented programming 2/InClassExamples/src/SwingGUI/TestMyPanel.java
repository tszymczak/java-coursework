package SwingGUI;
import javax.swing.JFrame;

/**
 * This class will use a frame to display a panel
 * @author Don Smith
 */
public class TestMyPanel extends JFrame {
    public TestMyPanel() {
        MyPanel mp = new MyPanel();
        add(mp);
    }
    
    public static void main(String[] args) {
        
        TestMyPanel app = new TestMyPanel();
        app.setSize(500, 400);
        app.setTitle("My line panel");
        app.setLocationRelativeTo(null);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}