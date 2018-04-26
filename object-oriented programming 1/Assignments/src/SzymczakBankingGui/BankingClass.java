/**
 * BankingClass.java
 * A class that implements numerous finance formulas for the banking calculator.
 * @author Thomas Szymczak
 * 2/29/2016
 */
package SzymczakBankingGui;

public class BankingClass
{
    /**
     * Calculate the ratio between two numbers. A number of the formulas we implement are simple ratios, so there's no
     * point in making individual methods for them.
     * @param a The numerator of the ratio
     * @param b The denominator of the ratio
     * @return The ratio of the two inputs
     */
    public static float calcRatio(float a, float b)
    {
        return a / b;
    }

    /**
     * Calculate the ratio between two numbers. A number of the formulas we implement are simple ratios, so there's no
     * point in making individual methods for them.
     * @param StrNum The numerator of the ratio
     * @param StrDenom The denominator of the ratio
     * @return The ratio of the two inputs
     */
    public static float calcRatio(String StrNum, String StrDenom)
    {
        float num = Float.parseFloat(StrNum);
        float denom = Float.parseFloat(StrDenom);
        
        return calcRatio(num, denom);
    }

    /**
     * Calculate the annual percentage yield on a bank account or loan.
     * 
     * @param apr The stated APR on the loan or investment
     * @param compounding The number of times per year the interest is compounded
     * @return The APY on the loan or investment
     */
    public static float calcApy(float apr, float compounding)
    {
        return (float)Math.pow(1+apr/compounding,compounding) - 1;
    }
    
    /**
     * Calculate the annual percentage yield on a bank account or loan.
     * 
     * @param StrApr The stated APR on the loan or investment
     * @param StrComp The number of times per year the interest is compounded
     * @return The APY on the loan or investment
     */
    public static float calcApy(String StrApr, String StrComp)
    {
        float apr = Float.parseFloat(StrApr);
        float compounding = Float.parseFloat(StrComp);
        
        return calcApy(apr, compounding);
    }
    
    /**
     * Calculate the periodic (weekly, monthly, yearly, etc.) payment on a balloon loan.
     * 
     * @param principal The principal balance on the loan
     * @param rate The interest rate per period on the loan
     * @param periods The number of payments that must be made
     * @param balloonAmount The balance remaining at the end of the loan
     * @return The periodic payment on the loan
     */
    public static float calcBalloonLoanPayment(float principal, float rate, float periods, float balloonAmount)
    {
        return ( principal - balloonAmount / (float)Math.pow(1+rate, periods))*
          (rate/(1-(float)Math.pow(1+rate,-periods)));
    }
    
    /**
     * Calculate the periodic (weekly, monthly, yearly, etc.) payment on a balloon loan.
     * 
     * @param StrPrincipal The principal balance on the loan
     * @param StrRate The interest rate per period on the loan
     * @param StrPeriods The number of payments that must be made
     * @param StrBalloonAmount The balance remaining at the end of the loan
     * @return The periodic payment on the loan
     */
    public static float calcBalloonLoanPayment(String StrPrincipal, String StrRate, String StrPeriods,
      String StrBalloonAmount)
    {
        float principal = Float.parseFloat(StrPrincipal);
        float rate = Float.parseFloat(StrRate);
        float periods = Float.parseFloat(StrPeriods);
        float balloonAmount = Float.parseFloat(StrBalloonAmount);
        
        return calcBalloonLoanPayment(principal, rate, periods, balloonAmount);
    }
    
    /**
     * Calculate the return on an investment that pays simple interest.
     * @param principal The original amount of the investment
     * @param rate The interest rate per period of time
     * @param time The number of periods of time over which the invest accrues interest
     * @return The amount of interest
     */
    public static float calcSimpleInterest(float principal, float rate, float time)
    {
        return principal * rate * time;
    }
    
    /**
     * Calculate the return on an investment that pays simple interest.
     * @param StrPrincipal The original amount of the investment
     * @param StrRate The interest rate per period of time
     * @param StrTime The number of periods of time over which the invest accrues interest
     * @return The amount of interest
     */
    public static float calcSimpleInterest( String StrPrincipal, String StrRate, String StrTime )
    {
        float principal = Float.parseFloat(StrPrincipal);
        float rate = Float.parseFloat(StrRate);
        float time = Float.parseFloat(StrTime);
        
        return calcSimpleInterest(principal, rate, time);
    }
    
    /**
     * Calculate the amount of interest gained on an investment that pays compound interest.
     * 
     * @param principal The original amount of the investment
     * @param rate The interest rate per period of time
     * @param time The number of periods of time over which the invest accrues interest
     * @return The amount of interest
     */
    public static float calcCompoundInterest(float principal, float rate, float time)
    {
        return principal * ( (float)Math.pow(1+rate, time) - 1);
    }
    
    /**
     * Calculate the amount of interest gained on an investment that pays compound interest.
     * 
     * @param StrPrincipal The original amount of the investment
     * @param StrRate The interest rate per period of time
     * @param StrTime The number of periods of time over which the invest accrues interest
     * @return The amount of interest
     */
    public static float calcCompoundInterest(String StrPrincipal, String StrRate, String StrTime)
    {
        float principal = Float.parseFloat(StrPrincipal);
        float rate = Float.parseFloat(StrRate);
        float time = Float.parseFloat(StrTime);
        
        return calcCompoundInterest(principal, rate, time);
    }
    
    /**
     * Calculate the amount of money due at the end of balloon loan.
     * 
     * @param principal The original amount of the loan
     * @param payment The periodic payment on the loan
     * @param rate The interest rate of the loan per period of time
     * @param numPayments The number of payments to be made on the loan
     * @return The balloon amount on the loan
     */
    public static float calcBalloonBalance(float principal, float payment, float rate, float numPayments)
    {
        return principal*(float)Math.pow(1+rate, numPayments) - payment*(((float)Math.pow(1+rate, numPayments) - 1)
          / rate);
    }
    
    /**
     * Calculate the amount of money due at the end of balloon loan.
     * 
     * @param StrPrincipal The original amount of the loan
     * @param StrPayment The periodic payment on the loan
     * @param StrRate The interest rate of the loan per period of time
     * @param StrNumPayments The number of payments to be made on the loan
     * @return The balloon amount on the loan
     */
    public static float calcBalloonBalance(String StrPrincipal, String StrPayment, String StrRate, String StrNumPayments)
    {
        float principal = Float.parseFloat(StrPrincipal);
        float payment = Float.parseFloat(StrPayment);
        float rate = Float.parseFloat(StrRate);
        float numPayments = Float.parseFloat(StrNumPayments);
        
        return calcBalloonBalance(principal, payment, rate, numPayments);
    }

    /**
     * Calculate the payment on a loan.
     * 
     * @param principal The original amount of the loan
     * @param rate The interest rate of the loan per period of time
     * @param numPayments The number of payments to be made on the loan
     * @return The periodic payment on the loan
     */
    public static float calcLoanPayment(float principal, float rate, float numPayments)
    {
        return ( rate * principal )/(1-(float)Math.pow(1+rate, -numPayments));
    }
    
    /**
     * Calculate the payment on a loan.
     * 
     * @param StrPrincipal The original amount of the loan
     * @param StrRate The interest rate of the loan per period of time
     * @param StrNumPayments The number of payments to be made on the loan
     * @return The periodic payment on the loan
     */
    public static float calcLoanPayment(String StrPrincipal, String StrRate, String StrNumPayments)
    {
        float principal = Float.parseFloat(StrPrincipal);
        float rate = Float.parseFloat(StrRate);
        float numPayments = Float.parseFloat(StrNumPayments);
        
        return calcLoanPayment(principal, rate, numPayments);
    }

    /**
     * Solve for the amount of debt remaining on a loan at a certain point in time.
     * 
     * @param principal The original amount of the loan
     * @param payment The periodic payment on the loan
     * @param rate The interest rate on the loan per period of time
     * @param numPayments The number of payments made so far
     * @return The amount of money that the borrower still owes
     */
    public static float calcRemainingBalance(float principal, float payment, float rate, float numPayments)
    {
        return principal*(float)Math.pow(1+rate, numPayments) - payment *
          (((float)Math.pow(1+rate, numPayments) - 1) / rate);
    }
    
    /**
     * Solve for the amount of debt remaining on a loan at a certain point in time.
     * 
     * @param StrPrincipal The original amount of the loan
     * @param StrPayment The periodic payment on the loan
     * @param StrRate The interest rate on the loan per period of time
     * @param StrNumPayments The number of payments made so far
     * @return The amount of money that the borrower still owes
     */
    public static float calcRemainingBalance( String StrPrincipal, String StrPayment, String StrRate,
      String StrNumPayments)
    {
        float principal = Float.parseFloat(StrPrincipal);
        float payment = Float.parseFloat(StrPayment);
        float rate = Float.parseFloat(StrRate);
        float numPayments = Float.parseFloat(StrNumPayments);
        
        return calcRemainingBalance(principal, payment, rate, numPayments);
    }

}
