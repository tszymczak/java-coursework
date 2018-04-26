
import java.util.Scanner;

/**
 * Average a user-defined number of test scores.
 * @author Thomas Szymczak
 * 10-7-2015
 */
public class LoopScore2 {

    public static void main(String[] args) {
        // n is the number of tests.
        int n, sum = 0;
        double avg;
        Scanner keyboard = new Scanner(System.in);
        
        do
        {
            System.out.print("Enter the number of test scores: ");
            n = keyboard.nextInt();
            if ( n <= 1 )
            {
                System.out.println("The number of test scores must be at " +
                 "least 2.");
            }
        } while ( n <= 1 );
        
        for ( int i = 1; i <= n; i++ )
        {
            System.out.print("Enter test score number " + i + ": ");
            sum += keyboard.nextInt();
        }
        
        avg = (double)sum / n;
        
        System.out.print("The average score is " + avg);
        
    }
}
