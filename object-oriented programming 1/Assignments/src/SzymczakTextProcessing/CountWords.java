package SzymczakTextProcessing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// We need these for the document listener, which makes the program recalculate automatically whenever the user changes
// the input.
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Part of the text processing program. This is a GUI application that counts the number of words in a string.
 * @author Thomas Szymczak
 * 4/5/2016
 */
public class CountWords {
    private JFrame window;
    
    private JPanel panel;
    
    private JLabel inputLabel;
    private JLabel numWordsLabel;
    
    private JTextField inputField;
    private JTextField numWordsField;
    
    private JButton closeButton;

    // Create an instance of the DocumentListener to run code whenever the user adds or removes text from the input
    // text field. Whenever the input text changes, we can automatically redo the word count so the user doesn't have
    // to hit a calculate button over and over.
    DocumentListener textListener = new DocumentListener() {
        public void insertUpdate(DocumentEvent e)
        {
            wordCount();
        }
        
        public void removeUpdate(DocumentEvent e)
        {
            wordCount();
        }
        
        public void changedUpdate(DocumentEvent e)
        {
            wordCount();
        }
    };

    public static void main(String[] args) {
        new CountWords();
    }
    
    public CountWords()
    {
        window = new JFrame();
        window.setTitle("Count Words");
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
        
        numWordsLabel = new JLabel("Word count:");
        panel.add(numWordsLabel);
        
        numWordsField = new JTextField(30);
        numWordsField.setEditable(false);
        panel.add(numWordsField);
        
        closeButton = new JButton("Close");
        closeButton.addActionListener(new CloseButtonListener());
        panel.add(closeButton);
    }
    
    /**
     * Count the number of words in the input text field, and display it in the output field.
     */
    private void wordCount()
    {
        String input, output;
        String[] tokens;
        int words;
        
        input = inputField.getText();
        tokens = input.split(" ");
        words = tokens.length;
        output = Integer.toString(words);
        numWordsField.setText(output);
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
