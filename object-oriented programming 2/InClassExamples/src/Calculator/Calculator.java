/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

/**
 *
 * @author Yo Bitch
 */
public class Calculator {
    /**
     * Main method
     */
    public static void main (String[] args) {
        // The result of the operation
        int result = 0;
        
        // Check number of strings passed
        if ( args.length != 3 ) {
            System.out.println(
                "Calculator operand1 operator operand2 as Strings");
        } else
        {
            // Determine the operator
            switch (args[1].charAt(0)) {
                case '+':
                    result = Integer.parseInt(args[0])
                            + Integer.parseInt(args[2]);
                    break;
                case '-':
                    result = Integer.parseInt(args[0])
                            - Integer.parseInt(args[2]);
                    break;
                case '*':
                    result = Integer.parseInt(args[0])
                            * Integer.parseInt(args[2]);
                    break;
                case '/':
                    result = Integer.parseInt(args[0])
                            / Integer.parseInt(args[2]);
            }
            
            // Display result
            System.out.println(args[0] + ' ' + args[1] + ' ' + args[2]
                    + " = " + result);
                            
        }
    }
}
