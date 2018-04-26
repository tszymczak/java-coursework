package SwingGUI;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/**
 * This panel draws a rectangles of random colors with Time
 * @author Don Smith
 */
public class MyRectanglePanel extends JPanel {
    private Color rColor;
    private Random rGen;
    private Timer space;
    
    public MyRectanglePanel() {
        super(); // explicit
        space = new Timer(2000, new TimerDelayListener()); // delay 2 seconds
        space.start();
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = getWidth(); // x holds with width of the panel in pixels
        int y = getHeight();
        int x1, width, y1, height;
        rGen = new Random();
        for (int i = 1; i <= 50; i++) {
            rColor = new Color(rGen.nextInt(256), rGen.nextInt(256), rGen.nextInt(256));
            g.setColor(rColor);
            x1 = rGen.nextInt(x - 1) + 1; // generate a x position
            width = rGen.nextInt(91) + 40; // generate a width in range 40 - 130
            if (width + x1 > x ) { //check if in horizontal range
                x1 -= width; //move over to the left
            }
            y1 = rGen.nextInt(y - 1) + 1; //Generate a y position
            height = rGen.nextInt(81) + 20; // Generate a height in range 20 - 100
            if (height + y1 > y ) {// check if in vertical range
                y1 -= height; // move up
            }
            if (rGen.nextBoolean()) {
                g.fillRect(x1, y1, width, height); // draw
            } else {
                g.drawRect(x1, y1, width, height);
            }
        }
    }
    
    class TimerDelayListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            repaint();
        }
    }
}