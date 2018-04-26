
import javax.swing.JOptionPane;

/**
 * This program demonstrates the use of methods.
 * @author Thomas Szymczak
 * 10-28-2015
 */
public class PassValues {

    // Calculates our function.
    public static int calculate(int x, int y)
    {
        return x*x - 2*y + 7;
    }
    
    public static void main(String[] args) {
        int x, y, result;
        String temp, out;
        
        temp = JOptionPane.showInputDialog("Enter a value for x:");
        x = Integer.parseInt( temp );
        temp = JOptionPane.showInputDialog("Enter a value for x:");
        y = Integer.parseInt( temp );
        
        result = calculate( x, y );
        
        out = "The answer is " + result;
        JOptionPane.showMessageDialog(null, out );
        
        System.exit(0);
        
    }
    
}
