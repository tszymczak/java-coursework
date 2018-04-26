package Chapter11;

/**
 * Test the Circle and Rectangle class, demonstrating the principles of
 * inheritance in the process.
 * @author Don Smith
 */
public class TestCircleRectangle {
    public static void main(String[] args) {
        Circle c1 = new Circle(1.0);
        System.out.println(c1);
        System.out.println();
        
        Rectangle r1 = new Rectangle(5.0, 4.5);
        
        System.out.println("The area of the circle is " + c1.getArea());
        System.out.println("The area of the rectangle is " + r1.getArea());
        System.out.println();
        
        c1.setColor("red");
        r1.setColor("blue");
        r1.setFilled(true);
        System.out.println(c1.toString());
        System.out.println();
        System.out.println(r1.toString());
    }
    
}
