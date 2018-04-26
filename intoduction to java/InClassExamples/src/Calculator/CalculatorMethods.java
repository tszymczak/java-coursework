package Calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * A simple calculator that's been reimplemented using methods.
 * @author Thomas Szymczak
 * 11-11-2015
 */
public class CalculatorMethods {

    public static String getOperation( Scanner readIn )
    {
        String operation;
        
        // Explain how to use the operations.
        System.out.println( "\nOperations are: "
         + "\n\t A for addition"
         + "\n\t S for subtraction"
         + "\n\t M for multiplication"
         + "\n\t D for division" );

        // Prompt for an operation.
        System.out.print( "Enter your selection: ");
        
        // Get the operation from the user.
        operation = readIn.next();
        
        return operation;
    }

    // Do the proper operation based on what the user enters. If they enter
    // something invalid, print an error.
    // "What value does operation hold?"
    public static void displayResults( String s, double d1, double d2 )
    {
        char operation;

        // Used to format output to two decimal points.
        DecimalFormat twoDecimals = new DecimalFormat( "#,###,###.##" );

        operation = s.charAt( 0 );
        operation = Character.toLowerCase( operation );

        switch ( operation )
        {
            // If input is 'a', do this:
            case 'a':
                // Print the formatted sum.
                System.out.println( "The sum is " +
                 twoDecimals.format( d1 + d2 ) );
                break;
            // If input is 's', do this:
            case 's':
                // Print the formatted difference.
                System.out.println( "The difference is " +
                 twoDecimals.format( d1 - d2 ) );
                break;
            // If input is 'm', do this:
            case 'm':
                // Print the formatted product.
                System.out.println( "The product is " +
                 twoDecimals.format( d1 * d2 ) );
                break;
            // If input is 'd', do this:
            case 'd':
                // Checks value of second operand.
                if ( d2 == 0 )
                    System.out.println( "Dividing by 0 is not allowed." );
                else
                // Print the formatted quotient.
                    System.out.println( "The quotient is " +
                     twoDecimals.format( d1 / d2 ) );
                break;
            // Else
            default:
                System.out.println( operation + " is not valid." );
        }

    }
    
    public static boolean repeat()
    {
        String repeat;
        
        Scanner scan = new Scanner( System.in );
        System.out.print("Do you want to repeat? ");
        repeat = scan.next();        
        return repeat.charAt( 0 ) == 'y' || repeat.charAt( 0 ) == 'Y';
    }
    
    public static void main(String[] args) {
        // Declare two operands.
        double fp1, fp2;
        // Holds the operation.
        String operationS;
        
        // Use the Scanner class to read input.
        Scanner scan = new Scanner( System.in );
                
        // Print a welcome message.
        System.out.println( "Welcome to the Calculator" );
        
        do {
            // Prompt for input.
            System.out.print( "Enter the first operand: " );
            // Read input.
            fp1 = scan.nextDouble();
            System.out.print( "Enter the second operand: " );
            fp2 = scan.nextDouble();

            operationS = getOperation( scan );

            displayResults( operationS, fp1, fp2);
        } while ( repeat() );
    }
    
}
