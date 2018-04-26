package SzymczakBankingGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * This is the part of the BankingCalculator program that calculates debt-to-income ratios.
 * @author Thomas Szymczak
 * 3-14-2016
 */
public class DebtToIncomeGui extends JFrame {
    JFrame window;
    
    JPanel textPanel;
    JPanel buttonPanel;
    
    JLabel loanLabel;
    JLabel incomeLabel;
    JLabel ratioLabel;
    
    JTextField debtField;
    JTextField incomeField;
    JTextField ratioField;
    
    JButton calcButton;
    JButton closeButton;
    
    public static void main( String[] args )
    {
        new DebtToIncomeGui();
    }

    public DebtToIncomeGui()
    {
        window = new JFrame();
        
        window.setLayout(new FlowLayout());
        window.setTitle("Banking Calculator | Debt to Income Ratio");
        // Width, then height.
        window.setSize(400, 120);
        
        // Set up all the elements of the GUI.
        buildInterface();
        
        // Add our panels to the window.
        window.add(textPanel);
        window.add(buttonPanel);
        
        window.setVisible(true);
    }
    
    /**
     * Set up the calculator's GUI.
     */
    private void buildInterface()
    {
        // Create the first panel, containing the text fields and labels.
        textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(3, 2));
        
        loanLabel = new JLabel("Monthly debt payments");
        debtField = new JTextField(1);
        
        textPanel.add(loanLabel);
        textPanel.add(debtField);
        
        incomeLabel = new JLabel("Monthly income");
        incomeField = new JTextField(1);

        textPanel.add(incomeLabel);
        textPanel.add(incomeField);
        
        ratioLabel = new JLabel("Debt to income ratio");
        ratioField = new JTextField(1);
        ratioField.setEditable(false);
        
        textPanel.add(ratioLabel);
        textPanel.add(ratioField);

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
            float ratio;
            String ratioString;
            
            DecimalFormat df = new DecimalFormat("0.00");
            
            ratio = BankingClass.calcRatio(debtField.getText(), incomeField.getText());
            ratioString = df.format(ratio);
            ratioField.setText(ratioString);
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
