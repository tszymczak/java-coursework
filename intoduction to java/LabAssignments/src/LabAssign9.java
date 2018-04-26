
import java.util.Scanner;

/**
 * Lab Assignment 9
 * Use methods to print formatted output.
 * @author Thomas Szymczak
 * 11-10-2015
 */
public class LabAssign9 {

    public static int getValidValue()
    {
        int a;
        
        Scanner scan = new Scanner(System.in);
        
        do
        {
            System.out.print("Enter an integer greater than zero -> ");
            a = scan.nextInt();
        } while ( a <= 0 );
        
        return a;
    }
    
    public static void displayOutput( int loopCount )
    {
        String message = "The semester is ending soon.";
        String stars = " ***";
        
        for ( int i = 0; i < loopCount; i++ )
        {
            if ( i % 3 == 2 ) 
            {
                System.out.println( message + stars );
            }
            else
            {
                System.out.println( message );
            }
        }
    }
    public static void main(String[] args) {
        int num;
        
        num = getValidValue();
        
        System.out.print("\n");
        
        displayOutput( num );
        
        System.out.println("\nThe program has ended.");
    }
    
}
