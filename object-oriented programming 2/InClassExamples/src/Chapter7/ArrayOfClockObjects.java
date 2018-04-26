// driver or client class of the clock class
// create 100 clock class objects
// assign a specific value to one element
package Chapter7;

// display the content of the array
// both for loops and employed


public class ArrayOfClockObjects
{
    public static void main(String[] args)
    {
        // create an array of Clock objects
        Clock[] arrivalTimeEmp = new Clock[100];
        // for loop to load array
        for (int j = 0; j < arrivalTimeEmp.length; j++)
            //load each element in the array using default constructor
            arrivalTimeEmp[j] = new Clock();
        
        for(Clock obj : arrivalTimeEmp)// enhanced for loop
            // each element in the array of Clock class objects in incremented
            obj.incrementSeconds();
        //assign a specific value to one element
        arrivalTimeEmp[49].setTime(8,5,10);
        
        int i = 1; // used to number employee beginning with 1
        // enhanced for loop to display output
        for(Clock obj : arrivalTimeEmp)
            System.out.println("Employee " + (i++)
                    + " arrival time: " + obj);
    }
}