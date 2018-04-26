package SzymczakLoanInfo;

/**
 * This class stores and calculates information about home loans, a type of loan.
 * @author Thomas Szymczak
 * 4/24/2016
 */
public class HomeLoan extends Loan
{
    // A home loan can have only three terms: 15, 20, or 30 years.
    public static final int[] TERMS = {15, 20, 30};
    // All home loans have the same interest rate.
    public static final double INTEREST_RATE = 5.0;
    // Closing is the closing fee associated with the loan. This is always $3050.00.
    private static final double CLOSING = 3050.00;
    // Escrow is the amount of the closing fee that must be paid upon receiving the loan. The rest of the closing fee
    // is added to the balance of the loan. This amount is always $1500.00.
    private static final double ESCROW = 1500.00;

    /**
     * Create a new home loan.
     * @param inPrincipal The amount of money borrowed
     * @param inTerm The index of the TERMS[] array that holds the term of the loan
     */
    public HomeLoan(double inPrincipal, int inTerm)
    {
        // Set all the parameters for the loan.
        super.setPrincipal(inPrincipal);
        super.setRate(INTEREST_RATE);
        super.setTerm(TERMS[inTerm]);
        super.setClosing(CLOSING);
        super.setEscrow(ESCROW);
    }
    
    /**
     * Create a new home loan, with the amount set to zero and fees set to the default.
     */
    public HomeLoan()
    {
        super.setPrincipal(0);
        super.setClosing(CLOSING);
        super.setEscrow(ESCROW);
    }
}
