import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 * This program calculates the percentages of male and female.
 * @author Thomas Szymczak
 * 09-14-2015
 */
public class CalculatePercent {

    public static void main(String[] args) {
        int male, female, sum;
        double mPercent, fPercent;
        DecimalFormat df = new DecimalFormat("0.0%");
        String inData, output;
        
        inData = JOptionPane.showInputDialog(null, "Enter the number of " +
         "females.");
        female = Integer.parseInt(inData);

        inData = JOptionPane.showInputDialog(null, "Enter the number of " +
         "males.");
        male = Integer.parseInt(inData);
        
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
