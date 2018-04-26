package LabAssignment6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/**
 * Create a panel that displays random shapes.
 * @author Thomas Szymczak
 * Lab Assignment 6
 */
public class RandomShapesPanel extends JPanel {
    // Set up the RandomShapesPanel.
    public RandomShapesPanel() {
        // Set up a timer that fires every 4 seconds. When it goes off, it
        // sends an event to TimerDelayListener, which refreshes the screen.
        Timer refreshTimer = new Timer(4000, new TimerDelayListener());
        refreshTimer.start();
    }
    
    protected void paintComponent(Graphics g) {
        // Constants.
        // Draw 175 shapes per frame.
        final int NSHAPES = 175;
        // Rectangles and ovals must be 10 to 60 pixels in size.
        final int MIN_SIZE = 10;
        final int MAX_SIZE = 60;

        super.paintComponent(g);

        Random rng = new Random();
        
        int x, y, shapeType, x1, y1, x2, y2;
        // Get the dimensions of the panel we're drawing in.
        x = getWidth();
        y = getHeight();
        
        // Draw 175 shapes.
        for (int i = 0; i < NSHAPES; i++ ) {
            // Randomly choose a type of shape to draw.
            shapeType = rng.nextInt(5);
            if (shapeType == 0) {
                // Draw a line between two random points on the screen.
                x1 = rng.nextInt(x);
                y1 = rng.nextInt(y);
                x2 = rng.nextInt(x);
                y2 = rng.nextInt(y);
                g.setColor(randColor());
                g.drawLine(x1, y1, x2, y2);
            } else {
                // Draw a random rectangle or oval.
                // Get the position and size of the shape.
                int[] coords = chooseCoordinates(x, y, MIN_SIZE, MAX_SIZE);
                
                // Get a random color.
                g.setColor(randColor());
                
                
                switch (shapeType) {
                    case 1:
                        g.drawRect(coords[0], coords[1], coords[2], coords[3]);
                        break;
                    case 2:
                        g.fillRect(coords[0], coords[1], coords[2], coords[3]);
                        break;
                    case 3:
                        g.drawOval(coords[0], coords[1], coords[2], coords[3]);
                        break;
                    default:
                        g.fillOval(coords[0], coords[1], coords[2], coords[3]);
                        break;
                }

            }
        }
    }
    
    /**
     * Generate a random set of coordinates for a rectangle or oval shape.
     * @param x The width of the frame
     * @param y The height of the frame
     * @param max_size The maximum size for a shape
     * @param min_size The minimum size for a shape.
     * @return An array containing the randomly generated x position, y
     * position, width, and height (in that order)
     */
    private int[] chooseCoordinates(int x, int y, int min_size, int max_size) {
        Random rng = new Random();
        int x1, y1, width, height;
        x1 = rng.nextInt(x);
        y1 = rng.nextInt(y);
        width = rng.nextInt(max_size - min_size) + min_size;
        height = rng.nextInt(max_size - min_size) + min_size;
        // If the rectangle would go beyond the window, move it back.
        if (x1 + width > x)
            x1 =- width;
        if (y1 + height > y)
            y1 =- height;
        
        return new int[] {x1, y1, width, height};
    }
    
    /**
     * Generate a random color.
     * @return 
     */
    private Color randColor() {
        Random rng = new Random();
        return new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
    }
    
    class TimerDelayListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Draw new shapes. repaint() eventually calls the paintComponent()
            // method.
            repaint();
        }
    }
}
