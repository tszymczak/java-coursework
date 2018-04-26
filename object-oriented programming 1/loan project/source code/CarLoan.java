package SzymczakLoanInfo;

/**
 * This class stores and calculates information about car loans, a type of loan.
 * @author Thomas Szymczak
 * 4/23/3016
 */
public class CarLoan extends Loan
{
    // A car loan can have only three terms: 4, 5, or 6 years.
    public static final int[] TERMS = {4, 5, 6};
    // All car loans have an annual percentage rate of 6%.
    public static final double INTEREST_RATE = 6.0;
    
    /**
     * Create a new car loan.
     * @param inPrincipal The amount of money borrowed
     * @param inTerm The index of the TERMS[] array that holds the term of the loan.
     */
    public CarLoan(double inPrincipal, int inTerm)
    {
        // Set all the parameters for the loan.
        super.setPrincipal(inPrincipal);
        super.setRate(INTEREST_RATE);
        super.setTerm(TERMS[inTerm]);
        super.setClosing(0);
        super.setEscrow(0);
    }
    
    /**
     * Create a new car loan, with all parameters set to zero.
     */
    public CarLoan()
    {
        super.setPrincipal(0);
        super.setClosing(0);
        super.setEscrow(0);
    }
}
