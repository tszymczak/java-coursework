package SwingGUI;
// SwingFrameWithMenus.java
// Illustrates Swing menus

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SwingFrameWithMenus2 extends JFrame implements ActionListener {
    // The GUI freference variables which need class scope
    JTextField messageTextField;
    JMenuItem displayMenu, clearMenu, closeMenu;
    
    public static void main(String[] args) {
        // create instance of JFrame
        new SwingFrameWithMenus2();
    }
    
    // constructor
    public SwingFrameWithMenus2() {
        // create menu bar, menus & menu items
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        displayMenu = new JMenuItem("Display");
        clearMenu = new JMenuItem("Clear");
        closeMenu = new JMenuItem("Close");
        
        fileMenu.setMnemonic('F');
        helpMenu.setMnemonic('H');
        
        fileMenu.add(displayMenu); // addmenu items to menus
        fileMenu.add(clearMenu);
        fileMenu.add(closeMenu);
        
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        this.setJMenuBar(menuBar); // add bar to frame
        
        // create instance of Label and TextField
        JLabel messageLabel = new JLabel("message:");
        messageTextField = new JTextField(15);
        // a container is needed to color the window background
        Container c = this.getContentPane();
        c.setBackground(new Color(250,240,240));
        c.setLayout(new FlowLayout());
        c.add(messageLabel);
        c.add(messageTextField);
        // register frame as listener fro menu events
        displayMenu.addActionListener(this);
        clearMenu.addActionListener(this);
        closeMenu.addActionListener(this);
        this.setSize(370, 220);
        this.setLocation(200,200);
        this.setTitle("Swing Frame with Menus");
        this.setVisible(true);
        
        this.addWindowListener(new MyCloseWindow());
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // adapter class
        /* register frame as listener for window event
            create anonymous inner class to handle windows closing event*/
        /*
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                shutDown();
            }
        }
        );
        */
    }
    
    private class MyCloseWindow extends WindowAdapter {
        public void windowClosing(WindowEvent event) {
            shutDown();
        }
    }
    
    // actionPerformed is invoked when a menu item is clocked
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == displayMenu) {
            displayMessage();
        }
        if (e.getSource() == clearMenu) {
            clearMessage();
        }
        if (e.getSource() == closeMenu) {
            shutDown();
        }
    }
            
    public void displayMessage() {
        messageTextField.setText("Hello World");
    }
    
    public void clearMessage() {
        messageTextField.setText("");
    }
    
    public void shutDown() {
        this.dispose();
        System.exit(0); // terminate
    }
}