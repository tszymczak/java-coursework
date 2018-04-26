
import java.util.Scanner;

/**
 * Calculate the number of gross and dozens of eggs.
 * @author Thomas Szymczak
 * 9-28-2015
 */
public class EggRemainder {

    public static void main(String[] args) {
        int eggs, remainder, dozen, gross;
        String output;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the number of eggs --> ");
        eggs = scan.nextInt();

        // Who the hell uses the gross in the 21st century?
        gross = eggs / 144;
        remainder = eggs % 144;
        dozen = remainder / 12;
        remainder %= 12;
        
        output = eggs + " eggs has:\n" + "gross:  " + gross + "\ndozen:  " +
         dozen + "\nleft over:  " + remainder;
        System.out.println(output);
        
    }
    
}
