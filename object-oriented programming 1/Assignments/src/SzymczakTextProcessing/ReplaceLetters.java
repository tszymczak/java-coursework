package SzymczakTextProcessing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// We need these for the document listener, which makes the program recalculate automatically whenever the user changes
// the input.
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Part of the text processing program. This is a GUI application that replaces all the e's in a string with the letter
 * o.
 * @author Thomas Szymczak
 * 4/5/2016
 */
public class ReplaceLetters {
    private JFrame window;
    
    private JPanel panel;
    
    private JLabel inputLabel;
    private JLabel replacedLabel;
    
    private JTextField inputField;
    private JTextField replacedField;
    
    private JButton closeButton;

    // Create an instance of the DocumentListener to run code whenever the user adds or removes text from the input
    // text field. Whenever the input text changes, we can automatically redo the letter substitution so the user
    // doesn't have to hit a calculate button over and over.
    DocumentListener textListener = new DocumentListener() {
        public void insertUpdate(DocumentEvent e)
        {
            replace();
        }
        
        public void removeUpdate(DocumentEvent e)
        {
            replace();
        }
        
        public void changedUpdate(DocumentEvent e)
        {
            replace();
        }
    };

    public static void main(String[] args) {
        new ReplaceLetters();
    }
    
    public ReplaceLetters()
    {
        window = new JFrame();
        window.setTitle("Replace Letters");
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
        
        inputLabel = new JLabel("Enter a sentence:");
        panel.add(inputLabel);
        
        inputField = new JTextField(30);
        // Add the textListener so we can execute code whenever the input is changed.
        inputField.getDocument().addDocumentListener(textListener);
        panel.add(inputField);
        
        replacedLabel = new JLabel("After replacing e's with o's:");
        panel.add(replacedLabel);
        
        replacedField = new JTextField(30);
        replacedField.setEditable(false);
        panel.add(replacedField);
        
        closeButton = new JButton("Close");
        closeButton.addActionListener(new CloseButtonListener());
        panel.add(closeButton);
    }
    
    /**
     * Replace all the e's in the input text field with o's, and display the result.
     */
    private void replace()
    {
        String input, output;
        input = inputField.getText();
        output = input.replaceAll("e", "o");
        replacedField.setText(output);
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
