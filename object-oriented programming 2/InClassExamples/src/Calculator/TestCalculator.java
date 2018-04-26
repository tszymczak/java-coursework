package Calculator;

/**
 * This program demonstrates argument passing between 2
 * application classes
 * @author Don Smith
 */
public class TestCalculator {

    public static void main(String[] args) {
        
        String[] s1 = {"25", "-", "15"};
        String[] s2 = {"75", "/", "5"};
        String[] s3 = {"15", "+", "15"};
        String[] s4 = {"10", "10", "10", "10"};
        Calculator.main(s1);
        Calculator.main(s2);
        Calculator.main(s3);
        Calculator.main(s4);
        Calculator.main(s1);
    }
}
