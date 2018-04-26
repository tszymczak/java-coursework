package Chapter12;

import java.io.*;
import java.util.*;

public class ReplaceText {
    public static void main(String[] args) throws Exception {
        // Check if source file exists.
        File sourceFile = new File("src\\source.txt");
        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist.");
            System.exit(2);
        }
        
        // Cehck if target file exists
        File targetFile = new File("src\\target.txt");
        if (targetFile.exists()) {
            System.out.println("Target file already exists.");
            System.exit(3);
        }
        
        /**
         * try-with-resources, all resources inside the parentheses must be
         * created and have a close() method. Auto close() of the resources
         * takes place. The preceeding {block of code} contains all the
         * created resources activities.
         */
        try (
                Scanner input = new Scanner(sourceFile);
                PrintWriter output = new PrintWriter(targetFile);)
        {
            String s1, s2;
            while (input.hasNext()) {
                s1 = input.nextLine();
                s2 = s1.replaceAll("my", "our");
                output.println(s2);
            }
        }
    }
}