package Chapter12;

import java.io.*;
import java.util.*;

public class WorkingWithFileInfo {
    public static void main(String[] args) throws Exception {
        
        // Check if source file exists
        File sourceFile = new File("src/Chapter12/Lincoln.txt");
        if (!sourceFile.exists()) {
            System.out.println("Source file " + sourceFile.getName() + " does not exist");
            System.exit(2);
        }
        
        // Create a Scanner for the file
        Scanner input = new Scanner(sourceFile);
        
        int wordCount = 0, lineCount = 0;
        
        String oneLine;
        while (input.hasNext()) {
            oneLine = input.nextLine();
            lineCount++;
            wordCount += countWords(oneLine);
        }
        
        System.out.println("File " + sourceFile + "has ");
        System.out.println(sourceFile.length() + " characters");
        System.out.println(wordCount + " words");
        System.out.println(lineCount + " lines");
    }
    
    private static int countWords(String s) {
        String[] words = s.split("[ \\t\\n\\r]");
        int count = 0;
        
        for (String word: words)
            if (word.length() > 0)
                count++;
        
        return count;
    }
}