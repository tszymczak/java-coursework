package LabAssignment4;

import java.util.ArrayList;

/**
 * Put employees in a stack.
 * @author Thomas Szymczak
 * Lab Assignment 4
 */
public class EmployeeStack extends ArrayList<Employee> {
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }
    
    public int getSize() {
        return size();
    }
    
    public Employee peek() {
        return get(getSize() - 1);
    }
    
    public Employee pop() {
        Employee o = get(getSize() - 1);
        remove(getSize() - 1);
        return o;
    }
    
    public boolean push(Employee o) {
        add(o);
        return true;
    }
    
    /**
     * Find the location of the requested employee in the list.
     * @param o The employee object you're looking for
     * @return The position of the employee in the list. Returns -1 if not found.
     */
    public int search(Employee o) {
        // As long as ArrayList uses the equals method, this technique should
        // work.
        return super.indexOf(o);
    }
    
    public String toString() {
        // I actually counted the dashes on the handout :-)
        String dashline = "-----------------\n";
        String output = dashline;
        
        for (int i = getSize() - 1; i >= 0; i--) {
            // This implicitly calls the toString() method.
            output += get(i).toString();
            output += dashline;
        }
        return output;
    }
}
