package SzymczakLoanInfo;

/**
 * This class stores and calculates information about loans.
 * @author Thomas Szymczak
 * 4/23/2016
 */
public class Loan
{
    // The loan's principal, not including any fees.
    private double principal;
    // The loan's interest rate, per month, represented as a decimal. We store it in this format, which makes payment
    // calculations easier, but all input and output is done as a percentage per year.
    private double rate;
    // The term of the loan in years.
    private int term;
    // The closing cost of the loan.
    private double closing;
    // The escrow fee on the loan.
    private double escrow;

    /**
     * Create a new loan, with all fields set to zero.
     */
    public Loan()
    {
        principal = 0;
        rate = 0;
        term = 0;
        closing = 0;
        escrow = 0;
    }
    
    /**
     * Create a new loan.
     * @param inPrincipal The amount of money that is being borrowed, excluding fees
     * @param inRate The interest rate (percent per year) on the loan
     * @param inTerm The length of time (in years) over which the loan will be paid off
     * @param inClosing The closing fee associated with the loan.
     * @param inEscrow  The escrow fee associated with the loan. More specifically, it is the amount of the
     * closing fee that will not be financed with the loan. Instead, it is due when the loan starts. This should not be
     * larger than the closing fee.
     */
    public Loan(double inPrincipal, double inRate, int inTerm, double inClosing, double inEscrow)
    {
        principal = inPrincipal;
        rate = inRate / 1200;
        term = inTerm;
        closing = inClosing;
        escrow = inEscrow;
    }
    
    /**
     * Get the principal amount on the loan.
     * @return The principal
     */
    public double getPrincipal()
    {
        return principal;
    }
    
    /**
     * Get the interest rate on the loan, in percent per year.
     * @return The interest rate
     */
    public double getRate()
    {
        return rate * 1200;
    }
    
    /**
     * Get the term of the loan, in years.
     * @return The term
     */
    public int getTerm()
    {
        return term;
    }
    
    /**
     * Get the closing fee of the loan.
     * @return The closing fee
     */
    public double getClosing()
    {
        return closing;
    }
    
    /**
     * Get the escrow fee of the loan.
     * @return The escrow fee
     */
    public double getEscrow()
    {
        return escrow;
    }
    
    /**
     * Set the loan's principal (excluding fees).
     * @param inPrincipal The principal
     */
    public void setPrincipal(double inPrincipal)
    {
        principal = inPrincipal;
    }
    
    /**
     * Set the interest rate of the loan, in percent per year.
     * @param inRate The interest rate
     */
    public void setRate(double inRate)
    {
        rate = inRate / 1200;
    }
    
    /**
     * Set the term of the loan, in years
     * @param inTerm The term
     */
    public void setTerm(int inTerm)
    {
        term = inTerm;
    }
    
    /**
     * Set the closing fee of the loan.
     * @param inClosing The closing fee
     */
    public void setClosing(double inClosing)
    {
        closing = inClosing;
    }
    
    /**
     * Set the escrow fee. This should be less than or equal to the closing fee.
     * @param inEscrow The escrow fee
     */
    public void setEscrow(double inEscrow)
    {
        escrow = inEscrow;
    }
    
    /**
     * Calculate the total amount that has to be paid off. This is equal to the principal, plus the closing fee, minus
     * the escrow fee.
     * @return The total amount of the loan
     */
    public double calcTotalFinanced()
    {
        return principal + closing - escrow;
    }
    
    /**
     * Calculate the monthly percent interest rate based on the annual percentage rate.
     * @return The monthly interest rate
     */
    public double calcMonthlyRate()
    {
        return rate * 100;
    }
    
    /**
     * Calculate the monthly payment on the loan.
     * @return The monthly payment
     */
    public double calcPayment()
    {
        double amount = calcTotalFinanced();
        int payments = term * 12;
        return ( rate * amount )/(1-(float)Math.pow(1+rate, -payments));
    }
}
