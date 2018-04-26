/**
 * TestPizza.java
 * Exam Practice Example
 * Driver class to test the Pizza2 class
 * Do no change the code.
 */
package Exam2Practice;

import Exam1Practice.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 * 
 * @author Don Smith
 */
public class TestPizza2 {
    // method returns a valid size pizza
    private static int getValidSize() {
        int d;
        String input;
        do {
            input = JOptionPane.showInputDialog(null,
                    "What size of pizza do you wish to order? " +
                    "\n 9 inch" +
                    "\n 12 inch" +
                    "\n 16 inch");
            d = Integer.parseInt(input);
        } while (!(d == 9 || d == 12 || d == 16));
        
        return d;
    }
    
    public static void main(String[] args) {
        char letter;
        String input, output = "";
        int sizeD, count = 0;
        // create an arry to hold up to 10 Pizza2 objects
        ArrayList<Pizza2> pizzaList = new ArrayList();
        
        do {
            sizeD = getValidSize();
            input = JOptionPane.showInputDialog(null,
                    "What type of topping do you wish to order? " +
                    "\n Green Pepper" +
                    "\n Mushroom" +
                    "\n Sausage" +
                    "\n Pepperoni" +
                    "\n Plain" );
            // Load array
            pizzaList.add(new Pizza2(sizeD, input)); // create and store
            
            input = JOptionPane.showInputDialog(null,
                    "Do you wish to continue?\n" +
                    "'Y' or 'y' for YES\n" +
                    "'N' or 'n' for NO" );
            letter = input.toUpperCase().charAt(0);
        } while (letter == 'Y');
        
        JOptionPane.showMessageDialog(null, "The number of pizzas made are " +
                Pizza2.getPizzaCount() + ".\n");
        
        // build a String output which holds all the array elements
        for (int i = 0; i < pizzaList.size(); i++) {
            output += pizzaList.get(i) + "\n";
        }
        JOptionPane.showMessageDialog(null, output);
        System.exit(0);
    } // end main()
    
}
