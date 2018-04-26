package SzymczakBankingGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * This is the part of the BankingCalculator program that calculates the balloon balance on a loan.
 * @author Thomas Szymczak
 * 3-14-2016
 */
public class BalloonBalanceGui extends JFrame {
    JFrame window;
    
    JPanel textPanel;
    JPanel buttonPanel;
    
    JLabel principalLabel;
    JLabel paymentLabel;
    JLabel rateLabel;
    JLabel numPaymentsLabel;
    JLabel balanceLabel;
    
    JTextField principalField;
    JTextField paymentField;
    JTextField rateField;
    JTextField numPaymentsField;
    JTextField balanceField;
    
    JButton calcButton;
    JButton closeButton;
    
    public static void main( String[] args )
    {
        new BalloonBalanceGui();
    }

    public BalloonBalanceGui()
    {
        window = new JFrame();
        
        window.setLayout(new FlowLayout());
        window.setTitle("Banking Calculator | Balloon Balance");
        // Width, then height.
        window.setSize(580, 160);
        
        // Set up all the elements of the GUI.
        buildInterface();
        
        // Add our panels to the window.
        window.add(textPanel);
        window.add(buttonPanel);
        
        window.setVisible(true);
    }
    
    /**
     * Set up the GUI for the balloon balance calculator.
     */
    private void buildInterface()
    {
        // Create the first panel, containing the text fields and labels.
        textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(5, 2));
        
        principalLabel = new JLabel("The loan's principal");
        principalField = new JTextField(1);
        
        textPanel.add(principalLabel);
        textPanel.add(principalField);
        
        paymentLabel = new JLabel("The loan's payment");
        paymentField = new JTextField(1);

        textPanel.add(paymentLabel);
        textPanel.add(paymentField);
        
        rateLabel = new JLabel("The loan's interest rate per payment (%)");
        rateField = new JTextField(1);

        textPanel.add(rateLabel);
        textPanel.add(rateField);
        
        numPaymentsLabel = new JLabel("The number of payments");
        numPaymentsField = new JTextField(1);
        
        textPanel.add(numPaymentsLabel);
        textPanel.add(numPaymentsField);
        
        balanceLabel = new JLabel("The balloon balance");
        balanceField = new JTextField(1);
        balanceField.setEditable(false);
        
        textPanel.add(balanceLabel);
        textPanel.add(balanceField);

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
            float balance;
            String balanceString;
            
            DecimalFormat df = new DecimalFormat("0.00");
            
            // We divide by 100 because the user enters the rate in percent, but the banking class uses the decimal.
            rate = Float.parseFloat(rateField.getText()) / 100;
            rateString = Float.toString(rate);
            // We multiply by 100 because the banking class uses the decimal rate, but we want to display it as a
            // percentage.
            balance = BankingClass.calcBalloonBalance(principalField.getText(), paymentField.getText(), rateString,
              numPaymentsField.getText());
            balanceString = df.format(balance);
            balanceField.setText(balanceString);
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
