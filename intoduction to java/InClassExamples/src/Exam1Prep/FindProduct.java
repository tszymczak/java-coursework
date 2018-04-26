package Exam1Prep;
import java.util.*;
import java.text.DecimalFormat;

/**
 * Question 1: FindProduct.java
 * Calculate the product of two numbers.
 * @author Thomas Szymczak
 * 09-21-2015
 */
public class FindProduct {

    public static void main(String[] args) {
        double num1, num2, product;
        String productFormat;
        
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.000");
        
        System.out.print("Enter the 1st number --> ");
        num1 = scan.nextDouble();
        
        System.out.print("Enter the 2nd number --> ");
        num2 = scan.nextDouble();
        
        product = num1 * num2;
        
        productFormat = df.format( product );
        
        System.out.println("The product of " + num1 + " times " + num2 +
         " is " + productFormat);
    }
    
}
