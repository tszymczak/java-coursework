package Chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * This program demonstrates ArrayLists and arrays.
 * @author Don Smith
 * 3-8-2016
 */
public class WorkingWithLists {
    public static void main(String[] args) {
        // creates an ArrayList from an array.
        String[] sArray = {"red", "blue", "purple", "green", "orange", "brown", "white"};
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList(sArray));
        
        // Create an array from an ArrayList.
        String[] sArray2 = new String[list1.size()];
        list1.toArray(sArray2);
        System.out.println(Arrays.toString(sArray2));
        
        Integer[] intArray ={3, 5, 95, 4, 15, 34, -7, 6};
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(intArray));
        System.out.println(intArray);
        System.out.println(list2);
        Collections.sort(list2);
        System.out.println(list2);        
        Collections.shuffle(list2);
        System.out.println(list2);
        System.out.println(Collections.max(list2));
        System.out.println(Collections.min(list2));
    }
}
