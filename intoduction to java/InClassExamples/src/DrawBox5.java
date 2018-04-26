
import java.util.Scanner;

/**
 * This program draws boxes
 * @author Thomas Szymczak
 * 10-28-2015
 */
public class DrawBox5 {

    // This method draws a rectangle shape.
    public static void drawBox()
    {
        for ( int i = 0; i < 3; i++ )
        drawBox( 9, 5 );
    }
    
    public static void drawBox(int x, int y)
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

    
    public static void main(String[] args) {
        int n;
        
        // Cute servant kitteh.
        Scanner kitty = new Scanner(System.in);
        
        System.out.print("How many boxes do you want? --> ");
        n = kitty.nextInt();
        
        for ( int i = 0; i < n; i++ )
        {
            drawBox(i+2, (i+2)/2);
        }
        
}
    
}
