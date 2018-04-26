
import java.util.Scanner;

/**
 * Find all the numbers that are divisible by a number within a user-defined
 * range.
 * @author Thomas Szymczak
 * 11-16-2015
 */
public class FindAnyMultiplesMethods {

    // Find all the numbers divisible by a certain number.
    public static void findAndDisplay( int begin, int end, int multiple )
    {
        int n = 0;
        for ( int i = begin; i <= end; i++ )
        {
            if ( i % multiple == 0 )
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

        // Make sure there's a newline at the end of the loop's output.
        if ( n != 0 )
        {
            System.out.print("\n");
        }
    }
    
    // Ask the user if they want to repeat the program, and return the
    // response.
    public static boolean repeat()
    {
        String repeat;
        
        Scanner scan = new Scanner( System.in );
        System.out.print("Do you want to repeat? ");
        repeat = scan.next();        
        return repeat.charAt( 0 ) == 'y' || repeat.charAt( 0 ) == 'Y';
    }

    public static void main(String[] args)
    {
        // n is the number of numbers in the current line of output.
        int a, b, base;
        
        Scanner keyboard = new Scanner(System.in);
        
        do {
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
            
            findAndDisplay( a, b, base );
            
        } while ( repeat() );
        
        System.out.println("\nDone");
    }
}
