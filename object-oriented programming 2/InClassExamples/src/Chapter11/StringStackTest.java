package Chapter11;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Don Smith
 * 3-06-17
 * Driver class which uses the services of MyStringStack class
 */
public class StringStackTest {
    
    public static void main(String[] args) {
        String[] months = {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November",
            "December"};
        MyStringStack mss = new MyStringStack();
        // load the stack with array values
        for (int i = 0; i < months.length; i++) {
            mss.push(months[i]);
        }
        System.out.println("The stack holds these values:\n" + mss.toString());
        Collections.sort(mss);
        System.out.println("\nThe stack sorted:");
        for (String s: mss) {
            System.out.println(s);
        }
        Collections.shuffle(mss);
        System.out.println("\nThe stack shuffled:");
        for (String s: mss) {
            System.out.println(s);
        }
        if (mss.contains("May"))
        {
            System.out.println("May is listed in position " + (mss.indexOf("May") + 1));
        }
       
    }
}
