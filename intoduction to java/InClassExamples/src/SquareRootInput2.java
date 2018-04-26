import javax.swing.JOptionPane;

/**
 * Calculate square roots, using JOptionPane to take input.
 * @author Thomas Szymczak
 * 09-09-2015
 */
public class SquareRootInput2 {

    public static void main(String[] args) {
        double input, result;
        String inputString;
        
        // Ask the user to enter the number.
        inputString = JOptionPane.showInputDialog("Enter the number to find " +
                "the square root.");
        
        // Parse the string to a double.
        input = Double.parseDouble(inputString);
        
        result = Math.sqrt(input);
        JOptionPane.showMessageDialog(null, "The square root of " + input + " is " + result +
            ".");
    }
    
}
