/**
 * This program draws boxes
 * @author Thomas Szymczak
 * 10-26-2015
 */
public class DrawBox2 {

    // This method draws a rectangle shape.
    public static void printBox()
    {
        System.out.println("*********");
        System.out.println("*       *");
        System.out.println("*       *");
        System.out.println("*       *");
        System.out.println("*********");
        
    }
    
    public static void main(String[] args) {
        for ( int i = 0; i < 3; i++ )
        {
        printBox();
        }
}
    
}
