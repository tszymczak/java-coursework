package SzymczakLoanInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;


/**
 * Display the results of the user's loan application using JOptionPane.
 * @author Thomas Szymczak
 * 4/23/2016
 */
public class ResultsWindow {

    Loan loan;
    
    public ResultsWindow(Loan inLoan)
    {
        loan = inLoan;
        String info = buildInfoString();
        JOptionPane.showMessageDialog(null, info);
    }
    
    /** Gather the data about the loan and format it for display.
     * 
     * @return The data to be displayed in the window.
     */
    private String buildInfoString()
    {
        DecimalFormat dollars = new DecimalFormat("#,##0.00");
        DecimalFormat precise = new DecimalFormat("0.000");
        
        String type;
        String principal;
        String amount;
        String term;
        String closing;
        String escrow;
        String yearlyRate;
        String monthlyRate;
        String payment;
        String info;
        
        // Get the type of the loan.
        if ( loan instanceof CommercialLoan )
            type = "Commercial/Contractor";
        else if ( loan instanceof HomeLoan )
            type = "Home";
        else if ( loan instanceof CarLoan )
            type = "Car";
        else
            type = "Unknown";

        // Get various other attributes of the loan.
        principal = dollars.format(loan.getPrincipal());
        amount = dollars.format(loan.calcTotalFinanced());
        term = Integer.toString(loan.getTerm());
        closing = dollars.format(loan.getClosing());
        escrow = dollars.format(loan.getEscrow());
        yearlyRate = dollars.format(loan.getRate());
        // We format the monthly interest rate to three decimal places. I think it looks better this way.
        monthlyRate = precise.format(loan.calcMonthlyRate());
        payment = dollars.format(loan.calcPayment());
        closing = dollars.format(loan.getClosing());
        
        info = "Loan info:\n" +
                "Loan Type: " + type + "\n" +
                "Principal: $" + principal + "\n" +
                "Total Amount Borrowed: $" + amount + "\n" +
                "Term: " + term + " years\n" +
                "Closing cost: $" + closing + "\n" +
                "Escrow fee: $" + escrow + "\n" +
                "Interest Rate (monthly): " + monthlyRate + "%\n" +
                "Interest Rate (yearly): " + yearlyRate + "%\n" +
                "Monthly Payment: $" + payment + "\n";

        return info;
    }    
}
