
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This program prompts for two numbers and displays the product.
 * @author Thomas Szymczak
 * 09-14-2015
 */
public class FindProduct {

    public static void main(String[] args) {
        double num1, num2, result;
        Scanner scan = new Scanner(System.in);
        DecimalFormat form = new DecimalFormat("#,##0.00");

        System.out.print("Enter the 1st number --> ");
        num1 = scan.nextDouble();
        
        System.out.print("Enter the 2nd number --> ");
        num2 = scan.nextDouble();
        
        result = num1 * num2;
        
        System.out.println("\nThe product of " + num1 + " and " + num2 +
         " is " + form.format(result) );
    }
    
}
