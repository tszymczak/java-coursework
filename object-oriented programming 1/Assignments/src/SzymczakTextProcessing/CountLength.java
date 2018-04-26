package SzymczakTextProcessing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// We need these for the document listener, which makes the program recalculate automatically whenever the user changes
// the input.
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Part of the text processing program. This file counts the length of strings entered by the user.
 * @author Thomas Szymczak
 * 4/5/2016
 */
public class CountLength {
    private JFrame window;
    
    private JPanel panel;
    
    private JLabel inputLabel;
    private JLabel lengthLabel;
    
    private JTextField inputField;
    private JTextField lengthField;
    
    private JButton closeButton;

    // Create an instance of the DocumentListener to run code whenever the user adds or removes text from the input
    // text field. Whenever the input text changes, we can automatically redo the character count so the user doesn't
    // have to hit a calculate button over and over.
    DocumentListener textListener = new DocumentListener() {
        public void insertUpdate(DocumentEvent e)
        {
            displayLength();
        }
        
        public void removeUpdate(DocumentEvent e)
        {
            displayLength();
        }
        
        public void changedUpdate(DocumentEvent e)
        {
            displayLength();
        }
    };

    public static void main(String[] args) {
        new CountWords();
    }
    
    public CountLength()
    {
        window = new JFrame();
        window.setTitle("Count Characters");
        window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        window.setLayout(new FlowLayout());

        buildInterface();
        
        window.add(panel);
        window.pack();
        window.setVisible(true);

    }
    
    private void buildInterface()
    {
        panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        
        inputLabel = new JLabel("Enter a sentence:");
        panel.add(inputLabel);
        
        inputField = new JTextField(30);
        inputField.getDocument().addDocumentListener(textListener);
        panel.add(inputField);
        
        lengthLabel = new JLabel("Number of characters:");
        panel.add(lengthLabel);
        
        lengthField = new JTextField(30);
        lengthField.setEditable(false);
        panel.add(lengthField);
        
        closeButton = new JButton("Close");
        closeButton.addActionListener(new CloseButtonListener());
        panel.add(closeButton);
    }
    
    /**
     * Display the length of the input string.
     */
    private void displayLength()
    {
        String input, output;
        int length;
        
        input = inputField.getText();
        length = input.length();
        output = Integer.toString(length);
        lengthField.setText(output);
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
