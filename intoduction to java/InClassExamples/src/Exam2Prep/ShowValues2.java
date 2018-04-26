package Exam2Prep;

import java.util.Scanner;

/**
 * Show a range of numbers in descending order, while validating input.
 * @author Thomas Szymczak
 * 10-19-2015
 */
public class ShowValues2 {

    public static void main(String[] args) {
        int a;
        
        Scanner scan = new Scanner( System.in );
        
        do {
            System.out.print("Enter a number between 20 and 30 --> ");
            a = scan.nextInt();
        } while ( a < 20 || a > 30 );
        
        for ( int i = a; i >= 20; i-- )
        {
            System.out.print( i + " " );
        }
        System.out.print("\n");
        
    }
    
}
