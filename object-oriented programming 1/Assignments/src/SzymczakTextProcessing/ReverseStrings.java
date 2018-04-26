package SzymczakTextProcessing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// We need these for the document listener, which makes the program recalculate automatically whenever the user changes
// the input.
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Part of the text processing program. This program creates a GUI that reverses whatever string the user enters.
 * @author Thomas Szymczak
 * 4/4/2016
 */
public class ReverseStrings {
    
    private JFrame window;
    
    private JPanel panel;
    
    private JLabel inputLabel;
    private JLabel outputLabel;
    
    private JTextField inputField;
    private JTextField outputField;
    
    private JButton closeButton;
    
    // Create an instance of the DocumentListener to run code whenever the user adds or removes text from the input
    // text field. Whenever the input text changes, we can automatically reverse the new input, so the user doesn't
    // have to hit a calculate button over and over.
    DocumentListener textListener = new DocumentListener() {
        public void insertUpdate(DocumentEvent e)
        {
            reverse();
        }
        
        public void removeUpdate(DocumentEvent e)
        {
            reverse();
        }
        
        public void changedUpdate(DocumentEvent e)
        {
            reverse();
        }
    };

    public static void main(String[] args) {
        new ReverseStrings();
    }
    
    public ReverseStrings()
    {
        window = new JFrame();
        window.setTitle("Reverse a Senence");
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
        panel.setLayout(new GridLayout(0,1));
        
        inputLabel = new JLabel("Enter a sentence to reverse:");
        panel.add(inputLabel);
        
        inputField = new JTextField(30);
        inputField.getDocument().addDocumentListener(textListener);
        panel.add(inputField);
        
        outputLabel = new JLabel("The sentence in reverse:");
        panel.add(outputLabel);
        
        outputField = new JTextField(30);
        outputField.setEditable(false);
        panel.add(outputField);
        
        closeButton = new JButton("Close");
        closeButton.addActionListener(new CloseButtonListener());
        panel.add(closeButton);
    }
    
    /**
     * Reverse a string. We take the input from one text field and we print the output to the other field.
     */
    private void reverse()
    {
        String input, output, temp;
        int length;
        input = inputField.getText();
        
        length = input.length();
        output = "";
        
        // Reverse the string by copying one letter at a time from one string to another. Because we process the input
        // from right to left while adding to the output from left to right, the string gets reversed.
        for ( int i = length; i > 0; i-- )
        {
            temp = input.substring(i-1, i);
            output += temp;
        }
        
        outputField.setText(output);
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
