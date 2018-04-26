import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Lab Assignment 7
 * A simple coin-tossing game.
 * @author Thomas Szymczak
 * 10-23-2015
 */
public class LabAssign7 {

    public static void main(String[] args) {
        Random rGen = new Random();
        
        String input, repeat;
        char chrInput, chrRepeat;
        int guess, coin, wins = 0, losses = 0;
        
        do {
            do {
                input = JOptionPane.showInputDialog("Enter 'H' for heads,\nEnter 'T' for tails");
                chrInput = Character.toLowerCase(input.charAt(0));
            } while ( !( chrInput == 'h' || chrInput == 't' ) );

            if ( chrInput == 'h' )
            {
                guess = 1;
            }
            else
            {
                guess = 0;
            }

            // Flip the coin. Heads is 1, tails is 0.
            coin = rGen.nextInt(2);

            if ( coin == guess )
            {
                JOptionPane.showMessageDialog(null, "You Win!");
                wins++;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Computer wins");
                losses++;
            }
            
            repeat = JOptionPane.showInputDialog( "Enter 'Y' to play again, 'N' to quit" );
            chrRepeat = Character.toLowerCase( repeat.charAt( 0 ));
        } while ( chrRepeat == 'y' );
        
        JOptionPane.showMessageDialog(null, " Your score is " + wins + " wins and " + losses + " losses.");
        
        System.exit(0);
        
    }
}