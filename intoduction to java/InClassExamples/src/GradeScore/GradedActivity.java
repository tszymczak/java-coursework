package GradeScore;

import javax.swing.JOptionPane;

/**
 * This class represents a graded assignment. Demonstrates OO programming.
 * @author Thomas Szymczak
 * 11-30-2015
 */
public class GradedActivity {
    private double score;
    
    // Default constructor.
    public GradedActivity()
    {
        score = 0.0;
    }
    
    // Overloaded constructor.
    public GradedActivity( double ts )
    {
        setScore(ts);
    }
    
    // This method validates the value of score.
    public void setScore( double s )
    {
        if ( s >= 0 && s <= 100 )
        {
            score = s;            
        }
        else
        {
            score = 0;
            JOptionPane.showMessageDialog( null, "Invalid score\nscore set to 0");
        }

    }
    
    public double getScore()
    {
        return score;
    }
    
    // This method determines the letter grade for the object.
    public char getGrade()
    {
        char letter = ' ';
        if ( score >= 90 )
        {
            letter = 'A';
        }
        else if ( score >= 80 )
        {
            letter = 'B';
        }
        else if ( score >= 70 )
        {
            letter = 'C';
        }
        else if ( score >= 60 )
        {
            letter = 'D';
        }
        else
        {
            letter = 'F';
        }
        return letter;
    }
    
}
