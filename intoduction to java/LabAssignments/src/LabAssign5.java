import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/**
 * Lab Assignment 5
 * Given an input in seconds, print out the number of days, hours, minutes, and
 * seconds in that amount of time.
 * @author Thomas Szymczak
 * 09-29-2015
 */
public class LabAssign5 {

    public static void main(String[] args) {
        String StrInput, output;
        int input, remainder, seconds, minutes, hours, days;
        // These hold the formatted numbers of hours, minutes, etc:
        String dfInput, dfSeconds, dfMinutes, dfHours, dfDays;
        final int SEC_MINUTE = 60, SEC_HOUR = 3600, SEC_DAY = 86400;
        
        DecimalFormat df = new DecimalFormat( "#,###,###" );
        
        StrInput = JOptionPane.showInputDialog("Enter the number of seconds.");
        input = Integer.parseInt(StrInput);
        
        // Calculate how many seconds, minutes, hours, and days are in the
        // given number of seconds.
        days = input / SEC_DAY;
        remainder = input % SEC_DAY;
        hours = remainder / SEC_HOUR;
        remainder = remainder % SEC_HOUR;
        minutes = remainder / SEC_MINUTE;
        seconds = remainder % SEC_MINUTE;
        
        // Format the units of time. We only need to do this on days and the
        // input because no other unit can exceed 1000.
        dfInput = df.format(input);
        dfDays = df.format(days);
        
        
        
        if ( input < SEC_MINUTE )
        {
            output = "There is less than a minute in " + dfInput + " seconds.";
        }
        else if ( input < SEC_HOUR )
        {
            output = "There are " + minutes + " minutes and " + minutes +
             " seconds in the input " + dfInput;
        }
        else if ( input < SEC_DAY )
        {
            output = "There are " + hours + " hours, " + minutes +
             " minutes and " + seconds + " seconds in the input " + dfInput;
        }
        else
        {
            output = "There are " + dfDays + " days, " + hours + " hours, " +
             minutes + " minutes and " + seconds + " seconds in the input " +
             dfInput;
        }
        
        JOptionPane.showMessageDialog(null, output);
        
        System.exit(0);
    }
    
}