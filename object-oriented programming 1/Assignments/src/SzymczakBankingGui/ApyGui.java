package SzymczakBankingGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * This is the part of the BankingCalculator program that handles the APY calculations.
 * @author Thomas Szymczak
 * 3-13-2016
 */
public class ApyGui extends JFrame {
    JFrame window;
    
    JPanel textPanel;
    JPanel buttonPanel;
    
    JLabel aprLabel;
    JLabel compLabel;
    JLabel apyLabel;
    
    JTextField aprField;
    JTextField compField;
    JTextField apyField;
    
    JButton calcButton;
    JButton closeButton;
    
    public static void main( String[] args )
    {
        new ApyGui();
    }
    
    public ApyGui()
    {
        window = new JFrame();
        
        window.setLayout(new FlowLayout());
        window.setTitle("Banking Calculator | APY");
        // Width, then height.
        window.setSize(600, 120);
        
        // Set up all the elements of the GUI.
        buildInterface();
        
        // Add our panels to the window.
        window.add(textPanel);
        window.add(buttonPanel);
        
        window.setVisible(true);
    }
    
    /**
     * Set up the GUI.
     */
    private void buildInterface()
    {
        // Create the first panel, containing the text fields and labels.
        textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(3, 2));
        
        aprLabel = new JLabel("The annual percentage rate");
        aprField = new JTextField(1);
        
        textPanel.add(aprLabel);
        textPanel.add(aprField);
        
        compLabel = new JLabel("How many times interest is compounded");
        compField = new JTextField(1);

        textPanel.add(compLabel);
        textPanel.add(compField);
        
        apyLabel = new JLabel("Annual percentage yield");
        apyField = new JTextField(1);
        apyField.setEditable(false);
        
        textPanel.add(apyLabel);
        textPanel.add(apyField);

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
            float apr;
            float compounding;
            float apy;
            String apyString;
            
            DecimalFormat df = new DecimalFormat("0.00");
            
            // We divide by 100 because the user enters the APR in percent, but the banking class uses the decimal.
            apr = Float.parseFloat(aprField.getText()) / 100;
            compounding = Float.parseFloat(compField.getText());
            // We multiply by 100 because the banking class uses the decimal rate, but we want to display it as a
            //  percentage.
            apy = BankingClass.calcApy(apr, compounding) * 100;
            apyString = df.format(apy) + "%";
            apyField.setText(apyString);
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
