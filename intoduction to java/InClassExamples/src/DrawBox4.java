/**
 * This program draws boxes
 * @author Thomas Szymczak
 * 10-28-2015
 */
public class DrawBox4 {

    // This method draws a rectangle shape.
    public static void drawRectangle()
    {
        drawRectangle( 9, 5);
    }
    
    public static void drawRectangle(int x, int y)
    {
        
        for ( int i = 0; i < x; i++ )
        {
            System.out.print("*");
        }
        System.out.println();

        for ( int i = 0; i < y-2; i++ )
        {
            System.out.print("*");
            for ( int j = 0; j < x-2; j++ )
            {
                System.out.print(" ");
            }
            System.out.println("*");
        }

        for ( int i = 0; i < x; i++ )
        {
            System.out.print("*");
        }
        System.out.println();
    }

    // This method draws a triangle.
    public static void drawTriangle()
    {
        // Illuminati confirmed!
        drawTriangle(9);
    }
    
    public static void drawTriangle(int x)
    {
        int stars = 1;
        int space = (x - stars) / 2;
        while (stars <= x )
        {
            for ( int j = 0; j < space; j++ )
            {
                System.out.print(" ");
            }
            for ( int j = 0; j < stars; j++ )
            {
                System.out.print("*");
            }
            for ( int j = 0; j < space; j++)
            {
                System.out.print(" ");
            }
            System.out.println();
            stars += 2;
            space -= 1;
        }
    }
    
    // Crystal method.
    public static void crystal() {}
    
    // Draw a house.
    public static void drawHouse() {
        drawTriangle();
        drawRectangle();
    }
    
    public static void main(String[] args) {
        drawHouse();
        drawHouse();
        drawRectangle(25,6);
        drawTriangle(1500);
}
    
}
