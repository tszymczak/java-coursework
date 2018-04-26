
import java.util.Scanner;

/**
 * Find all the numbers that are divisible by a number within a user-defined
 * range.
 * @author Thomas Szymczak
 * 11-16-2015
 */
public class FindAnyMultiples {

    public static void main(String[] args) {
        // n is the number of numbers in the current line of output.
        int a, b, base, n = 0;
        String input, output = "";
        
        Scanner keyboard = new Scanner(System.in);
        
        // Validate that the beginning number is less than the ending number.
        do
        {
            System.out.print("Enter the beginning number --> ");
            a = keyboard.nextInt();
            System.out.print("Enter the ending number --> ");
            b = keyboard.nextInt();
        } while ( a > b );
        
        
        // Validate that the base is at least 2.
        do   
        {
            System.out.print("Enter the multiple base --> ");
            base = keyboard.nextInt();
        } while ( base < 2 );
        
        for ( int i = a; i <= b; i++ )
        {
            if ( i % base == 0 )
            {
                System.out.print( i + " ");
                n++;
                
                if ( n >= 10 )
                {
                    System.out.print("\n");
                    n = 0;
                }
            }
        }
        System.out.println("\nDone");
    }
}
