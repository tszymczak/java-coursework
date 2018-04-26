package Die;

import java.util.Scanner;

/**
 * This application uses the services of the Die class.
 * @author Thomas Szymczak
 * 12-2-2015
 */
public class DiceGame {

    public static void main(String[] args) {
        int rolls;
        int count = 0;

        Scanner scan = new Scanner(System.in);
        Die d1 = new Die();
        Die d2 = new Die();

        System.out.println("The initial value of the dice is:");
        System.out.println( d1.getValue() + "  " + d2.getValue() );
        System.out.print("How many times to roll the dice? -->");
        rolls = scan.nextInt();

        for ( int i = 0; i < rolls; i++ )
        {
            d1.roll();
            d2.roll();
            System.out.println( d1.getValue() + "  " + d2.getValue() );
            if ( d1.getValue() + d2.getValue() == 7 )
            {
                count++;
            }
        }
        
        System.out.println("The number of 7's rolled is: " + count);
                
    }
    
}
