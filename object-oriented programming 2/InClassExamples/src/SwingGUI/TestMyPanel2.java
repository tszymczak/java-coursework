package SwingGUI;

import javax.swing.JFrame;

/**
 * This program uses a custom panel to draw rectangles
 * @author Don Smith
 */
public class TestMyPanel2 extends JFrame {
    public TestMyPanel2() {
        MyPanel2 cPanel = new MyPanel2();
        add(cPanel);
    }
    
    public static void main(String[] args) {
        TestMyPanel2 aFrame = new TestMyPanel2();
        aFrame.setSize(500, 400);
        aFrame.setTitle("My Panel");
        aFrame.setLocationRelativeTo(null); // Center the frame
        aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aFrame.setVisible(true);
    }
}