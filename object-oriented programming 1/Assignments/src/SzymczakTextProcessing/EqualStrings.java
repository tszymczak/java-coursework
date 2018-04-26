package SzymczakTextProcessing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// We need these for the document listener, which makes the program recalculate automatically whenever the user changes
// the input.
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Part of the Text processing program. This is a GUI program that compares two strings using the equalsIgnoreCase
 * method. It is not case-sensitive.
 * @author Thomas Szymczak
 * 4/3/2016
 */
public class EqualStrings {
    private JFrame window;
    
    private JPanel panel;
    
    private JLabel input1Label;
    private JLabel input2Label;
    
    private JTextField input1;
    private JTextField input2;
    private JTextField output;
    
    private JButton closeButton;
    
    // Create an instance of the DocumentListener to run code whenever the user adds or removes text from a text field.
    // Whenever the input text changes, we can automatically compare the two strings, so the user doesn't have to hit
    // a Calculate button over and over.
    DocumentListener textListener = new DocumentListener() {
        public void insertUpdate(DocumentEvent e)
        {
            compareStrings();
        }
        
        public void removeUpdate(DocumentEvent e)
        {
            compareStrings();
        }
        
        public void changedUpdate(DocumentEvent e)
        {
            compareStrings();
        }
    };

    public static void main(String[] args)
    {
        new EqualStrings();
    }
    
    public EqualStrings()
    {
        window = new JFrame();
        window.setTitle("Compare Sentences (equalsIgnoreCase method)");
        window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        window.setLayout(new FlowLayout());
        
        buildInterface();
        
        window.add(panel);
        window.pack();
        window.setVisible(true);
    }
    
    /**
     * Set up the GUI.
     */
    private void buildInterface()
    {
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        
        input1Label = new JLabel("Sentence one:");
        panel.add(input1Label);
        
        input1 = new JTextField(30);
        // Add a listener to both input fields so we can compare the strings whenever they change.
        input1.getDocument().addDocumentListener(textListener);
        panel.add(input1);
        
        input2Label = new JLabel("Sentence two:");
        panel.add(input2Label);
        
        input2 = new JTextField(30);
        input2.getDocument().addDocumentListener(textListener);
        panel.add(input2);
        
        output = new JTextField(30);
        output.setEditable(false);
        panel.add(output);
        
        closeButton = new JButton("Close");
        closeButton.addActionListener(new CloseButtonListener());
        panel.add(closeButton);

    }
    
    private void compareStrings()
    {
        String string1 = input1.getText();
        String string2 = input2.getText();
        
        if ( string1.equalsIgnoreCase(string2) )
            output.setText("The sentences are identical.");
        else
            output.setText("The sentences are different.");
    }
    
    // When the close button is clicked, hide the window.
    private class CloseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            window.setVisible(false);
        }
    }

}
