package LabAssign10;

/**
 * Lab Assignment 10
 * A class that allows you to make car objects and store information about
 * them.
 * @author Thomas Szymczak
 * 11-18-2015
 */
public class Car {
    private int yearModel;
    private String make;
    private int speed;
    
    // Constructor
    public Car( int y, String m )
    {
        yearModel = y;
        make = m;
        speed = 0;
    }
    
    public void setYearModel( int y )
    {
        yearModel = y;
    }
    
    public void setMake( String m )
    {
        make = m;
    }
    
    public void setSpeed( int s )
    {
        speed = s;
    }
    
    public int getYearModel()
    {
        return yearModel;
    }
    
    public String getMake()
    {
        return make;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public void accelerate()
    {
        speed += 5;
    }
    
    public void brake()
    {
        speed -= 5;
    }
    
}
