package Exam1Prep;
import java.util.Scanner;

/**
 * Question 3: FindSqrt.java
 * @author Thomas Szymczak
 * 09-21-2015
 */
public class FindSqrt {

    public static void main(String[] args) {
        double num1, num2, higher;
        double result;
        
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the 1st number --> ");
        num1 = keyboard.nextDouble();
        
        System.out.print("Enter the 1st number --> ");
        num2 = keyboard.nextDouble();
        
        // Find the higher number.
        higher = max( num1, num2 );
        
        result = Math.sqrt(higher);
        
        System.out.println("The square root of " + higher + " is " + result);
}
    
    // A quick-and-dirty hack to determine which of two numbers is larger.
    // Takes two doubles as arguments, and returns the larger one.
    public static double max( double a, double b) {
        if ( a > b )
        {
            return a;
        }
        else
        {
            return b;
        }
    }
}