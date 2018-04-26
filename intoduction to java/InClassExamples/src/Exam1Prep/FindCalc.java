package Exam1Prep;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Question 2: FindCalc.java
 * Calculate the result of a base raised to a power.
 * @author Thomas Szymczak
 * 09-21-2015
 */
public class FindCalc {

    public static void main(String[] args) {
        double num1, num2, result;
        String resultFormat;
        
        DecimalFormat df = new DecimalFormat("#,##0.000");
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the 1st number --> ");
        num1 = scan.nextDouble();
        
        System.out.print("Enter the 2nd number --> ");
        num2 = scan.nextDouble();
        
        result = Math.pow( num1, num2);
        resultFormat = df.format( result );
        
        System.out.println("The base of " + num1 + " raised to the power of " +
         num2 + " is " + resultFormat);

    }
    
}
