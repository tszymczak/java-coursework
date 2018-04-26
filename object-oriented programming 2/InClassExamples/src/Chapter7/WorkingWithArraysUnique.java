package Chapter7;
import java.util.Arrays;


/**
 * this program loads an arrays with random values and
 * demonstrates the use of the Arrays class.
 * @author Don Smith
 * 1-31-16
 */
public class WorkingWithArraysUnique {
    
    
    public static void main(String[] args) {
        int[] randomNumbers = new int[10];
        
        for (int i = 0; i < randomNumbers.length; ++i) {
            randomNumbers[i] = (int)(Math.random() * 25) + 1;
            for ( int k = 0; k < i; k++ ) {
                if (randomNumbers[i] == randomNumbers[k]) {
                    --i;
                    break;
                }
            }
        }
        

/*        
        int[] rand = new int[10];
        int i = 0;
        boolean duplicate = false;
        while ( i < rand.length ) {
            rand[i] = (int)(Math.random() * 25) + 1;
            for (int j = 0; j < i && duplicate == false; j++) {
                if ( rand[i] == rand[j] )
                    duplicate = true;
            }
            
            if ( !duplicate )
                i++;
        }
*/
        
        System.out.println(Arrays.toString(randomNumbers));
        Arrays.sort(randomNumbers);
        System.out.println(Arrays.toString(randomNumbers));
        if(Arrays.binarySearch(randomNumbers, 17) < 0)
            System.out.println("Value not in array");
        else
            System.out.println("Value found in array");
    }
    
}