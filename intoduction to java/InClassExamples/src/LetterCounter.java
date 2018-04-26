import javax.swing.JOptionPane;

/**
 *
 * @author Nick Carlson
 */
public class LetterCounter {

    public static void main(String[] args) {
        
        String inputString, inputLetter, repeat = "yes";
        char letter;
        
        do {
            int count = 0;
            inputString = JOptionPane.showInputDialog("Enter a string.");
            
            inputLetter = JOptionPane.showInputDialog("Enter a letter contained in the string.");
            letter = inputLetter.charAt(0);
            
            for (int i = 0; i < inputString.length(); i++) {
                // Convert the characters we're comparing  to lowercase, so we
                // don't have to fiddle with temporary variables.
                if (Character.toLowerCase(inputString.charAt(i)) == Character.toLowerCase(letter)) {
                    count++;
                }
            }
            JOptionPane.showMessageDialog(null, "The letter " + letter + " appears " + count +
             " times in the string: " + inputString);
            
            repeat = JOptionPane.showInputDialog("Enter YES to continue.");
           
        } while (repeat.equalsIgnoreCase("yes"));
    }
}
