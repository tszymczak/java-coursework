/**
 * SzymczakBanking.java
 * Programming Assignment 1, Banking
 * A simple calculator for various banking formulas, improved to use classes.
 * @author Thomas Szymczak
 * 2/29/2016
*/

package SzymczakBankingClasses;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class SzymczakBanking
{

    /* Note that throughout this program, all interest rates are entered and output as percentages, not decimals.
     * Even though we do the calculations using decimal interest rates, our input and output is in the form of
     * percentages because that's what a typical user would expect.
     */
    
    /**
     * Prompt the user for a number.
     * 
     * @param message The message to display to the user
     * @return The number the user entered
     */
    public static float getNumber( String message )
    {
        String input = JOptionPane.showInputDialog(message);
        return Float.parseFloat(input);
    }
    
    /**
     * Prompt the user for a number, and don't allow them to enter zero. We use this to prevent division by zero.
     * 
     * @param message The message to display to the user
     * @return The number the user entered
     */
    public static float getNonZero( String message )
    {
        float output;
        do {
            output = getNumber(message);
            if ( output == 0 )
            {
                JOptionPane.showMessageDialog(null, "Please enter a number other than zero.");
            }
        } while ( output == 0 );
        
        return output;
    }
    
    public static void main(String[] args)
    {
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
        // Whether or not the user wishes to rerun the program.
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
                    apr = getNumber("Enter the stated interest rate.") / 100;
                    compounding = getNonZero("Enter the number of times the interest is compounded.");

                    apy = 100*BankingClass.calcApy(apr, compounding);

                    JOptionPane.showMessageDialog(null, "The annual percentage yield is " + df.format(apy) + ".");
                    break;
                case 2:
                    // Calculate payments on a balloon loan.
                    float blPayment, blValue, blRate, blPeriods, balloonAmount;
                    blValue = getNumber("Enter the loan value.");
                    // Divide by 100 to convert the percentage to a decimal.
                    blRate = getNonZero("Enter the interest rate per period.") / 100;
                    blPeriods = getNonZero("Enter the number of periods.");
                    balloonAmount = getNumber("Enter the balloon amount.");
                    
                    blPayment = BankingClass.calcBalloonLoanPayment(blValue, blRate, blPeriods, balloonAmount);
                    
                    JOptionPane.showMessageDialog(null, "The loan payment is " + df.format(blPayment) + ".");
                    break;
                case 3:
                    // Calculate simple interest.
                    float simpleInterest, siPrincipal, siRate, siTime;
                    siPrincipal = getNumber("Enter the principal.");
                    // Divide by 100 to convert the percentage to a decimal.
                    siRate = getNumber("Enter the interest rate.") / 100;
                    siTime = getNumber("Enter the length of time.");

                    simpleInterest = BankingClass.calcSimpleInterest(siPrincipal, siRate, siTime);
                    
                    JOptionPane.showMessageDialog(null, "The amount of simple interest is " + df.format(simpleInterest)
                      + ".");
                    break;
                case 4:
                    // Calculate compound interest.
                    float compoundInterest, ciPrincipal, ciRate, ciTime;
                    
                    ciPrincipal = getNumber("Enter the principal.");
                    // Divide by 100 to convert the percentage to a decimal.
                    ciRate = getNumber("Enter the interest rate per period.") / 100;
                    ciTime = getNumber("Enter the number of time periods.");

                    compoundInterest = BankingClass.calcCompoundInterest(ciPrincipal, ciRate, ciTime);
                    
                    JOptionPane.showMessageDialog(null, "The amount of compound interest is " +
                      df.format(compoundInterest) + ".");
                    break;
                case 5:
                    // Calculate the debt to income ratio.
                    float diRatio, debt, income;
                    
                    debt = getNumber("Enter monthly debt payments.");
                    income = getNonZero("Enter gross monthly income.");
                    
                    diRatio = BankingClass.calcRatio(debt, income);
                    
                    JOptionPane.showMessageDialog(null, "The debt to income ratio is " + df.format(diRatio) + ".");
                    break;
                case 6:
                    // Calculate the dividend payout ratio.
                    float dpRatio, dpDividend, dpIncome;
                    
                    dpDividend = getNumber("Enter the amount of dividends.");
                    dpIncome = getNonZero("Enter the net income.");
                    
                    dpRatio = BankingClass.calcRatio(dpDividend, dpIncome);
                    
                    JOptionPane.showMessageDialog(null, "The dividend payout ratio is " + df.format(dpRatio) + ".");
                    break;
                case 7:
                    // Calculate the balloon balance on a balloon loan.
                    float balloonBalance, bbPrincipal, bbRate, bbPeriods, bbPayment;
                    
                    bbPrincipal = getNumber("Enter the loan's original balance.");
                    bbPayment = getNumber("Enter the payment on the loan.");
                    // Divide by 100 to convert the percentage to a decimal.
                    bbRate = getNonZero("Enter the rate per payment.") / 100;
                    bbPeriods = getNumber("Enter the number of payments.");

                    balloonBalance = BankingClass.calcBalloonBalance(bbPrincipal, bbPayment, bbRate, bbPeriods);
                    
                    JOptionPane.showMessageDialog(null, "The balloon balance is " + df.format(balloonBalance) + ".");
                    break;
                case 8:
                    // Calculate payments on a loan.
                    float loanPayment, loanAmount, loanRate, loanPeriods;
                    
                    loanAmount = getNumber("Enter the loan's original balance.");
                    // Divide by 100 to convert the percentage to a decimal.
                    loanRate = getNonZero("Enter the rate per payment.") / 100;
                    loanPeriods = getNonZero("Enter the number of payments.");

                    loanPayment = BankingClass.calcLoanPayment( loanAmount, loanRate, loanPeriods );

                    JOptionPane.showMessageDialog(null, "The loan payment is " + df.format(loanPayment) + ".");
                    break;
                case 9:
                    // Calculate the remaining balance on a loan.
                    float remainingBalance, rbPrincipal, rbPayment, rbRate, rbPeriods;
                    
                    rbPrincipal = getNumber("Enter the loan's original balance.");
                    rbPayment = getNumber("Enter the loan's payment.");
                    // Divide by 100 to convert the percentage to a decimal.
                    rbRate = getNonZero("Enter the rate per payment.") / 100;
                    rbPeriods = getNumber("Enter the number of payments made so far.");
                    
                    remainingBalance = BankingClass.calcRemainingBalance(rbPrincipal, rbPayment, rbRate, rbPeriods);
                    
                    JOptionPane.showMessageDialog(null, "The remaining balance is " + df.format(remainingBalance) +
                      ".");
                    break;
                case 10:
                    // Calculate loan to deposit ratio.
                    float ltdRatio, loans, deposits;
                                        
                    loans = getNumber("Enter the amount of loans.");
                    deposits= getNonZero("Enter the amount of deposits.");

                    ltdRatio = BankingClass.calcRatio(loans, deposits);
                    
                    JOptionPane.showMessageDialog(null, "The loan to deposit ratio is " + df.format(ltdRatio) + ".");
                    break;
                case 11:
                    // Calculate loan to value ratio.
                    float ltvRatio, loanValue, collateral;
                    
                    loanValue = getNumber("Enter the amount of the loan.");
                    collateral = getNonZero("Enter the amount of collateral.");
                    
                    ltvRatio = BankingClass.calcRatio(loanValue, collateral);
                    
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
