package LabAssignment6;

import javax.swing.JFrame;

/**
 * Make use of RandomShapesPanel, which creates a panel that is filled with
 * random shapes and refreshes automatically.
 * @author Thomas Szymczak
 * Lab Assignment 6
 */
public class LabAssign6 extends JFrame {
    // Create the window full of shapes.
    public LabAssign6() {
        RandomShapesPanel mainPanel = new RandomShapesPanel();
        add(mainPanel);
    }
    
    public static void main(String[] args) {
        // Create the window.
        LabAssign6 window = new LabAssign6();
        // Set various attributes of the window.
        window.setSize(500, 400);
        window.setTitle("Random Shapes");
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        // Finally, make the window appear.
        window.setVisible(true);
    }
    
}
