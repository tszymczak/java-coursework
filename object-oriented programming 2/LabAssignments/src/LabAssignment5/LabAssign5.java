package LabAssignment5;
import java.util.ArrayList;
import java.util.Collections;
/**
 * TestBoat -- demonstrates inheritance, abstract classes
 * and using tellAboutSelf() method with both Sailboat and
 * Powerboat subclasses, dynamic binding.
 * Do not change the code
 */
public class LabAssign5 {
    
    public static void main(String args[]) {
        // create two sailboats (7 arguments)
        ArrayList <Boat>fleet = new ArrayList<Boat>();
        fleet.add(new Sailboat("MO34561", 28, "Tartan",
                2008, 4.11, 2, "Inboard Diesel"));
        fleet.add(new Sailboat("MO45678", 27, "S2 Yachts",
                2004, 3.9, 4, "Outboard Gas"));
        
        // create two powerboats (6 arguments)
        fleet.add(new Powerboat("MO67891", 30, "Bayliner",
                2011, 2, "Gas"));
        fleet.add(new Powerboat("MO78910", 27, "Slickcraft",
                2015, 1, "Gas"));
        // Comparable interface enables the static sort() method
        Collections.sort(fleet);
        // get information about sailboats using tellAboutSelf method
        for (Boat e : fleet) {
            System.out.println(e.tellAboutSelf());
        }
    }
}
