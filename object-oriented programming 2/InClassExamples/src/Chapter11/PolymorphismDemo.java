package Chapter11;

/**
 *
 * @author Don Smith
 */
public class PolymorphismDemo {
    public static void main(String[] args) {
        displayObject(new Circle(1, "red", false));
        displayObject(new Rectangle(1, 1, "blue", false));
    }
    
    public static void displayObject(GeometricObject object) {
        System.out.println(object.toString() + "\n");
    }
}
