package Chapter10;

/**
 * This application uses the StackOfIntegers class
 * 
 * @author don smith
 * 2-20-17
 */
public class TestStack {
    public static void main(String[] args) {
        StackOfIntegers testStack = new StackOfIntegers();
        System.out.println("The size of the stack is " + testStack.getSize());
        System.out.println("The stack is empty: " + testStack.empty());
        System.out.println("The stack capacity is " + testStack.getCapacity());
        // load stack
        for ( int i = 0; i < 20; i++ )
            testStack.push(i);
        
        System.out.println("Stack is empy: " + testStack.empty());
        
        System.out.println("Last value entered is " + testStack.peek());
        testStack.push(10);
        System.out.println("The stack capacity is " + testStack.getCapacity());
        
        // Let's sum all the values in the stack.
        int sum = 0;
        while ( !testStack.empty() ) {
            sum += testStack.pop();
        }
        
        System.out.println("The total of the values in the stack is " + sum);
    }
    
}