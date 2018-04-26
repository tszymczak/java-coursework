package Chapter9;

import javax.swing.JOptionPane;

/**
 * Demonstrates calling static methods of another class
 * @author don smith
 * 2-15-17
 */
public class DigitTestApp {
    public static void main(String[] args) {
        String input;
        long number;
        boolean flag = true;
        
        while (flag)
        {
            input = JOptionPane.showInputDialog(null, "Enter a whole number:",
                    "Digit Validator", JOptionPane.PLAIN_MESSAGE);
            if (DigitValidator.isWholeNumber(input)) {
                number = Long.parseLong(input);
                flag = false;
                JOptionPane.showMessageDialog(null, "The number " + number +
                        " has " + DigitValidator.countDigits(number) +
                        " digits.");
            }
            else
            {
                JOptionPane.showMessageDialog(null,
                        "Invalid data!!\nEnter again", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
                flag = false;
            }
        }
        
        System.exit(0);
    }
}
