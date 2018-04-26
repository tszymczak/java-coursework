import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/**
 * Lab Assignment 6
 * Given an input in seconds, print out the number of days, hours, minutes, and
 * seconds in that amount of time.
 * @author Thomas Szymczak
 * 10-7-2015
 */
public class LabAssign6 {

    public static void main(String[] args) {
        String repeat;
        
        do {
            calcSeconds();
            // Ask the user if they want to run the program again.
            repeat = JOptionPane.showInputDialog("Enter YeS to repeat program:");
        } while ( repeat.equalsIgnoreCase("yes") );
        
        System.exit(0);
    }
    
    // Break down a number of seconds and print the output.
    public static void calcSeconds() {
            String StrInput, output;
            int input, remainder, seconds, minutes, hours, days;
            // This holds the formatted number of seconds:
            String dfInput;
            final int SEC_MINUTE = 60, SEC_HOUR = 3600, SEC_DAY = 86400;
            
            DecimalFormat df = new DecimalFormat( "#,###" );
            
            // If the input is not positive, repeat the input prompt.
            do {
                StrInput = JOptionPane.showInputDialog("Enter the number of" +
                 " seconds.");
                input = Integer.parseInt(StrInput);
            } while ( input <= 0 );

            // Calculate how many seconds, minutes, hours, and days are in the
            // given number of seconds.
            days = input / SEC_DAY;
            remainder = input % SEC_DAY;
            hours = remainder / SEC_HOUR;
            remainder = remainder % SEC_HOUR;
            minutes = remainder / SEC_MINUTE;
            seconds = remainder % SEC_MINUTE;

            // Format the input. It's not necessary to do this with any of the
            // other units.
            dfInput = df.format(input);

            if ( input < SEC_MINUTE )
            {
                output = "There is less than a minute in " + dfInput +
                 " seconds.";
            }
            else if ( input < SEC_HOUR )
            {
                output = "There are " + minutes + " minutes and " + seconds +
                 " seconds in the input " + dfInput;
            }
            else if ( input < SEC_DAY )
            {
                output = "There are " + hours + " hours, " + minutes +
                 " minutes and " + seconds + " seconds in the input " + dfInput;
            }
            else
            {
                output = "There are " + days + " days, " + hours +
                 " hours, " + minutes + " minutes and " + seconds +
                 " seconds in the input " + dfInput;
            }

            JOptionPane.showMessageDialog(null, output);
    }
    
}