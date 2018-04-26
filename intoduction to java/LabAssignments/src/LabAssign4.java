
import javax.swing.JOptionPane;

/**
 * Ask the user for their user ID and greet them. If the user ID is too long
 * or too short, display an error.
 * @author Thomas Szymczak
 * 09-16-2015
 */
public class LabAssign4 {

    public static void main(String[] args) {
        String id;
        int idLength;
        
        id = JOptionPane.showInputDialog("Please enter your user ID");
        
        idLength = id.length();
        
        // The length of the name must be 6 to 10 characters inclusive.
        if ( idLength <= 10 && idLength >= 6 )
        {
            JOptionPane.showMessageDialog(null, "Welcome, " + id + "\n" +
            "My name is Hal");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Sorry, user ID invalid");
        }
        
        System.exit(0);
    }
    
}