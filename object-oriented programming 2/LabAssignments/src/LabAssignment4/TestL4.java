/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabAssignment4;

/**
 *
 * @author thomas
 */
public class TestL4 {
    public static void main(String[] args) {
        Employee sam = new Employee("Sam Spade", new Date(2,20,2012), 2010);
        HourlyEmployee dennis = new HourlyEmployee("Dennis Casper", new Date(12,5,2013), 2040, 15.75, 173.25);
        SalariedEmployee sarah = new SalariedEmployee("Sarah Holt", new Date(10,4,2014), 2220, 59000.00);
        
        EmployeeStack stack = new EmployeeStack();
        stack.push(sam);
        stack.push(dennis);
        stack.push(sarah);
        
        System.out.println(stack);
    }
}
