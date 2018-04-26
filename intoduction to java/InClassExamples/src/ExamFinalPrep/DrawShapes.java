package ExamFinalPrep;

/**
 *
 * @author Thomas Szymczak
 */
public class DrawShapes {
    public static void drawTriangle()
    {
        System.out.println("    *    ");
        System.out.println("   ***   ");
        System.out.println("  *****  ");
        System.out.println(" ******* ");
        System.out.println("*********");
    }
    
    public static void drawX()
    {
        System.out.println("*       *");
        System.out.println(" *     * ");
        System.out.println("  *   *  ");
        System.out.println("    *    ");
        System.out.println("  *   *  ");
        System.out.println(" *     * ");
        System.out.println("*       *");
    }
    
    public static void drawRectangle()
    {
        System.out.println("*********");
        System.out.println("*       *");
        System.out.println("*       *");
        System.out.println("*       *");
        System.out.println("*********");
    }
    
    public static void drawRocket()
    {
        drawTriangle();
        drawRectangle();
        drawRectangle();
        drawX();
    }
    
    public static void drawRobot()
    {
        drawRectangle();
        drawX();
    }

    public static void main(String[] args) {
        drawRocket();
        System.out.print("\n\n");
        drawRobot();
    }
    
}
