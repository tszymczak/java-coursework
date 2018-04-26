package Exam2Prep;

import java.util.Random;

/**
 * Print "I like loops" a random number of times.
 * @author Thomas Szycmzak
 * 10-19-2015
 */
public class ShowLargestLoop {

    public static void main(String[] args) {
        int a, b, c;
        
        Random rGen = new Random();
        
        a = rGen.nextInt(50) + 1;
        b = rGen.nextInt(50) + 1;
        c = Math.max( a, b ) / 4;
        
        for ( int i = 0; i < c; i++ )
        {
            System.out.println("I like loops");
        }
    }
    
}
