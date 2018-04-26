/*
 * Thomas Szymczak
 * Lab Assignment 2
 * CIT 244
 * A program that asks for two lists of numbers, then sorts and merges them.
 */
package LabAssignment2;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Main method.
 * @author Thomas Szymczak
 */
public class LabAssign2 {
    public static void main(String[] args) {
        // We initialize these to zero even though this value will always be
        // overwritten because the compiler is not smart enough to know that,
        // so NetBeans complains that it might not be initialized.
        Scanner scanner = new Scanner(System.in);
        
        int[] list1, list2, mergedList;
        int length1 = 0, length2 = 0;
        boolean validInput;
        int num;
        String temp;        

        // Get a positive number.
        do {
            validInput = true;
            System.out.print("How many numbers to enter in the first list? --> ");
            temp = scanner.nextLine();
            try {
                length1 = Integer.parseInt(temp);
            } catch (NumberFormatException e) {
                validInput = false;
            }
            
            if ( length1 <= 0 )
                validInput = false;
        } while (!validInput);


        list1 = getList(length1);
        
        
        // Get a positive number.
        do {
            validInput = true;
            System.out.print("How many numbers to enter in the second list? --> ");
            temp = scanner.nextLine();
            try {
                length2 = Integer.parseInt(temp);
            } catch (NumberFormatException e) {
                validInput = false;
            }
            
            if ( length2 <= 0 )
                validInput = false;
        } while (!validInput);

        list2 = getList(length2);

        // Sort the arrays.
        Arrays.sort(list1);
        Arrays.sort(list2);

        // Merge the arrays.
        mergedList = merge(list1, list2);
        
        // Print the results.
        System.out.println();
        System.out.println("The merged list is:");
        System.out.println(Arrays.toString(mergedList));
    }
    
    /**
     * Merge two sorted arrays into one sorted array, much like the merging
     * step in a mergesort.
     * @param list1 The first input array
     * @param list2 The second input array
     * @return The merged output. If list1 has a elements and list2 has b
     * elements, we will return an array with a+b elements.
     */
    public static int[] merge(int[] list1, int[] list2) {
        // We use p1 and p2 keep track of the current position in list1 and
        // list2.
        int p1 = 0, p2 = 0;
        int resultLength = list1.length + list2.length;
        int[] result = new int[resultLength];
        
        // Start by looking at the first element in each of the two arrays.
        // Copy that element and increment p1 or p2, which causes us to
        // scratch it off the list. Repeat until we get to the end of one
        // array, and then copy the remaining portion of the other array to
        // the result array.
        for ( int i = 0; i < result.length; i++ ) {
            if ( p1 < list1.length && p2 < list2.length ) {
                if ( list1[p1] < list2[p2] ) {
                    result[i] = list1[p1];
                    p1++;
                } else {
                    result[i] = list2[p2];
                    p2++;
                }
            } else if ( p1 < list1.length ) {
                result[i] = list1[p1];
                p1++;
            } else if ( p2 < list2.length ) {
                result[i] = list2[p2];
                p2++;
            }
        }
        
        return result;
    }

    /**
     * Get an array of integers from the user.
     * @param length The length of the array
     * @return The array containing the integers we collected.
     */
    public static int[] getList( int length ) {
        int[] list = new int[length];       
        boolean validInput;
        String temp;
        Scanner scanner = new Scanner(System.in);
        
        for ( int i = 0; i < list.length; i++ ) {
            // Collect an integer from the user.
            do {
                validInput = true;
                System.out.print("Enter number " + (i + 1) + " --> ");
                temp = scanner.nextLine();
                try {
                    list[i] = Integer.parseInt(temp);
                } catch (NumberFormatException e) {
                    validInput = false;
                }

            } while (!validInput);
        }
        
        return list;
    }
        
}
