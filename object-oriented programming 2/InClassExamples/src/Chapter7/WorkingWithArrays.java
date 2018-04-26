package Chapter7;
import java.util.Arrays;


/**
 * this program loads an arrays with random values and
 * demonstrates the use of the Arrays class.
 * @author Don Smith
 * 1-31-16
 */
public class WorkingWithArrays {
    
    
    public static void main(String[] args) {
        int[] randomNumbers = new int[10];
        for (int i = 0; i < randomNumbers.length; ++i)
        {
            randomNumbers[i] = (int)(Math.random() * 25) + 1;
        }
        System.out.println(Arrays.toString(randomNumbers));
        Arrays.sort(randomNumbers);
        System.out.println(Arrays.toString(randomNumbers));
        if(Arrays.binarySearch(randomNumbers, 17) < 0)
            System.out.println("Value not in array");
        else
            System.out.println("Value found in array");
    }
    
}