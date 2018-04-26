package Chapter9;
import java.util.*;

/**
 * Demonstrates the use of classes in the Java library
 * @author don smith
 * 2-13-17
 */
public class WorkingWithClasses {
    public static void main(String[] args) {
        GregorianCalendar cal = new GregorianCalendar();
        System.out.println(cal.getTimeZone().getDisplayName());
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
    }
}
