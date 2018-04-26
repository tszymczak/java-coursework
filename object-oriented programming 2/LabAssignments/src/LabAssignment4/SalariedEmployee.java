package LabAssignment4;

import java.text.DecimalFormat;

/**
 * Extend the Employee class to keep track of employee's salaries.
 * @author Thomas Szymczak
 * Lab Assignment 4
 */
public class SalariedEmployee extends Employee {
    private double salary;
    
    public SalariedEmployee() {
        // Automatically calls super()
    }
    
    public SalariedEmployee(String theName, Date theDate, int theDeptCode, double theSalary) {
        super(theName, theDate, theDeptCode);
        salary = theSalary;
    }
    
    public SalariedEmployee(SalariedEmployee originalObject) {
        super(originalObject.getName(), originalObject.getHireDate(), originalObject.getDepartmentCode());
        salary = originalObject.getSalary();
        
    }
    
    public double getSalary() {
        return salary;
    }
    
    public double getPay() {
        return salary;
    }
    
    public void setSalary(double newSalary) {
        salary = newSalary;
    }
    
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        
        return "Name: " + this.getName() + "\n" +
                "Hired date: " + this.getHireDate() + "\n" +
                "Department Code: " + this.getDepartmentCode() + "\n" +
                "$" + df.format(salary) + " per year\n";
    }
    
    @Override
    public boolean equals(Object otherObject) {
        if ( otherObject == null || !(otherObject instanceof SalariedEmployee)) {
            return false;
        } else {
        SalariedEmployee otherEmployee = (SalariedEmployee)otherObject;
        return this.getName().equals(otherEmployee.getName()) &&
                this.getHireDate().equals(otherEmployee.getHireDate()) &&
                this.getDepartmentCode() == otherEmployee.getDepartmentCode() &&
                this.getSalary() == otherEmployee.getSalary();
        }
    }
}
