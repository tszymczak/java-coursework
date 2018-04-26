/**
 * Lab Assignment 2
 * Convert acres to square feet.
 * @author Thomas Szymczak
 * 08-26-2015
 */
public class LabAssign2 {

    public static void main(String[] args) {
        final int SQ_FT_PER_ACRE = 43560;
        int squareFeet = 389767;
        
        double acres = (double)squareFeet / SQ_FT_PER_ACRE;
        
        System.out.println("There are " + acres + " acres in " + squareFeet +
            " square feet.");
    }
    
}
