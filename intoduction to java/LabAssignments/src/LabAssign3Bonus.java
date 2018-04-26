import java.util.*;
import javax.swing.JOptionPane;
/**
 * Lab Assignment 3 (Bonus Assignment)
 * Calculate miles per gallon based on the user's input, which is gathered via
 * JOptionPane.
 * @author Thomas Szymczak
 * 09-02-2015
 */
public class LabAssign3Bonus {

    public static void main(String[] args) {
        double gallons, mpg;
        int miles;
        String inputString;

        inputString = JOptionPane.showInputDialog("Enter the miles driven.");
        miles = Integer.parseInt(inputString);
        
        inputString = JOptionPane.showInputDialog("Enter the gallons of fuel used.");
        gallons = Double.parseDouble(inputString);
        
        mpg = miles / gallons;

        System.out.print("\n");
        JOptionPane.showMessageDialog(null, "The miles-per-gallon based on " +
         "the data entered is " + mpg);

		System.exit(0);
    }
    
}
