package SzymczakTextProcessing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// We need these for the document listener, which makes the program recalculate automatically whenever the user changes
// the input.
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/**
 * Part of the Text processing program. This file analyzes individual characters to determine their category and case.
 * It also lets the user convert the case of a character.
 * @author Thomas Szymczak
 * 4/2/2016
 */
public class ClassifyCharacters extends JFrame {
    private JFrame window;
    
    private JPanel panel;
    
    private JLabel inputLabel;
    private JLabel charTypeLabel;
    private JLabel caseLabel;
    private JLabel conversionLabel;
    
    private JTextField inputField;
    private JTextField charTypeField;
    private JTextField caseField;
    private JTextField conversionField;
    
    private ButtonGroup radioButtons;
    
    private JRadioButton uppercase;
    private JRadioButton lowercase;
    
    private JButton closeButton;
    
    // Create an instance of the DocumentListener to run code whenever the user adds or removes text from a text field.
    // Whenever the input text changes, we can recalculate all the output fields automatically, so the user doesn't
    // have to keep hitting a Calculate button over and over.
    DocumentListener textListener = new DocumentListener() {
        public void insertUpdate(DocumentEvent e)
        {
            calculate();
        }
        
        public void removeUpdate(DocumentEvent e)
        {
            calculate();
        }
        
        public void changedUpdate(DocumentEvent e)
        {
            calculate();
        }
    };

    public static void main(String[] args)
    {
        new ClassifyCharacters();
    }
    
    public ClassifyCharacters()
    {
        window = new JFrame();
        window.setTitle("Classify Characters");
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
        
        inputLabel = new JLabel("Enter a Character:");
        panel.add(inputLabel);
        
        inputField = new JTextField(30);
        // Add a listener to the input text field, so we can execute code when the user edits the text filed.
        inputField.getDocument().addDocumentListener(textListener);
        panel.add(inputField);
        
        charTypeLabel = new JLabel("Digit or letter?");
        panel.add(charTypeLabel);
        
        charTypeField = new JTextField(30);
        charTypeField.setEditable(false);
        panel.add(charTypeField);
        
        caseLabel = new JLabel("Case");
        panel.add(caseLabel);
        
        caseField = new JTextField(30);
        caseField.setEditable(false);
        panel.add(caseField);
        
        conversionLabel = new JLabel("Convert to");
        panel.add(conversionLabel);
        
        radioButtons = new ButtonGroup();
        
        uppercase = new JRadioButton("Uppercase");
        uppercase.addActionListener(new RadioButtonListener());
        radioButtons.add(uppercase);
        panel.add(uppercase);
        
        lowercase = new JRadioButton("Lowercase");
        lowercase.addActionListener(new RadioButtonListener());
        radioButtons.add(lowercase);
        panel.add(lowercase);
        
        conversionField = new JTextField(30);
        conversionField.setEditable(false);
        panel.add(conversionField);
        
        closeButton = new JButton("Close");
        closeButton.addActionListener(new CloseButtonListener());
        panel.add(closeButton);
        
        // Select the uppercase radio button by default, which converts the input character to uppercase.
        uppercase.doClick();
    }
    
    /**
     * Given an input character, determine its type (letter or digit), case (lower or upper case), and convert the case
     * to either upper or lower case. It takes its input from the first character of the inputField text field. All
     * other characters are ignored.
     */
    private void calculate()
    {
        String StrInput;
        String conversion;
        char input;
        
        // Get the input from the input text field.
        StrInput = inputField.getText();
        
        // If we get actual input, do all the calculations. If the input is empty, display blank output.
        if ( StrInput.length() > 0 )
        {
            input = StrInput.charAt(0);

            // Determine and display whether the input character is a digit or letter.
            if ( Character.isLetter(input) )
            {
                charTypeField.setText("Letter");
            }
            else if ( Character.isDigit(input) )
            {
                charTypeField.setText("Digit");
            }
            else
            {
                charTypeField.setText("Neither");
            }
            
            // Determine the character's case.
            if ( Character.isUpperCase(input) )
            {
                caseField.setText("Uppercase");
            }
            else if ( Character.isLowerCase(input) )
            {
                caseField.setText("Lowercase");
            }
            else
            {
                caseField.setText("Neither");
            }
            
            // Perform the case conversion.
            if ( lowercase.isSelected() )
            {
                conversion = Character.toString(Character.toLowerCase(input));
            }
            else if ( uppercase.isSelected() )
            {
                conversion = Character.toString(Character.toUpperCase(input));
            }
            else
            {
                conversion = "";
            }
            conversionField.setText(conversion);
        }
        else
        {
            // Make the output text fields blank.
            charTypeField.setText("");
            caseField.setText("");
            conversionField.setText("");
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
    
    /**
     * Whenever the user changes the radio buttons, recalculate all the outputs. We only need to recalculate the case
     * conversion, but it's easier to just redo all the calculations, which wastes a negligible amount of time.
     */
    private class RadioButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            calculate();
        }
    }    
}
