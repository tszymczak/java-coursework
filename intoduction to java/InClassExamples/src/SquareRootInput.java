import java.util.Scanner;

/**
 * Calculate square roots.
 * @author Thomas Szymczak
 * 09-09-2015
 */
public class SquareRootInput {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double input, result;
        System.out.print("Enter a number to find the square root. --> ");
        input = scan.nextDouble();
        result = Math.sqrt(input);
        System.out.println("The square root of " + input + " is " + result +
            ".");
    }
    
}
