package SzymczakTextProcessing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This is a program that processes text in a number of ways, to demonstrate understanding of methods to manipulate
 * strings, as well as GUI programming.
 * @author Thomas Szymczak
 * 3/31/2016
 */
public class MainWindow extends JFrame {
    private JFrame window;
    
    private JPanel panel;
    
    private JLabel title;
    
    // Use an array of radio buttons to streamline the code.
    JRadioButton[] radioButtons;
    
    public static void main(String[] args)
    {
        new MainWindow();
    }
    
    public MainWindow()
    {
        window = new JFrame();
        window.setTitle("String Manipulator");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new FlowLayout());
        
        buildInterface();
        
        window.add(panel);
        window.pack();
        window.setVisible(true);
    }
    
    private void buildInterface()
    {
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        
        title = new JLabel("Select a task.");
        panel.add(title);
        
        // Create all the radio buttons and add them to the panel.
        // We use arrays of radio buttons and strings to avoid code duplication.
        radioButtons = new JRadioButton[10];
        ButtonGroup radioGroup = new ButtonGroup();
        
        // This array stores the text that each radio button gets.
        String[] buttonText = {"Classify Characters",
            "Compare Sentences (using equalsIgnoreCase)",
            "Compare Sentences (using compareToIgnoreCase)",
            "Change Case",
            "Combine Sentences",
            "Reverse a Sentence",
            "Count Words",
            "Replace Letters",
            "Count Characters",
            "Exit"};
        
        for ( int i = 0; i < radioButtons.length; i++ )
        {
            radioButtons[i] = new JRadioButton(buttonText[i]);
            radioGroup.add(radioButtons[i]);
            radioButtons[i].addActionListener(new RadioButtonListener());
            panel.add(radioButtons[i]);
        }
    }
    
        private class RadioButtonListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                // Each of these objects represents one of the calculators that can be opened from the main window.
                ClassifyCharacters classifierWindow;
                EqualStrings equalsWindow;
                CompareStrings compareWindow;
                ChangeCase caseWindow;
                ConcatenateStrings concatWindow;
                ReverseStrings reverseWindow;
                CountWords countWindow;
                ReplaceLetters replaceWindow;
                CountLength lengthWindow;

                // Whenever the user clicks one of the radio buttons, open the corresponding window.
                if ( e.getSource() == radioButtons[0] )
                    classifierWindow = new ClassifyCharacters();
                else if ( e.getSource() == radioButtons[1] )
                    equalsWindow = new EqualStrings();
                else if ( e.getSource() == radioButtons[2] )
                    compareWindow = new CompareStrings();
                else if ( e.getSource() == radioButtons[3] )
                    caseWindow = new ChangeCase();
                else if ( e.getSource() == radioButtons[4] )
                    concatWindow = new ConcatenateStrings();
                else if ( e.getSource() == radioButtons[5] )
                    reverseWindow = new ReverseStrings();
                else if ( e.getSource() == radioButtons[6] )
                    countWindow = new CountWords();
                else if ( e.getSource() == radioButtons[7] )
                    replaceWindow = new ReplaceLetters();
                else if ( e.getSource() == radioButtons[8] )
                    lengthWindow = new CountLength();
                else if ( e.getSource() == radioButtons[9] )
                    System.exit(0);
        }
    }

}
