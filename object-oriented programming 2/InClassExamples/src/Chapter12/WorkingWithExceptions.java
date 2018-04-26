/* In class example
 * Chapter 12
*/
package Chapter12;
public class WorkingWithExceptions {
    public static void main(String[] args) {
        try {
            exerciseMethod(0);
        } catch(Exception e) {
            System.out.println("Caught in main.");
        }
    }
    
    public static void exerciseMethod(int n) throws Exception {
        try {
            if (n > 0)
                throw new Exception();
            else if (n < 0)
                throw new NegativeNumberException();
            else
                System.out.println("No exception.");
            System.out.println("Stil in sampleMethod.");
        } catch(NegativeNumberException e) {
            System.out.println("Caught in sampleMethod.");
        } finally {
            System.out.println("In finally block.");
        }
        System.out.println("After finally block");
    }
}