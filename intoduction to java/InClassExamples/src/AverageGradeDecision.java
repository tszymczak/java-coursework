import java.util.Scanner;

/**
 * This program prompts the user for 3 test scores, calculates the average
 * and displays the results.
 * @author Thomas Szymczak
 * 09-16-2015
 */
public class AverageGradeDecision {

    public static void main(String[] args) {
        // 3 test scores.
        int score1, score2, score3;

        // Total of the 3 test scores.
        int total;
        
        double avgScore;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the 1st score. --> ");
        score1 = scan.nextInt();
        System.out.print("Enter the 2nd score. --> ");
        score2 = scan.nextInt();
        System.out.print("Enter the 3rd score. --> ");
        score3 = scan.nextInt();
        
        total = score1 + score2 + score3;
        avgScore = (double)total / 3;
        
        System.out.println("The average test score is " + avgScore + ".");
        
        // If the score >= 60, display "you pass". If not, display "you need to
        // retake the course."
        if ( avgScore >= 60 )
        {
            System.out.println("You pass.");
        }
        else
        {
            System.out.println("You need to retake the course.");
        }
    }
    
}