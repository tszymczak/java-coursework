package SwingGUI;

import javax.swing.JFrame;

/**
 * this class will use a frame to display a panel full
 * of changing shapes with color
 * @author Don Smith
 */
public class TestMyRectanglePanel extends JFrame {
    public TestMyRectanglePanel() {
        MyRectanglePanel mp = new MyRectanglePanel();
        add(mp);
    }
    
    public static void main(String[] args) {
        TestMyRectanglePanel app = new TestMyRectanglePanel();
        app.setSize(500, 400);
        app.setTitle("My Rectangle Panel");
        app.setLocationRelativeTo(null);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setResizable(false);
    }
}