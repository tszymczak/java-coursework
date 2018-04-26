package Chapter9;

/**
 * This class has only static methods.
 * @author Don Smith
 * 2-15-17
 */
public final class DigitValidator {
    
    /**
     * Find out how long the d is, because she needs to know.
     * @param d The d
     * @return The length of d
     */
     public static int countDigits(long d)
     {
         int count = 0;
         while (d != 0)
         {
             count++;
             d /= 10;
         }
         return count;
     }
     
     public static boolean isWholeNumber(String s)
     {
        for (int i = 0; i < s.length(); i++)
        {
            if (!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
     }
}
