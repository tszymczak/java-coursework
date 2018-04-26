package SzymczakBankingGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * This is the part of the BankingCalculator program we use to calculate the dividend payout ratio.
 * @author Thomas Szymczak
 * 3-14-2016
 */
public class DividendPayoutGui extends JFrame {
    JFrame window;
    
    JPanel textPanel;
    JPanel buttonPanel;
    
    JLabel dividendLabel;
    JLabel incomeLabel;
    JLabel ratioLabel;
    
    JTextField dividendField;
    JTextField incomeField;
    JTextField ratioField;
    
    JButton calcButton;
    JButton closeButton;
    
    public static void main( String[] args )
    {
        new DividendPayoutGui();
    }

    public DividendPayoutGui()
    {
        window = new JFrame();
        
        window.setLayout(new FlowLayout());
        window.setTitle("Banking Calculator | Dividend Payout Ratio");
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
     * Set up elements of the GUI.
     */
    private void buildInterface()
    {
        // Create the first panel, containing the text fields and labels.
        textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(3, 2));
        
        dividendLabel = new JLabel("Amount of Dividends");
        dividendField = new JTextField(1);
        
        textPanel.add(dividendLabel);
        textPanel.add(dividendField);
        
        incomeLabel = new JLabel("Net Income");
        incomeField = new JTextField(1);

        textPanel.add(incomeLabel);
        textPanel.add(incomeField);
        
        ratioLabel = new JLabel("Dividend Payout Ratio");
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
            
            ratio = BankingClass.calcRatio(dividendField.getText(), incomeField.getText());
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
