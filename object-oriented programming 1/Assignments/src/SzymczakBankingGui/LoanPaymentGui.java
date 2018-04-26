package SzymczakBankingGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * This is the part of the BankingCalculator program that calculates payments on loan.
 * @author Thomas Szymczak
 * 3-14-2016
 */
public class LoanPaymentGui extends JFrame {
    JFrame window;
    
    JPanel textPanel;
    JPanel buttonPanel;
    
    JLabel principalLabel;
    JLabel rateLabel;
    JLabel numPaymentsLabel;
    JLabel paymentLabel;
    
    JTextField principalField;
    JTextField rateField;
    JTextField numPaymentsField;
    JTextField paymentField;
    
    JButton calcButton;
    JButton closeButton;
    
    public static void main( String[] args )
    {
        new LoanPaymentGui();
    }

    public LoanPaymentGui()
    {
        window = new JFrame();
        
        window.setLayout(new FlowLayout());
        window.setTitle("Banking Calculator | Loan Payments");
        // Width, then height.
        window.setSize(600, 140);
        
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
        
        principalLabel = new JLabel("The loan amount");
        principalField = new JTextField(1);
        
        textPanel.add(principalLabel);
        textPanel.add(principalField);
        
        rateLabel = new JLabel("The loan's interest rate per payment (%)");
        rateField = new JTextField(1);

        textPanel.add(rateLabel);
        textPanel.add(rateField);
        
        numPaymentsLabel = new JLabel("The number of payments");
        numPaymentsField = new JTextField(1);
        
        textPanel.add(numPaymentsLabel);
        textPanel.add(numPaymentsField);
        
        paymentLabel = new JLabel("Loan payment");
        paymentField = new JTextField(1);
        paymentField.setEditable(false);
        
        textPanel.add(paymentLabel);
        textPanel.add(paymentField);

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
            float payment;
            String paymentString;
            
            DecimalFormat df = new DecimalFormat("0.00");
            
            // We divide by 100 because the user enters the rate in percent, but the banking class uses decimals.
            rate = Float.parseFloat(rateField.getText()) / 100;
            rateString = Float.toString(rate);
            payment = BankingClass.calcLoanPayment(principalField.getText(), rateString, numPaymentsField.getText());
            paymentString = df.format(payment);
            paymentField.setText(paymentString);
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
