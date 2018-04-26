package GradeScore;

import javax.swing.JOptionPane;

/**
 * This class uses the services of the GradedActivity class.
 * @author Thomas Szymczak
 * 11-30-2015
 */
public class GradeApplication {

    public static double getValidScore( GradedActivity g )
    {
        double s;
        do {
            s = Double.parseDouble(JOptionPane.showInputDialog(null,
             "Enter a test score."));
            g = new GradedActivity(s);
        } while ( s < 0 || s > 100 );
        return s;
    }
    public static void main(String[] args) {
        double testScore;
        GradedActivity anyScore = new GradedActivity();
        
        testScore = getValidScore( anyScore );
        JOptionPane.showMessageDialog(null, "The test score of " + testScore +
         " earns a grade of " + anyScore.getGrade() );
        System.exit(0);
    }
    
}
