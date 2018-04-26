import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Test Average and Grade programming challenge.
 * @author Thomas Szymczak
 * 11-9-2015
 */
public class TestAverageAndGrade {

    /*
     * Prompt the user for a test score and return it.
     */
    public static double getScore( int n )
    {
        double score;
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter test score " + n + ": --> ");
        score = keyboard.nextDouble();
        
        while ( score > 100 || score < 0 )
        {
            System.out.println("Please enter a score between 0 and 100.");
            System.out.print("Enter test score " + n + ": --> ");
            score = keyboard.nextDouble();
        }
        return score;
    }
    /*
     * Convert a numeric score to a letter grade.
     * Readily accepts grades less than 0 or greater than 100. Not sure if
     * that's a bug or a feature.
     */
    public static char scoreToLetterGrade( double score )
    {
        if ( score < 60 )
            return 'F';
        else if ( score < 70 )
            return 'D';
        else if ( score < 80 )
            return 'C';
        else if ( score < 90 )
            return 'B';
        else
            return 'A';
    }
    
    /**
     * Print out a letter grade.
     */
    public static void printGrade( int n, char LetterGrade )
    {
        System.out.println( "Test " + n + ": " + LetterGrade );
    }
    
    public static void main(String[] args) {
        // The number of tests.
        final int N_TESTS = 5;
        // Array holding numeric test scores:
        double[] scores = new double[N_TESTS];
        // Array houlding letter grades:
        char[] letterGrades = new char[N_TESTS];
        // Used to calculate the average grade.
        double sum = 0;
        // The average test score
        double average;
        // The average test score, formatted.
        String formAverage;
        
        // Create a DecimalFormat object to format our average score.
        DecimalFormat df = new DecimalFormat("#.00");
        
        // Get the test scores.
        for ( int i = 0; i < scores.length ; i++ )
        {
            scores[i] = getScore(i + 1);
        }
        
        // Convert the scores to letter grades.
        for ( int i = 0; i < scores.length ; i++ )
        {
            letterGrades[i] = scoreToLetterGrade( scores[i] );
        }
        
        // Calculate the average grade.
        for ( int i = 0; i < scores.length ; i++ )
        {
            sum += scores[i];
        }
        average = sum / scores.length;
        
        // Print out the grades.
        formAverage = df.format( average );
        System.out.println("Here are the grades and the average:");
        for ( int i = 0; i < scores.length ; i++ )
        {
            printGrade( i+1, letterGrades[i] );
        }
        System.out.println( "Average score: " + formAverage );
        System.out.println( "Average Letter Grade: " + scoreToLetterGrade( average ) );
        
        
    }
}
