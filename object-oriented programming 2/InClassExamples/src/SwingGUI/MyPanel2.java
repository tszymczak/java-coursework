package SwingGUI;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

/**
 * this panel draws rectangles of random colors
 * 
 * @author Don Smith
 */
public class MyPanel2 extends JPanel {
    Color rColor;
    Random rGen;
    
    public MyPanel2() {
        rGen = new Random();
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = getWidth();
        int y = getHeight();
        // 4 ints for drawing lines
        int x1, width, y1, height;
        
        for (int i = 1; i <= 50; i++) {
            rColor = new Color(rGen.nextInt(256), rGen.nextInt(256), rGen.nextInt(256));
            g.setColor(rColor);
            x1 = rGen.nextInt(x);
            width = rGen.nextInt(51) + 10; // size range 10 - 60
            y1 = rGen.nextInt(y);
            height = rGen.nextInt(51) + 10; // size range 10 - 60
            g.fillRect(x1, y1, width, height);
        }
    }
}