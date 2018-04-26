package LabAssignment5;

/**
 * Keep track of information relating to powerboats.
 * @author Thomas Szymczak
 * Lab Assignment 5
 */
public class Powerboat extends Boat {
    // The number of engines the boat has.
    private int noEngines;
    private String fuelType;
    
    public Powerboat(String aStateRegistrationNo, double aLength,
            String aManufacturer, int aYear, int aNoEngines, String aFuelType) {
        super(aStateRegistrationNo, aLength, aManufacturer, aYear);
        setNoEngines(aNoEngines);
        setFuelType(aFuelType);
    }
    
    // Warning: This doesn't produce a string that ends in a newline!
    @Override
    public String tellAboutSelf() {
        return "This is a powerboat " + this.getStateRegistrationNo() + "\n" +
                "Length: " + this.getLength() + "\n" +
                "Manufacturer: " + this.getManufacturer() + "\n" +
                "Year built: " + this.getYear() + "\n" +
                "Number of engines: " + noEngines + "\n" +
                "Fuel type: " + fuelType + "\n" +
                "************";
    }
    
    public void setNoEngines(int aNoEngines) {
        // Don't allow a negative number of engines.
        if (aNoEngines >= 0) {
            noEngines = aNoEngines;
        } else {
            System.err.println("Fatal Error!");
            System.exit(0);
        }
    }
    
    public void setFuelType(String aFuelType) {
        fuelType = aFuelType;
    }
    
    public int getNoEngines() {
        return noEngines;
    }
    
    public String getFuelType() {
        return fuelType;
    }
    
    /**
     * Compare two boats. In this case, we use length for comparison purposes.
     * Return whether the calling object is greater. In other words, if we
     * call this method like this: boat1.compareTo(boat2)
     * Then:
     * If boat1 >  boat2, return 1.
     * If boat1 == boat2, return 0.
     * If boat1 <  boat2, return -1.
     * @param t The object to compare to
     * @return Whether the calling object is greater than the argument object.
     */
    @Override
    public int compareTo(Boat t) {
        if ( this.getLength() > t.getLength() ) {
            return 1;
        } else if (this.getLength() == t.getLength() ) {
            return 0;
        } else {
            return -1;
        }
    }
    
}
