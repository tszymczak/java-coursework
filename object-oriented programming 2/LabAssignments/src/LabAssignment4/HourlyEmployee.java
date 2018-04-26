package LabAssignment4;

import java.text.DecimalFormat;

/**
 * Extend the Employee class to keep track of hourly employees' pay.
 * @author Thomas Szymczak
 * Lab Assignment 4
 */
public class HourlyEmployee extends Employee {
    private double wageRate;
    private double hours;
    
    public HourlyEmployee() {
    }
    
    public HourlyEmployee(String theName, Date theDate, int departmentCode, double theWageRate, double theHours) {
        super(theName, theDate, departmentCode);
        wageRate = theWageRate;
        hours = theHours;
    }
    
    public HourlyEmployee(HourlyEmployee orig) {
        super(orig.getName(), orig.getHireDate(), orig.getDepartmentCode());
        wageRate = orig.getRate();
        hours = orig.getHours();
    }
    
    public double getRate() {
        return wageRate;
    }
    
    public double getHours() {
        return hours;
    }
    
    public double getPay() {
        return wageRate * hours;
    }
    
    public void setHours(double hoursWorked) {
        hours = hoursWorked;
    }
    
    public void setRate(double newWageRate) {
        wageRate = newWageRate;
    }
    
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        
        return "Name: " + this.getName() + "\n" +
                "Hired date: " + this.getHireDate() + "\n" +
                "Department Code: " + this.getDepartmentCode() + "\n" +
                "$" + df.format(wageRate) + " per hour for " + hours + " hours\n";
    }
    
    @Override
    public boolean equals(Object otherObject) {
        if ( otherObject == null || !(otherObject instanceof SalariedEmployee)) {
            return false;
        } else {
        HourlyEmployee otherEmployee = (HourlyEmployee)otherObject;
        return this.getName().equals(otherEmployee.getName()) &&
                this.getHireDate().equals(otherEmployee.getHireDate()) &&
                this.getDepartmentCode() == otherEmployee.getDepartmentCode() &&
                this.getRate() == otherEmployee.getRate() &&
                this.getHours() == otherEmployee.getHours();
        }

    }
}
