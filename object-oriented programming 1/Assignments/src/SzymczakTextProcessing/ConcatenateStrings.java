package SzymczakTextProcessing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// We need these for the document listener, which makes the program recalculate automatically whenever the user changes
// the input.
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/**
 * Part of the text processing program. This file creates a GUI window that concatenates two strings chosen by the
 * user.
 * @author Thomas Szymczak
 * 4/4/2016
 */
public class ConcatenateStrings {
    private JFrame window;
    
    private JPanel panel;
    
    private JLabel string1Label;
    private JLabel string2Label;
    private JLabel resultLabel;
    
    private JTextField string1Field;
    private JTextField string2Field;
    private JTextField result;
    
    private JButton closeButton;
    
    // Create an instance of the DocumentListener to run code whenever the user adds or removes text from the input
    // text field. Whenever the input text changes, we can automatically redo the case conversion, so the user doesn't
    // have to hit a calculate button over and over.
    DocumentListener textListener = new DocumentListener() {
        public void insertUpdate(DocumentEvent e)
        {
            concatenate();
        }
        
        public void removeUpdate(DocumentEvent e)
        {
            concatenate();
        }
        
        public void changedUpdate(DocumentEvent e)
        {
            concatenate();
        }
    };
    
    public static void main(String[] args)
    {
        new ConcatenateStrings();
    }
    
    public ConcatenateStrings()
    {
        window = new JFrame();
        window.setTitle("Combine Sentences");
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
        
        string1Label = new JLabel("Sentence one:");
        panel.add(string1Label);
        
        string1Field = new JTextField(30);
        string1Field.getDocument().addDocumentListener(textListener);
        panel.add(string1Field);
        
        string2Label = new JLabel("Sentence two:");
        panel.add(string2Label);
        
        string2Field = new JTextField(30);
        string2Field.getDocument().addDocumentListener(textListener);
        panel.add(string2Field);
        
        resultLabel = new JLabel("The two sentences combined:");
        panel.add(resultLabel);
        
        result = new JTextField(30);
        result.setEditable(false);
        panel.add(result);
        
        closeButton = new JButton("Close");
        closeButton.addActionListener(new CloseButtonListener());
        panel.add(closeButton);
    }
    
    /**
     * Concatenate two strings, using the GUI's text fields for input and output.
     */
    private void concatenate()
    {
        String input1, input2, output;
        input1 = string1Field.getText();
        input2 = string2Field.getText();
        
        output = input1 + input2;
        result.setText(output);
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
