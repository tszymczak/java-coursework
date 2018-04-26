
import java.util.Scanner;

/**
 * Find all the numbers that are divisible by 5 within a user-defined range.
 * @author Thomas Szymczak
 */
public class FindMultiples {

    public static void main(String[] args) {
        int a, b;
        String input;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter the beginning number --> ");
        a = keyboard.nextInt();
        System.out.print("Enter the ending number --> ");
        b = keyboard.nextInt();
        
        
        for ( int i = a; i <= b; i++ )
        {
            if ( i % 5 == 0 )
            {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nDone");
    }
    
}
