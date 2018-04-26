package Chapter8;

import java.util.Arrays;
import java.util.Random;

/**
 * In class example
 * load 2d array with random values and determine the largest row.
 * 
 * Exam question: find the highest value and display the row and column number
 * 
 * 
 * @author Don Smith
 */
public class WorkingWith2DArrays {

    public static void main(String[] args) {
        int[][] baseArray = new int[7][5]; // 7 rows, 5 columns
        int[] rowTotals = new int[7]; // array to hold row totals
        int[] columnTotals = new int[5];
        loadArray(baseArray);
        displayArray2(baseArray);
        sumRows(baseArray, rowTotals);
        sumColumns(baseArray, columnTotals);
        System.out.println("Row totals:");
        System.out.println(Arrays.toString(rowTotals));
        System.out.println("The largest row total is row " +
                findLargest(rowTotals));
        System.out.println("Column totals:");
        System.out.println(Arrays.toString(columnTotals));
        System.out.println("The largest column total is column " +
                findLargest(columnTotals));
        System.out.println("The largest element in the matrix is " +
                findLargestElement(baseArray));
    }
    
    private static void loadArray(int[][] matrix) {
        Random gen = new Random();
        for (int row = 0; row < matrix.length; row++)
            for (int column = 0; column < matrix[row].length; column++ )
                matrix[row][column] = gen.nextInt(99) + 1; // 1-99 inclusive
    }
    
    private static void displayArray(int[][] matrix ) {
        for (int row = 0; row < matrix.length; row++ ) {
            for (int column = 0; column < matrix[row].length; column++ ) {
                System.out.print(matrix[row][column] + " " );
            }
            System.out.println();
        }
    }
    
    private static void displayArray2(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++ ) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    
    private static void sumRows(int[][] matrix, int[] totals) {
        for (int row = 0; row < matrix.length; row++ )
            for ( int column = 0; column < matrix[row].length; column++) {
                totals[row] += matrix[row][column];
            }
    }
    
    private static void sumColumns(int[][]matrix, int[] totals) {
        for (int column = 0; column < matrix[0].length; column++ )
            for ( int row = 0; row < matrix.length; row++ )
                totals[column] += matrix[row][column];
    }
    
    private static int findLargest(int[] totals) {
        int max = totals[0];
        int rowMax = 0;
        for ( int i = 1; i < totals.length; i ++ ) {
            if ( max < totals[i] ) {
                max = totals[i];
                rowMax = i;
            }
        }
        return (rowMax + 1);
    }
    
    private static int findLargestElement(int[][] matrix) {
        int largest = matrix[0][0];
        for ( int row = 0; row < matrix.length; row++ )
            for (int column = 0; column < matrix[row].length; column++ )
                if ( matrix[row][column] > largest )
                    largest = matrix[row][column];

                return largest;
    }
    
}
