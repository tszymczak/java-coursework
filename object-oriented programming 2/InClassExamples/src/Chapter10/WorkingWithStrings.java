package Chapter10;
import java.util.Scanner;

/**
 * Chapter 10 String method examples
 * @author Don Smith
 */
public class WorkingWithStrings {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // interned string example
        String s1 = "I save memory space";
        String s2 = new String("I save memory space");
        String s3 = "I save memory space";
        
        String equal = "The objects are equal";
        String notEqual = "The objects are NOT equal";
        
        if ( s1 == s2 )
            System.out.println(equal);
        else
            System.out.println(notEqual);
        
        if ( s1 == s3 )
            System.out.println(equal);
        else
            System.out.println(notEqual);
        
        if (s1.equals(s2))
            System.out.println(equal);
        else
            System.out.println(notEqual);
        
        s1 = s1.toUpperCase();
        s3 = s3.toUpperCase();
        
        if ( s1 == s3 )
            System.out.println(equal);
        else
            System.out.println(notEqual);
        
        //* regular expression or regex on-line supplement at textbook web site
        do {
            System.out.print("Enter your SSN in the format ###-##-#### " +
                    "with dashes --> ");
            s1 = scan.nextLine();
        // 0 is not allowed for area code or exchange
        } while (!s1.matches("\\d{3}-\\d{2}-\\d{4}"));
        
        do {
            System.out.print("Enter your phone number in the format" +
                    "###-###-#### with dashes --> ");
            s1 = scan.nextLine();
        } while (!s1.matches("[1-9]\\d{2}-[1-9]\\d{2}-\\d{4}"));
        
        // character input
        do {
            System.out.print("Enter your first name, " +
                    "begin with upper case letter --> ");
            s1 = scan.nextLine();
        } while ( !s1.matches("[A-Z][a-zA-Z]*"));
        
        do {
            System.out.print("Enter your last name --> ");
            s1 = scan.nextLine();
        } while (!s1.matches("[a-zA-Z]+([ '-][a-zA-Z]+)*"));
        
        s1 = "C:/Users/Owner/Desktop/book/Chapter05";
        String[] s = s1.split("[:/]"); // replace "[:/]+"
        System.out.println("The drives and folders are:");
        for (int i = 0; i < s.length; i++ )
            System.out.println(s[i]);
        
        s1 = String.valueOf(3.27); // convert inte to String
        for (int i = 0; i < s1.length(); i++ )
            if (Character.isDigit(s1.charAt(i)))
                System.out.println(s1.charAt(i));
        
        StringBuilder sb = new StringBuilder("Lets Go ");
        sb.append("Bucs!");
        System.out.println(sb);
        sb.replace(8, 12, "Steelers");
        System.out.println(sb);
        System.out.println("The length is " + sb.length());
        System.out.println("The capacity is " + sb.capacity());
    }
    
}
