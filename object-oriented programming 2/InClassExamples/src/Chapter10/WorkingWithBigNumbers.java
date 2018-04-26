package Chapter10;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * large values
 * @author Don Smith
 */
public class WorkingWithBigNumbers {
    public static void main(String[] args) {
        String biggestInteger = String.valueOf(Long.MAX_VALUE);
        System.out.println("Long MAX is " + biggestInteger);
        long x = 9223372036854775807L;
        BigInteger bigInt = new BigInteger(Long.toString(x));
        System.out.println("x is " + bigInt);
        BigInteger smallInt = new BigInteger("30");
        bigInt = bigInt.multiply(smallInt);
        System.out.println( "Product is " + bigInt);
        BigDecimal bigD = new BigDecimal(333);
        BigDecimal bigD2 = new BigDecimal(1.1);
        BigDecimal bigD3 = bigD.divide(bigD2, 11, BigDecimal.ROUND_UP);
        System.out.println("Division is " + bigD3);
    }
}
