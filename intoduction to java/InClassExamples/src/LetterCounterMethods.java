import javax.swing.JOptionPane;

/**
 *
 * @author Nick Carlson, Thomas Szycmzak
 * Hmm, multiple authors. Time for git yet?
 */
public class LetterCounterMethods {

    // Prompt the user for a text and return it.
    public static String getText()
    {
        return JOptionPane.showInputDialog("Enter a string.");
    }
    
    public static int countOccurrences( String searchString, char myChar )
    {
        int count = 0;
        
        for (int i = 0; i < searchString.length(); i++) {
            // Convert the characters we're comparing  to lowercase, so we
            // don't have to fiddle with temporary variables.
            if (Character.toLowerCase(searchString.charAt(i)) == Character.toLowerCase(myChar)) {
                count++;
            }
        }
        return count;

    }

    
public static void main(String[] args) {
        
        String inputString, inputLetter, repeat;
        char letter;
        
        do {
            int count;
            
            inputString = getText();
            
            inputLetter = JOptionPane.showInputDialog("Enter a letter contained in the string.");
            letter = inputLetter.charAt(0);
            
            count = countOccurrences( inputString, letter );
            
            JOptionPane.showMessageDialog(null, "The letter " + letter + " appears " + count +
             " times in the string: " + inputString);
            
            repeat = JOptionPane.showInputDialog("Enter YES to continue.");
           
        } while (repeat.equalsIgnoreCase("yes"));
    }
}
