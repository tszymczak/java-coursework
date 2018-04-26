package Calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * A simple calculator.
 * Uses switch statements.
 * Write comments to explain the lines of code in this program.
 * @author Thomas Szymczak
 */
public class Calculator {
    
    public static void main(String[] args) {
        // Declare two operands.
        double fp1, fp2;
        // Temporary value for the operation.
        String operationS;
        // Holds a character for the operation.
        char operation;
        
        // Use the Scanner class to read input.
        Scanner scan = new Scanner( System.in );
        
        // Used to format output to two decimal points.
        DecimalFormat twoDecimals = new DecimalFormat( "#,###,###.##" );
        
        // Print a welcome message.
        System.out.println( "Welcome to the Calculator" );
        
        // Read the two operands:
        // Prompt for input.
        System.out.print( "Enter the first operand: " );
        // Read input.
        fp1 = scan.nextDouble();
        System.out.print( "Enter the second operand: " );
        fp2 = scan.nextDouble();
        
        // Print a menu, then prompt for the operation.
        System.out.println( "\nOperations are: "
         + "\n\t A for addition"
         + "\n\t S for subtraction"
         + "\n\t M for multiplication"
         + "\n\t D for division" );

        // Prompt for the operation.
        System.out.print( "Enter your selection: ");

        // Get the operation from the user.
        operationS = scan.next();
        operation = operationS.charAt( 0 );
        
        // Do the proper operation based on what the user enters. If they enter
        // something invalid, print an error.
        // "What value does operation hold?"
        switch ( operation )
        {
            // If input is 'a', do this:
            case 'a':
                // Print the formatted sum.
                System.out.println( "The sum is " +
                 twoDecimals.format( fp1 + fp2 ) );
                break;
            // If input is 's', do this:
            case 'S':
            case 's':
                // Print the formatted difference.
                System.out.println( "The difference is " +
                 twoDecimals.format( fp1 - fp2 ) );
                break;
            // If input is 'M' or 'm', do this:
            case 'M':
            case 'm':
                // Print the formatted product.
                System.out.println( "The product is " +
                 twoDecimals.format( fp1 * fp2 ) );
                break;
            // If input is 'D' or 'd ', do this:
            case 'D':
            case 'd':
                // Checks value of second operand.
                if ( fp2 == 0 )
                    System.out.println( "Dividing by 0 is not allowed." );
                else
                // Print the formatted quotient.
                    System.out.println( "The quotient is " +
                     twoDecimals.format( fp1 / fp2 ) );
                break;
            // Else
            default:
                System.out.println( operation + " is not valid." );
        }
    }
    
}
