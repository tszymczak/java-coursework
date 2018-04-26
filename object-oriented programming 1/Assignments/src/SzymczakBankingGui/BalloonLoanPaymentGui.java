package SzymczakBankingGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * A graphical balloon loan payment calculator. Part of the BankingCalculator program.
 * @author Thomas Szymczak
 * 3-13-2016
 */
public class BalloonLoanPaymentGui extends JFrame {
    JFrame window;

    JPanel textPanel;
    JPanel buttonPanel;

    JLabel principalLabel;
    JLabel rateLabel;
    JLabel numPaymentsLabel;
    JLabel balloonAmountLabel;
    JLabel paymentLabel;

    JTextField principalField;
    JTextField rateField;
    JTextField numPaymentsField;
    JTextField balloonAmountField;
    JTextField paymentField;

    JButton calcButton;
    JButton closeButton;
    
    public static void main(String[] args) {
        new BalloonLoanPaymentGui();
    }

    public BalloonLoanPaymentGui()
    {
        window = new JFrame();
        
        window.setLayout(new FlowLayout());
        window.setTitle("Banking Calculator | Balloon Loan Payments");
        // Width, then height.
        window.setSize(680, 160);
        
        // Set up the bits and pieces of the GUI
        buildInterface();
        
        // Add our panels to the window.
        window.add(textPanel);
        window.add(buttonPanel);
        
        window.setVisible(true);
    }
    
    /**
     * Set up the panels of the GUI.
     */
    private void buildInterface()
    {
        // The first panel contains the text fields for input and output.
        textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(5, 2));
        
        principalLabel = new JLabel("The loan's principal");
        principalField = new JTextField(1);
        
        textPanel.add(principalLabel);
        textPanel.add(principalField);
        
        rateLabel = new JLabel("The interest rate per payment(%)");
        rateField = new JTextField(1);

        textPanel.add(rateLabel);
        textPanel.add(rateField);
        
        numPaymentsLabel = new JLabel("The number of payments that must be made");
        numPaymentsField = new JTextField(1);
        
        textPanel.add(numPaymentsLabel);
        textPanel.add(numPaymentsField);
        
        balloonAmountLabel = new JLabel("The balloon balance");
        balloonAmountField = new JTextField(1);
        
        textPanel.add(balloonAmountLabel);
        textPanel.add(balloonAmountField);
        
        paymentLabel = new JLabel("Loan payment");
        paymentField = new JTextField(1);
        paymentField.setEditable(false);
        
        textPanel.add(paymentLabel);
        textPanel.add(paymentField);
        
        // The second panel contains the buttons.
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
            payment = BankingClass.calcBalloonLoanPayment(principalField.getText(), rateString,
              numPaymentsField.getText(), balloonAmountField.getText());
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
