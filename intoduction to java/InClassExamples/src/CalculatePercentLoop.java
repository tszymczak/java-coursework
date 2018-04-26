import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 * This program calculates the percentages of male and female.
 * @author Thomas Szymczak
 * 10-5-2015
 */
public class CalculatePercentLoop {

    public static void main(String[] args) {
        int male, female, sum;
        double mPercent, fPercent;
        DecimalFormat df = new DecimalFormat("0.0%");
        String inData, output;
        
        do
        {
        inData = JOptionPane.showInputDialog(null, "Enter the number of " +
         "females.");
        female = Integer.parseInt(inData);
        } while ( female <= 0 );

        do
        {
        inData = JOptionPane.showInputDialog(null, "Enter the number of " +
         "males.");
        male = Integer.parseInt(inData);
        } while ( male <= 0 );
        
        sum = male + female;
        
        fPercent = (double)female / sum;
        mPercent = (double)male / sum;
        
        // Display the more common sex first.
        // If they're the same, display "The percentage of male/female is equal."
        output = "The percentage of females is " + df.format(fPercent) + "\n" +
         "The percentage of males is " + df.format(mPercent);

        JOptionPane.showMessageDialog(null, output);
        System.exit(0);
    }
    
}
