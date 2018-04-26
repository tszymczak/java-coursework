
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 * This program will prompt the user for male and female students and calculate
 * the percentage.
 * <sarcasm type="sjw">This program is not inclusive. It oppresses anyone who
 * isn't gender-binary by assuming that they don't exist.</sarcasm>
 * @author Thomas Szymczak
 * 11-02-2015
 */
public class CalculatePercentLoop2 {    
    // Return the number of male students.
    public static int getMaleCount()
    {
        int male;
        String input;

        input = JOptionPane.showInputDialog( null,
         "Enter the number of male students:" );
        male = Integer.parseInt( input );
        while ( male < 0 )
        {
            JOptionPane.showInputDialog( null,
             "Enter the number of male students:", "ERROR",
             JOptionPane.WARNING_MESSAGE );
            male = Integer.parseInt( input );
        }
        return male;
    }
    
    // Return the number of female students.
    public static int getFemaleCount()
    {
        int female;
        String input;
        
        input = JOptionPane.showInputDialog(null,
         "Enter the number of female students:");
        female = Integer.parseInt( input );
        while ( female < 0 )
        {
            JOptionPane.showInputDialog( null,
             "Enter the number of female students:", "ERROR",
             JOptionPane.WARNING_MESSAGE );
            female = Integer.parseInt( input );
        }
        
        return female;
    }

    // Print the number of male and female students.
    public static void displayResults( int m, int f )
    {
        int total;
        double mPercent, fPercent;
        String output;
        
        DecimalFormat df = new DecimalFormat( "0.0%" );

        total = m + f;
        mPercent = m / (double)total;
        fPercent = f / (double)total;

        output = "The percentage of female students is " +
         df.format( fPercent ) + "\n" +
         "The percentage of male students is " +
         df.format( mPercent );
        JOptionPane.showMessageDialog( null, output );
    }
    
    public static void main(String[] args) {
        int male, female;
        
        female = getFemaleCount();
        male = getMaleCount();
        displayResults( male, female );
        System.exit(0);
    }
    
}
