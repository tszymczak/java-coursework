
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This program prompts for two numbers and displays the product.
 * @author Thomas Szymczak
 * 09-14-2015
 */
public class FindProductLoop {

    public static void main(String[] args) {
        // Add a loop that the user cannot enter a negative value. Otherwise,
        // re-prompt.
        double num1 = -1, num2 = -1, result;
        Scanner scan = new Scanner(System.in);
        DecimalFormat form = new DecimalFormat("#,##0.00");

        while ( num1 < 0 || num2 < 0)
        {
            System.out.print("Enter the 1st number --> ");
            num1 = scan.nextDouble();

            System.out.print("Enter the 2nd number --> ");
            num2 = scan.nextDouble();

            if ( num1 < 0 || num2 < 0)
            {
                System.out.println( "Input error." );
                System.out.println( "Please re-enter\n" );
            }
        }
        
        
        result = num1 * num2;
        
        System.out.println("\nThe product of " + num1 + " and " + num2 +
         " is " + form.format(result) );
    }
    
}
