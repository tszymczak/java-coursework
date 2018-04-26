import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Lab Assignment 7
 * A simple coin-tossing game. Lab 7, re-implemented with multiple methods
 * @author Thomas Szymczak
 * 11-4-2015
 */
public class LabAssign8 {

    // Get the user's guess and return it as a char.
    public static char getUsersGuess()
    {
        String input;
        char guess;

            do {
                input = JOptionPane.showInputDialog("Enter 'H' for heads,\nEnter 'T' for tails");
                guess = Character.toUpperCase(input.charAt(0));
            } while ( !( guess == 'H' || guess == 'T' ) );
        return guess;
    }

    // Flip the simulated coin and return the result.
    public static char tossCoin()
    {
        Random rGen = new Random();

        int coinNum;
        char cToss;

        // Flip the coin. Heads is 1, tails is 0.
        coinNum = rGen.nextInt(2);
        if ( coinNum == 0 ) {
            cToss = 'H';
        }
        else
        {
            cToss = 'T';
        }
        return cToss;
    }
    
    public static boolean determineTheWinner(char uGuess, char cToss)
    {
        boolean userIsCorrect;

        if ( cToss == uGuess )
        {
            JOptionPane.showMessageDialog(null, "You Win!");
            userIsCorrect = true;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Computer wins");
            userIsCorrect = false;
        }
        
        return userIsCorrect;
    }

    // Asks the user if they want to repeat. If so, return true.
    public static boolean doContinue()
    {
        String repeat;
        char chrRepeat;

        repeat = JOptionPane.showInputDialog( "Enter 'Y' to play again, 'N' to quit" );
        chrRepeat = Character.toLowerCase( repeat.charAt( 0 ));

        return chrRepeat == 'y';
    }
    
    public static void main(String[] args) {
        char cToss, uGuess;
        int wins = 0, losses = 0;
        boolean userIsCorrect, repeat;
        
        do {
            uGuess = getUsersGuess();

            cToss = tossCoin();
            
            userIsCorrect = determineTheWinner( cToss, uGuess );
            if ( userIsCorrect )
                wins++;
            else
                losses++;
            
            repeat = doContinue();
                        
        } while ( repeat );
        
        JOptionPane.showMessageDialog(null, " Your score is " + wins +
         " wins and " + losses + " losses.");
        
        System.exit(0);
    }
}