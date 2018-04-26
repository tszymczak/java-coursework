package SzymczakBankingGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * This is the part of the BankingCalculator program that calculates compound interest.
 * @author Thomas Szymczak
 * 3-13-2016
 */
public class CompoundInterestGui extends JFrame {
    JFrame window;
    
    JPanel textPanel;
    JPanel buttonPanel;
    
    JLabel principalLabel;
    JLabel rateLabel;
    JLabel timeLabel;
    JLabel interestLabel;
    
    JTextField principalField;
    JTextField rateField;
    JTextField timeField;
    JTextField interestField;
    
    JButton calcButton;
    JButton closeButton;
    
    public static void main( String[] args )
    {
        new CompoundInterestGui();
    }

    public CompoundInterestGui()
    {
        window = new JFrame();
        
        window.setLayout(new FlowLayout());
        window.setTitle("Banking Calculator | Compound Interest");
        // Width, then height.
        window.setSize(375, 160);
        
        // Set up all the elements of the GUI.
        buildInterface();
        
        // Add our panels to the window.
        window.add(textPanel);
        window.add(buttonPanel);
        
        window.setVisible(true);
    }
    
    /**
     * Set up the GUI for the calculator.
     */
    private void buildInterface()
    {
        // Create the first panel, containing the text fields and labels.
        textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(4, 2));
        
        principalLabel = new JLabel("The principal investment");
        principalField = new JTextField(1);
        
        textPanel.add(principalLabel);
        textPanel.add(principalField);
        
        rateLabel = new JLabel("Interest rate per year (%)");
        rateField = new JTextField(1);

        textPanel.add(rateLabel);
        textPanel.add(rateField);
        
        timeLabel = new JLabel("Number of years");
        timeField = new JTextField(1);

        textPanel.add(timeLabel);
        textPanel.add(timeField);

        interestLabel = new JLabel("Compound interest");
        interestField = new JTextField(1);
        interestField.setEditable(false);
        
        textPanel.add(interestLabel);
        textPanel.add(interestField);

        // Create the second panel, with the buttons.
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        
        calcButton = new JButton("Calculate");
        calcButton.addActionListener(new CalcButtonListener());
        closeButton = new JButton("Exit");
        closeButton.addActionListener(new ExitButtonListener());
        
        buttonPanel.add(calcButton);
        buttonPanel.add(closeButton);
    }
    
    private class CalcButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            float rate;
            String rateString;
            float interest;
            String interestString;
            
            DecimalFormat df = new DecimalFormat("0.00");
            
            // We divide by 100 because the user enters the rate in percent, but the banking class uses decimals.
            rate = Float.parseFloat(rateField.getText()) / 100;
            rateString = Float.toString(rate);
            interest = BankingClass.calcCompoundInterest(principalField.getText(), rateString, timeField.getText());
            System.out.println(principalField.getText() + " " + rateString + " " + timeField.getText());
            interestString = df.format(interest);
            interestField.setText(interestString);
        }
    }
    
    private class ExitButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            window.setVisible(false);
        }
    }    
}
