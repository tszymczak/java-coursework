/**
 * This program demonstrates the use of shortcut operators.
 * @author Thomas Szymczak
 */
public class ShortCutArithmeticOperators {

    public static void main(String[] args) {
        int a = 5;
        a += 10; // a = a + 10
        
        System.out.println("After a += 10 the value of a is " + a);
        
        beer(10);
    }
    
    public static void beer(int x) {
        // TODO: Special case for two bottles of beer.
        for ( int i = x; i > 1; i-- ) {
            System.out.println(i + " bottles of beer on the wall, " +
                    i + " bottles of beer.");
            System.out.println("Take one down, you pass it around, " + (i-1) +
                    " bottles of beer on the wall.");
        }
        
        if ( x > 0 ) {
            int i = 1;
            System.out.println(i + " bottle of beer on the wall, " +
                    i + " bottle of beer.");
            System.out.println("Take one down, you pass it around, " + (i-1) +
                    " bottles of beer on the wall.");
        }
    }
    
}
