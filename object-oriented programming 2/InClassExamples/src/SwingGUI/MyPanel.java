package SwingGUI;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

/**
 * this panel draws 50 lines of random colors
 * 
 * @author Don Smith
 */
public class MyPanel extends JPanel {
    private Color rColor;
    private static Random rGen = new Random();
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = getWidth();
        int y = getWidth();
        int x1, x2, y1, y2;
        // rGen = newRandom;
        for (int i = 1; i <= 50; i++) {
            rColor = new Color((float) Math.random(),
                    (float) Math.random(),
                    (float) Math.random());
            g.setColor(rColor);
            x1 = rGen.nextInt(x - 1) + 1;
            x2 = rGen.nextInt(x - 1) + 1;
            y1 = rGen.nextInt(y - 1) + 1;
            y2 = rGen.nextInt(y - 1) + 1;
            g.drawLine(x1, y1, x2, y2);
        }
    }
}