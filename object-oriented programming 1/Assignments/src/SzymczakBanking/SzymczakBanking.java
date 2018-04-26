/**
 * SzymczakBanking.java
 * Programming Assignment 2, Choice 3: Banking
 * Thomas Szymczak
 * 2/6/2016
 * A simple calculator for various banking formulas.
*/
package SzymczakBanking;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class SzymczakBanking {

    /* Note that throughout this program, all interest rates are entered and output as percentages, not decimals.
     * Even though we do the calculations using decimal interest rates, our input and output is in the form of
     * percentages because that's what a typical user would expect.
     */

    public static void main(String[] args) {
        // Use a string as a temporary variable, to store input from JOptionPane before parsing it.
        String input;
        // This is the menu of options we present the user with.
        String options = "Which calculation do you wish to perform?\n" +
          "1: Calculate Annual Percentge Yield\n" +
          "2: Calculate Balloon Loan -- Payments\n" +
          "3: Calculate Simple Interest\n" +
          "4: Calculate Compound Interest\n" +
          "5: Calculate Debt to Income Ratio\n" +
          "6: Calculate Dividend Payout Ratio\n" +
          "7: Calculate Loan -- Balloon Balance\n" +
          "8: Calculate Loan -- Payment\n" +
          "9: Calculate Loan -- Remaining Balance\n" +
          "10: Calculate Loan to Deposit Ratio\n" +
          "11: Calculate Loan to Value (LTV)\n" +
          "12: End the Program\n";
        int option;
        // Whether or not the user wishes to run the program again.
        boolean repeat = true;
        
        // Format numbers to two decimal places.
        DecimalFormat df = new DecimalFormat( "0.00" );
        
        
        while (repeat) {
                input = JOptionPane.showInputDialog(options);
                option = Integer.parseInt(input);          
            
            switch (option)
            {
                case 1:
                    // Calculate annual percentage yield.
                    float apy, apr, compounding;
                    input = JOptionPane.showInputDialog("Enter the stated interest rate.");
                    // Divide by 100 to convert the percentage to a decimal.
                    apr = Float.parseFloat(input)/100;
                    do {
                        input = JOptionPane.showInputDialog("Enter the number of times the interest is compounded.");
                        compounding = Float.parseFloat(input);
                        if ( compounding == 0 )
                        {
                            JOptionPane.showMessageDialog(null, "Please enter a number other than zero.");
                        }
                    } while ( compounding == 0 );

                    // Multiply by 100 to convert the decimal APY to a percentage.
                    apy = 100*((float)Math.pow(1+apr/compounding,compounding) - 1);

                    JOptionPane.showMessageDialog(null, "The annual percentage yield is " + df.format(apy) + " %.");
                    break;
                case 2:
                    // Calculate payments on a balloon loan.
                    float blPayment, blValue, blRate, blPeriods, balloonAmount;
                    input = JOptionPane.showInputDialog("Enter the loan value.");
                    blValue = Float.parseFloat(input);
                    do {
                        input = JOptionPane.showInputDialog("Enter the interest rate per period.");
                        // Divide by 100 to convert the percentage to a decimal.
                        blRate = Float.parseFloat(input) / 100;
                        if ( blRate == 0 )
                        {
                            JOptionPane.showMessageDialog(null, "Please enter a number other than zero.");
                        }
                    } while ( blRate == 0 );
                    do {
                        input = JOptionPane.showInputDialog("Enter the number of periods.");
                        blPeriods = Float.parseFloat(input);
                        if ( blPeriods == 0 )
                        {
                            JOptionPane.showMessageDialog(null, "Please enter a number other than zero.");
                        }
                    } while ( blPeriods == 0 );
                    input = JOptionPane.showInputDialog("Enter the balloon amount.");
                    balloonAmount = Float.parseFloat(input);
                    
                    blPayment = ( blValue - balloonAmount / (float)Math.pow(1+blRate,
                      blPeriods))*(blRate/(1-(float)Math.pow(1+blRate,-blPeriods)));
                    
                    JOptionPane.showMessageDialog(null, "The loan payment is " + df.format(blPayment) + ".");
                    break;
                case 3:
                    // Calculate simple interest.
                    float simpleInterest, siPrincipal, siRate, siTime;
                    input = JOptionPane.showInputDialog("Enter the principal.");
                    siPrincipal = Float.parseFloat(input);
                    input = JOptionPane.showInputDialog("Enter the interest rate.");
                    // Divide by 100 to convert the percentage to a decimal.
                    siRate = Float.parseFloat(input) / 100;
                    input = JOptionPane.showInputDialog("Enter the length of time.");
                    siTime = Float.parseFloat(input);

                    simpleInterest = siPrincipal * siRate * siTime;
                    
                    JOptionPane.showMessageDialog(null, "The amount of simple interest is " + df.format(simpleInterest)
                      + ".");
                    break;
                case 4:
                    // Calculate compound interest.
                    float compoundInterest, ciPrincipal, ciRate, ciTime;
                    input = JOptionPane.showInputDialog("Enter the principal.");
                    ciPrincipal = Float.parseFloat(input);
                    input = JOptionPane.showInputDialog("Enter the interest rate per period.");
                    // Divide by 100 to convert the percentage to a decimal.
                    ciRate = Float.parseFloat(input) / 100;
                    input = JOptionPane.showInputDialog("Enter the number of time periods.");
                    ciTime = Float.parseFloat(input);

                    compoundInterest = ciPrincipal * ((float)Math.pow(1+ciRate, ciTime) - 1);
                    
                    JOptionPane.showMessageDialog(null, "The amount of compound interest is " +
                      df.format(compoundInterest) + ".");
                    break;
                case 5:
                    // Calculate the debt to income ratio.
                    float diRatio, debt, income;
                    
                    input = JOptionPane.showInputDialog("Enter monthly debt payments.");
                    debt = Float.parseFloat(input);
                    do {
                        input = JOptionPane.showInputDialog("Enter gross monthly income.");
                        income = Float.parseFloat(input);
                        if ( income == 0 )
                        {
                            JOptionPane.showMessageDialog(null, "Please enter a number other than zero.");
                        }
                    } while ( income == 0 );
                    
                    diRatio = debt / income;
                    
                    JOptionPane.showMessageDialog(null, "The debt to income ratio is " + df.format(diRatio) + ".");
                    break;
                case 6:
                    // Calculate the dividend payout ratio.
                    float dpRatio, dpDividend, dpIncome;
                    
                    input = JOptionPane.showInputDialog("Enter the amount of dividends.");
                    dpDividend = Float.parseFloat(input);
                    do {
                        input = JOptionPane.showInputDialog("Enter the net income.");
                        dpIncome = Float.parseFloat(input);
                        if ( dpIncome == 0 )
                        {
                            JOptionPane.showMessageDialog(null, "Please enter a number other than zero.");
                        }
                    } while ( dpIncome == 0 );
                    
                    dpRatio = dpDividend / dpIncome;
                    
                    JOptionPane.showMessageDialog(null, "The dividend payout ratio is " + df.format(dpRatio) + ".");
                    break;
                case 7:
                    // Calculate the balloon balance on a balloon loan.
                    float balloonBalance, bbPrincipal, bbRate, bbPeriods, bbPayment;
                    
                    input = JOptionPane.showInputDialog("Enter the loan's original balance.");
                    bbPrincipal = Float.parseFloat(input);
                    input = JOptionPane.showInputDialog("Enter the payment on the loan.");
                    bbPayment = Float.parseFloat(input);
                    do {
                        input = JOptionPane.showInputDialog("Enter the rate per payment.");
                        // Divide by 100 to convert the percentage to a decimal.
                        bbRate = Float.parseFloat(input) / 100;
                        if ( bbRate == 0 )
                        {
                            JOptionPane.showMessageDialog(null, "Please enter a number other than zero.");
                        }
                    } while ( bbRate == 0 );
                    input = JOptionPane.showInputDialog("Enter the number of payments.");
                    bbPeriods = Float.parseFloat(input);

                    balloonBalance = bbPrincipal*(float)Math.pow(1+bbRate, bbPeriods) -
                      bbPayment*(((float)Math.pow(1+bbRate, bbPeriods) - 1) / bbRate);
                    
                    JOptionPane.showMessageDialog(null, "The balloon balance is " + df.format(balloonBalance) + ".");
                    break;
                case 8:
                    // Calculate payments on a loan.
                    float loanPayment, loanAmount, loanRate, loanPeriods;
                    
                    input = JOptionPane.showInputDialog("Enter the loan's original balance.");
                    loanAmount = Float.parseFloat(input);
                    do {
                        input = JOptionPane.showInputDialog("Enter the rate per payment.");
                        // Divide by 100 to convert the percentage to a decimal.
                        loanRate = Float.parseFloat(input) / 100;
                        if ( loanRate == 0 )
                        {
                            JOptionPane.showMessageDialog(null, "Please enter a number other than zero.");
                        }
                    } while ( loanRate == 0 );
                    do {
                        input = JOptionPane.showInputDialog("Enter the number of payments.");
                        loanPeriods = Float.parseFloat(input);
                        if ( loanPeriods == 0 )
                        {
                            JOptionPane.showMessageDialog(null, "Please enter a number other than zero.");
                        }
                    } while ( loanPeriods == 0 );

                    loanPayment = ( loanRate * loanAmount )/(1-(float)Math.pow(1+loanRate, -loanPeriods));

                    JOptionPane.showMessageDialog(null, "The loan payment is " + df.format(loanPayment) + ".");
                    break;
                case 9:
                    // Calculate the remaining balance on a loan.
                    float remainingBalance, rbPrincipal, rbPayment, rbRate, rbPeriods;
                    
                    input = JOptionPane.showInputDialog("Enter the loan's original balance.");
                    rbPrincipal = Float.parseFloat(input);
                    input = JOptionPane.showInputDialog("Enter the loan's payment.");
                    rbPayment = Float.parseFloat(input);
                    do {
                        input = JOptionPane.showInputDialog("Enter the rate per payment.");
                        // Divide by 100 to convert the percentage to a decimal.
                        rbRate = Float.parseFloat(input) / 100;
                        if ( rbRate == 0 )
                        {
                            JOptionPane.showMessageDialog(null, "Please enter a number other than zero.");
                        }
                    } while ( rbRate == 0 );
                    input = JOptionPane.showInputDialog("Enter the number of payments made so far.");
                    rbPeriods = Float.parseFloat(input);
                    
                    remainingBalance = rbPrincipal*(float)Math.pow(1+rbRate, rbPeriods) - rbPayment *
                      (((float)Math.pow(1+rbRate, rbPeriods) - 1) / rbRate);
                    
                    JOptionPane.showMessageDialog(null, "The remaining balance is " + df.format(remainingBalance) +
                      ".");
                    break;
                case 10:
                    // Calculate loan to deposit ratio.
                    float ltdRatio, loans, deposits;
                                        
                    input = JOptionPane.showInputDialog("Enter the amount of loans.");
                    loans = Float.parseFloat(input);
                    do {
                        input = JOptionPane.showInputDialog("Enter the amount of deposits.");
                        deposits = Float.parseFloat(input);
                        if ( deposits == 0 )
                        {
                            JOptionPane.showMessageDialog(null, "Please enter a number other than zero.");
                        }
                    } while ( deposits == 0 );

                    ltdRatio = loans / deposits;
                    
                    JOptionPane.showMessageDialog(null, "The loan to deposit ratio is " + df.format(ltdRatio) + ".");
                    break;
                case 11:
                    // Calculate loan to value ratio.
                    float ltvRatio, loanValue, collateral;
                    
                    input = JOptionPane.showInputDialog("Enter the amount of the loan.");
                    loanValue = Float.parseFloat(input);
                    do {
                        input = JOptionPane.showInputDialog("Enter the amount of collateral.");
                        collateral = Float.parseFloat(input);
                        if ( collateral == 0 )
                        {
                            JOptionPane.showMessageDialog(null, "Please enter a number other than zero.");
                        }
                    } while ( collateral == 0 );
                    
                    ltvRatio = loanValue / collateral;
                    
                    JOptionPane.showMessageDialog(null, "The loan to value ratio is " + df.format(ltvRatio) + ".");
                    break;
                case 12:
                    // If the user selects option 12, end the program.
                    repeat = false;
                    break;
                default:
                    // When the user selects an invalid option, display an error and prompt them again.
                    JOptionPane.showMessageDialog(null, "Please enter a number beteen 1 and 12.");
                    break;  
            }
        }
    }
    
}
