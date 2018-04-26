package SzymczakBankingGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A simple GUI calculator for eleven different finance formulas.
 * @author Thomas Szymczak
 * 03/06/2016
 */
public class BankingCalculator extends JFrame {

    private JPanel panel;
    
    private JLabel title;
    
    private JRadioButton radio1;
    private JRadioButton radio2;
    private JRadioButton radio3;
    private JRadioButton radio4;
    private JRadioButton radio5;
    private JRadioButton radio6;
    private JRadioButton radio7;
    private JRadioButton radio8;
    private JRadioButton radio9;
    private JRadioButton radio10;
    private JRadioButton radio11;
    

    public static void main( String[] args )
    {
        new BankingCalculator();
    }

    public BankingCalculator()
    {
        // Create an empty window, and set various attributes:
        JFrame window = new JFrame();
        window.setTitle("Banking Calculator");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new FlowLayout());
        
        buildMainInterface();
        
        window.add(panel);
        
        // Automatically choose the right size for the window.
        window.pack();
        
        window.setVisible(true);
    }
    
    // Set up all the bits and pieces of the GUI.
    private void buildMainInterface()
    {
        panel = new JPanel();
        
        panel.setLayout(new GridLayout(12,1));
        
        // Display a heading at the top of the window.
        title = new JLabel( "What do you want to calculate?");
        panel.add(title);
        
        // Create some radio buttons.
        ButtonGroup radioButtons = new ButtonGroup();
        
        radio1 = new JRadioButton("Annual Percentage Yield");
        radioButtons.add(radio1);
        radio2 = new JRadioButton("Balloon Loan Payments");
        radioButtons.add(radio2);
        radio3 = new JRadioButton("Simple Interest");
        radioButtons.add(radio3);
        radio4 = new JRadioButton("Compound Interest");
        radioButtons.add(radio4);
        radio5 = new JRadioButton("Debt to Income Ratio");
        radioButtons.add(radio5);
        radio6 = new JRadioButton("Dividend Payout Ratio");
        radioButtons.add(radio6);
        radio7 = new JRadioButton("Loan: Balloon Balance");
        radioButtons.add(radio7);
        radio8 = new JRadioButton("Loan: Payment");
        radioButtons.add(radio8);
        radio9 = new JRadioButton("Loan: Remaining Balance");
        radioButtons.add(radio9);
        radio10 = new JRadioButton("Loan to Deposit Ratio");
        radioButtons.add(radio10);
        radio11 = new JRadioButton("Loan to Value");
        radioButtons.add(radio11);

        radio1.addActionListener(new RadioButtonListener());
        radio2.addActionListener(new RadioButtonListener());
        radio3.addActionListener(new RadioButtonListener());
        radio4.addActionListener(new RadioButtonListener());
        radio5.addActionListener(new RadioButtonListener());
        radio6.addActionListener(new RadioButtonListener());
        radio7.addActionListener(new RadioButtonListener());
        radio8.addActionListener(new RadioButtonListener());
        radio9.addActionListener(new RadioButtonListener());
        radio10.addActionListener(new RadioButtonListener());
        radio11.addActionListener(new RadioButtonListener());
        
        panel.add(radio1);
        panel.add(radio2);
        panel.add(radio3);
        panel.add(radio4);
        panel.add(radio5);
        panel.add(radio6);
        panel.add(radio7);
        panel.add(radio8);
        panel.add(radio9);
        panel.add(radio10);
        panel.add(radio11);
    }
    
    private class RadioButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // Each of these objects represents one of the calculators that can be opened from the main window.
            ApyGui apyWindow;
            BalloonLoanPaymentGui blpWindow;
            SimpleInterestGui siWindow;
            CompoundInterestGui ciWindow;
            DebtToIncomeGui diWindow;
            DividendPayoutGui dpWindow;
            BalloonBalanceGui bbWindow;
            LoanPaymentGui lpWindow;
            LoanRemainingBalanceGui lrbWindow;
            LoanToDepositGui ldWindow;
            LoanToValueGui lvWindow;
            
            // Whenever the user clicks one of the radio buttons, open the corresponding calculator window.
            if ( e.getSource() == radio1 )
                apyWindow = new ApyGui();
            else if ( e.getSource() == radio2 )
                blpWindow = new BalloonLoanPaymentGui();
            else if ( e.getSource() == radio3 )
                siWindow = new SimpleInterestGui();
            else if ( e.getSource() == radio4 )
                ciWindow = new CompoundInterestGui();
            else if ( e.getSource() == radio5 )
                diWindow = new DebtToIncomeGui();
            else if ( e.getSource() == radio6 )
                dpWindow = new DividendPayoutGui();
            else if ( e.getSource() == radio7 )
                bbWindow = new BalloonBalanceGui();
            else if ( e.getSource() == radio8 )
                lpWindow = new LoanPaymentGui();
            else if ( e.getSource() == radio9 )
                lrbWindow = new LoanRemainingBalanceGui();
            else if ( e.getSource() == radio10 )
                ldWindow = new LoanToDepositGui();
            else if ( e.getSource() == radio11 )
                lvWindow = new LoanToValueGui();
        }
    }    
}