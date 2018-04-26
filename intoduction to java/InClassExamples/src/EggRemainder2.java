
import java.util.Scanner;

/**
 * Calculate the number of gross and dozens of eggs.
 * @author Thomas Szymczak
 * 9-28-2015
 */
public class EggRemainder2 {

    // Ask the user for a number greater than zero.
    public static int getValidEggs( Scanner s )
    {
        int eggs;
        
        System.out.print("Enter the number of eggs --> ");
        eggs = s.nextInt();
        
        while ( eggs <= 0 )
        {
            System.out.println("The number of eggs must be greater than"
             + "zero.");
        }
        
        return eggs;
   
    }
    
    public static void calculateAndDisplay( int eggs )
    {
        int gross, dozen, remainder;
        String output;
        
        // Who the hell uses the gross in the 21st century?
        gross = eggs / 144;
        remainder = eggs % 144;
        dozen = remainder / 12;
        remainder %= 12;

        if ( eggs >= 144 )
        {
            output = "There are at least " + gross + " gross of eggs.";
        }
        else
        {
            output = eggs + " eggs has:\n" + "gross:  " + gross + "\ndozen:  " +
             dozen + "\nleft over:  " + remainder;            
        }
        System.out.println(output);
    }
    
    // Ask the user if they want to repeat the program, and return the
    // response.
    public static boolean repeat( Scanner scan )
    {
        String repeat;
        System.out.print("Do you want to repeat? ");
        repeat = scan.next();        
        return repeat.charAt( 0 ) == 'y' || repeat.charAt( 0 ) == 'Y';
    }

    public static void main(String[] args) {
        int eggs, remainder, dozen, gross;
        String output;
        
        Scanner scan = new Scanner(System.in);

        do {
            eggs = getValidEggs( scan );
            
            calculateAndDisplay( eggs );

        } while ( repeat( scan ) );
        
    }
    
}
