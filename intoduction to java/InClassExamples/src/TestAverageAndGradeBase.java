import java.util.Scanner;

/**
 * Test Average and Grade programming challenge.
 * @author Thomas Szymczak (Copied from a handout)
 * 11-9-2015
 */
public class TestAverageAndGradeBase {

    public static void main(String[] args) {
        double score1;      // The 1st test score
        double score2;      // The 2nd test score
        double score3;      // The 3rd test score
        double score4;      // The 4th test score
        double score5;      // The 5th test score
        double average;     // The average test score
        
        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);
        
        // Get the first test score.
        System.out.print("Enter the first test score: --> ");
        score1 = keyboard.nextDouble();
        
        // Get the second test score.
        System.out.print("Enter the second test score: --> ");
        score2 = keyboard.nextDouble();
        
        // Get the third test score.
        System.out.print("Enter the third test score: --> ");
        score3 = keyboard.nextDouble();
        
        // Get the fourth test score.
        System.out.print("Enter the fourth test score: --> ");
        score4 = keyboard.nextDouble();
        
        // Get the fifth test score.
        System.out.print("Enter the fifth test score: --> ");
        score5 = keyboard.nextDouble();
    }
}
