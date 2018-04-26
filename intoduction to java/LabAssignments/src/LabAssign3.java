import java.util.*;
/**
 * Lab Assignment 3
 * Calculate miles per gallon based on the user's input.
 * @author Thomas Szymczak
 * 09-02-2015
 */
public class LabAssign3 {

    public static void main(String[] args) {
        double gallons, mpg;
        int miles;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter the miles driven: --> ");
        miles = keyboard.nextInt();
        
        System.out.print("Enter the gallons of fuel used: --> ");
        gallons = keyboard.nextDouble();
        
        mpg = miles / gallons;

        System.out.print("\n");
        System.out.println("The miles-per-gallon based on the data entered is " + mpg);
    }
    
}
