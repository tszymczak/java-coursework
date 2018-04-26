/**
 * This program demonstrates integer division.
 * @author Thomas Szymczak
 * 08/31/2015
 */
public class IntegerDivision {

    public static void main(String[] args) {
        // This is NOT the implementation the professor did for the class.
        // His code:        
//        int day1 = 88;
//        int day2 = 88;
//        int day3 = 89;
//        double average = (double)(day1 + day2 + day3) / 3;
//        System.out.println("The aerage temperature of the 3 days is "
//        + average);
        int nDays = 3;
        int[] days = new int[nDays + 1];
        double average;
        
        // Yes, I know we're not using the 0th element.
        days[1] = 88;
        days[2] = 88;
        days[3] = 89;
        
        int sum = 0;
        for ( int i = 1; i < days.length; i++) {
        sum += days[i];
        }
        
        average = (double)sum / (days.length - 1);
        
        System.out.println( "The average temperature of the " + nDays +
            " days is " + average + ".");     
    }
    
}
