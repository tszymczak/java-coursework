import java.util.Scanner;

/**
 * This program prompts the user for 3 test scores and calculates the average
 * and displays the results.
 * @author Thomas Szymczak
 * 09-02-2015
 */
public class AverageGrade {

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
    }
    
}