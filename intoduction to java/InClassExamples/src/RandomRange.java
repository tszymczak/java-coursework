
import java.util.Random;

/**
 * Demonstrates creating a random number in any range.
 * @author Thomas Szymczak
 * 10-12-2015
 */
public class RandomRange {

    public static void main(String[] args) {
        int rNum;
        
        Random rGen = new Random();
        rNum = rGen.nextInt(11) + 10;
        
        for ( int i = 1; i < 25; i++ )
        {
            rNum = rGen.nextInt(11) + 10;
            System.out.print(rNum + " ");
        }
        System.out.println();
    }
    
}
