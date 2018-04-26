package GradeScore;

import javax.swing.JOptionPane;

/**
 * This class uses the services of the GradedActivity class.
 * @author Thomas Szymczak
 * 11-30-2015
 */
public class GradeApplication2 {

    public static void main(String[] args) {
        double testScore;
        GradedActivity anyScore;
        
        do {
            testScore = Double.parseDouble(JOptionPane.showInputDialog(null,
             "Enter a test score."));
            anyScore = new GradedActivity(testScore);
        } while ( testScore < 0 || testScore > 100 );
 
        JOptionPane.showMessageDialog(null, "The test score of " + testScore +
         " earns a grade of " + anyScore.getGrade() );
        System.exit(0);
    }
    
}
