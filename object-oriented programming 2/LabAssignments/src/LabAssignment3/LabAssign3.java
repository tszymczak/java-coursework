package LabAssignment3;

import java.util.Scanner;

/**
 * Gather information about some employees and print it.
 * @author Thomas Szymczak
 * Lab Assignment 3
 */
public class LabAssign3 {
    public static void main(String[] args) {
        int numEmployees;
        Employee[] employees;
        String dashes = "-----------------";
        
        // Get a valid number.        
        numEmployees = getArraySize("How many new employees to enter? --> ");
        
        employees = new Employee[numEmployees];
        
        // Collect information for each employee
        for (int i = 0; i < employees.length; i++ ) {
            employees[i] = createEmployee((i+1));
        }
        
        // Print info about each employee.
        System.out.println(dashes);
        for (int i = 0; i < employees.length; i++ ) {
            System.out.println(employees[i].toString());
            System.out.println(dashes);
        }
    }
    
    /**
     * Create an Employee object by prompting the user for the employee's
     * information, then return the object.
     * @param n The number of the employee in the sequence. This is just
     * use to give the user a more informative prompt.
     * @return An Employee object based on whatever data were entered
     */
    public static Employee createEmployee(int n) {
        Scanner scan = new Scanner(System.in);
        
        // Must initialize this to zero to make compiler stop complaining.
        int deptCode = 0;
        String name;
        String temp;
        Date hireDate;
        
        do {
            System.out.print("Enter name of employee #" + n + " --> ");
            name = scan.nextLine();
        } while (!name.matches("[A-Z][a-z[A-Z]-']+ [A-Z][a-z[A-Z]-']+"));
        
        // Ask for the date string, and then parse it in a separate method.
        do {
            System.out.print("Enter hire date in the format MM DD YYYY with spacing --> ");
            temp = scan.nextLine();
        } while (!temp.matches("[0-1][0-9] [0-3][0-9] 20[0-9][0-9]"));

        hireDate = parseDate(temp);
        
        do {
            System.out.print("Enter the department code in the format #### --> ");
            temp = scan.nextLine();
            try {
                deptCode = Integer.parseInt(temp);
            } catch (NumberFormatException e) {
                // If we get an exception here, then the regex will reject
                // out input as well, so we don't need to do anything here.
            }
        } while (!temp.matches("[1-9][0-9][0-9]0"));
        
        return new Employee(name, hireDate, deptCode);
    }
    
    /**
     * Parse a date given in the format "MM DD YYYY" and return the created
     * Date object. Note that this method does not do input validation, so
     * it depends on the calling method for that.
     * @param input The string describing the date
     * @return The Date object described by the string.
     */
    public static Date parseDate(String input) {
        Date outDate = new Date();
        
        String[] dateParts;
        int month, day, year;
        
        // Split the string.
        dateParts = input.split(" ");
        
        // Try to parse each part of the date.
        month = Integer.parseInt(dateParts[0]);
        day = Integer.parseInt(dateParts[1]);
        year = Integer.parseInt(dateParts[2]);

        // Set the date.
        outDate.setMonth(month);
        outDate.setDay(day);
        outDate.setYear(year);

        return outDate;
    }
    
    /**
     * Get an integer that can be a size for an array. This implies that it
     * must be positive.
     * @param prompt The prompt to give the user when asking for the number
     * @return The number the user entered
     */
    public static int getArraySize(String prompt) {
        Scanner scan = new Scanner(System.in);
        
        String temp;
        boolean valid = true;
        // Initialize to keep compiler happy
        int n = -1;
        
        do {
            System.out.print(prompt);
            temp = scan.nextLine();
            try {
                n = Integer.parseInt(temp);
            } catch (NumberFormatException e) {
                valid = false;
            }
            
            if (n < 1) {
                valid = false;
            }
        } while (!valid);
        
        return n;
    }
    
}