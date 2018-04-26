import java.util.Random;
import javax.swing.JOptionPane;

/**
 * This program generates a number of random numbers and displays the larger
 * value.
 * @author Thomas Szymczak
 * 09-09-2015
 */
public class HigherRandom {

    public static void main(String[] args) {
        final int MAX_N = 100;
        int num1, num2;
        int largest;
        Random rGen = new Random();
        num1 = rGen.nextInt(MAX_N);
        num2 = rGen.nextInt(MAX_N);
        largest = Math.max(num1, num2);
        JOptionPane.showMessageDialog( null, "The largest value of " + num1 +
         " and " + num2 + " is " + largest);
        System.exit(0);
    }

}
