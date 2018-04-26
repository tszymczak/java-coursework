/**
 * This program draws boxes
 * @author Thomas Szymczak
 * 10-26-2015
 */
public class DrawBox3 {

    // This method draws a rectangle shape.
    public static void printBox()
    {
        System.out.println("*********");
        System.out.println("*       *");
        System.out.println("*       *");
        System.out.println("*       *");
        System.out.println("*********");
        
    }
    
    public static void printBoxNew(int x, int y)
    {
        for ( int i = 0; i < x; i++ )
        {
            System.out.println("*********");
        }
        for ( int i = 0; i < y-2; i++ )
        {
            System.out.print("*");
            for ( int j = 0; j < x-2; j++ )
            {
            }
        }
        System.out.println("*       *");
        System.out.println("*       *");
        System.out.println("*       *");
        System.out.println("*********");
        
    }

    // This method draws a triangle.
    public static void printTriangle()
    {
        // Illuminati confirmed!
        System.out.println("    *    ");
        System.out.println("   ***   ");
        System.out.println("  *****  ");
        System.out.println(" ******* ");
        System.out.println("*********");
    }
    
    // Crystal method.
    public static void crystal() {}
    
    public static void main(String[] args) {
        printTriangle();
        printBox();
}
    
}
