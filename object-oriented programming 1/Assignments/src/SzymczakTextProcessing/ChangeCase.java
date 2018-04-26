package SzymczakTextProcessing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// We need these for the document listener, which makes the program recalculate automatically whenever the user changes
// the input.
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Part of the Text processing program. This is a GUI program that converts strings to either uppercase or lowercase.
 * @author Thomas Szymczak
 * 4/3/2016
 */
public class ChangeCase {
    
    private JFrame window;
    
    private JPanel panel;
    
    private JLabel inputLabel;
    private JLabel conversionLabel;
    
    private JTextField inputField;
    private JTextField outputField;
    
    private ButtonGroup radioButtons;
    private JRadioButton uppercase;
    private JRadioButton lowercase;
    
    private JButton closeButton;

    // Create an instance of the DocumentListener to run code whenever the user adds or removes text from the input
    // text field. Whenever the input text changes, we can automatically redo the case conversion, so the user doesn't
    // have to hit a calculate button over and over.
    DocumentListener textListener = new DocumentListener() {
        public void insertUpdate(DocumentEvent e)
        {
            changeCase();
        }
        
        public void removeUpdate(DocumentEvent e)
        {
            changeCase();
        }
        
        public void changedUpdate(DocumentEvent e)
        {
            changeCase();
        }
    };

    public static void main(String[] args) {
        new ChangeCase();
    }
    
    public ChangeCase()
    {
        window = new JFrame();
        window.setTitle("Change Case");
        window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        window.setLayout(new FlowLayout());
        
        buildInterface();
        
        window.add(panel);
        window.pack();
        window.setVisible(true);
    }
    
    /**
     * Set up the program's GUI.
     */
    private void buildInterface()
    {
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        
        inputLabel = new JLabel("Enter a sentence:");
        panel.add(inputLabel);
        
        inputField = new JTextField(30);
        inputField.getDocument().addDocumentListener(textListener);
        panel.add(inputField);
        
        conversionLabel = new JLabel("Convert to:");
        panel.add(conversionLabel);
        
        radioButtons = new ButtonGroup();
        
        uppercase = new JRadioButton("Uppercase");
        radioButtons.add(uppercase);
        uppercase.addActionListener(new RadioButtonListener());
        panel.add(uppercase);
        
        lowercase = new JRadioButton("Lowercase");
        radioButtons.add(lowercase);
        lowercase.addActionListener(new RadioButtonListener());
        panel.add(lowercase);
        
        outputField = new JTextField(30);
        outputField.setEditable(false);
        panel.add(outputField);
        
        closeButton = new JButton("Close");
        closeButton.addActionListener(new CloseButtonListener());
        panel.add(closeButton);
        
        // By default, convert to uppercase.
        uppercase.doClick();
    }
    
    /**
     * Convert the string in the input text box to either lowercase or uppercase, depending on which radio button the
     * user selected.
     */
    private void changeCase()
    {
        String inString;
        String outString;
        
        inString = inputField.getText();
        
        if ( uppercase.isSelected() )
        {
            outString = inString.toUpperCase();
        }
        else if ( lowercase.isSelected() )
        {
            outString = inString.toLowerCase();
        }
        else
        {
            outString = "";
        }
        
        outputField.setText(outString);
    }
    
    // When one of the radio buttons is clicked, refresh the results.
    private class RadioButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            changeCase();
        }
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
