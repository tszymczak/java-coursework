package LabAssign10;

/**
 * Lab Assignment 10
 * A simple driver class that demonstrates use of the car class.
 * (Hmm...it drives a car class. That's funny.)
 * @author Thomas Szymczak
 * 11-18-2015
 */
public class CarDemo {

    public static void main(String[] args) {
        Car miniCooper = new Car(2014, "Mini Cooper");
        
        System.out.println("Current Status of the car:");
        System.out.println("Year model: " + miniCooper.getYearModel() );
        System.out.println("Make: " + miniCooper.getMake() );
        System.out.println("Speed: " + miniCooper.getSpeed() );
        
        System.out.println();
        
        System.out.println("Accelerating...");
        for ( int i = 0; i < 7; i++ )
        {
            miniCooper.accelerate();
        }
        
        System.out.println("Now the speed is " + miniCooper.getSpeed() );
        System.out.println();
        
        System.out.println("Braking...");
        for ( int i = 0; i < 3; i++ )
        {
            miniCooper.brake();
        }
        
        System.out.println("Now the speed is " + miniCooper.getSpeed() );
        System.out.println();
    }
    
}
