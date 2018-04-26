package LabAssignment3;

/**
 * Keep track of employee records, like their names and hire dates.
 * @author Thomas Szymczak
 * Lab Assignment 3;
 */
public class Employee {
    private String name;
    private Date hireDate;
    private int departmentCode;
    private static int numberOfEmployees;
    
    public Employee() {
        // This sets the date contained in the Date object to Jan 1, 2000.
        Date temp = new Date();
        temp.setYear(2000);
        temp.setMonth(1);
        temp.setDate(1);
        name = "No name";
        hireDate = temp;
        departmentCode = 1000;
        numberOfEmployees++;
    }
    
    public Employee(String theName, Date theDate, int theDeptCode) {
        name = theName;
        hireDate = theDate;
        departmentCode = theDeptCode;
        numberOfEmployees++;
    }
    
    public Employee(Employee orig) {
        name = orig.getName();
        hireDate= orig.getHireDate();
        departmentCode = orig.getDepartmentCode();
        numberOfEmployees++;
    }
    
    public String getName() {
        return name;
    }
    
    // This does a deep copy. The Date class lacks a deep copy, but we can
    // copy all the data using one of its constructors.
    public Date getHireDate() {
        return new Date(hireDate);
    }
    
    public int getDepartmentCode() {
        return departmentCode;
    }
    
    public static int getNumberOfHired() {
        return numberOfEmployees;
    }
    
    public void setName(String newName) {
        name = newName;
    }
    
    public void setHireDate(Date newDate) {
        hireDate = newDate;
    }
    
    public void setDepartmentCode(int newCode) {
        departmentCode = newCode;
    }
    
    public String toString() {
        return "Name: " + this.getName() + "\n" +
                "Hired date: " + this.getHireDate() + "\n" +
                "Department Code: " + this.getDepartmentCode();
    }
    
    public boolean equals(Employee otherObject) {
        return this.getName().equals(otherObject.getName()) &&
                this.getHireDate().equals(otherObject.getHireDate()) &&
                this.getDepartmentCode() == otherObject.getDepartmentCode();
    }
    
}
