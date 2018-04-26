package LabAssignment5;

/**
 * Keep track of information relating to sailboats.
 * @author Thomas Szymczak
 * Lab Assignment 5
 */
public class Sailboat extends Boat {
    private double keelDepth;
    private int noSails;
    private String motorType;
    
    public Sailboat(String aStateRegistrationNo, double aLength,
            String aManufacturer, int aYear, double aKeelDepth, int aNoSails,
            String aMotorType) {
        super(aStateRegistrationNo, aLength, aManufacturer, aYear);
        setKeelDepth(aKeelDepth);
        setNoSails(aNoSails);
        setMotorType(aMotorType);
    }
    
    // Warning: This doesn't produce a string that ends in a newline!
    @Override
    public String tellAboutSelf() {
        return "This is a sailboat " + this.getStateRegistrationNo() + "\n" +
                "Length: " + this.getLength() + "\n" +
                "Manufacturer: " + this.getManufacturer() + "\n" +
                "Year built: " + this.getYear() + "\n" +
                "Keel depth: " + keelDepth + "\n" +
                "Number of sails: " + noSails + "\n" +
                "Motor type: " + motorType + "\n" +
                "************";
    }
    
    public void setKeelDepth(double aKeelDepth) {
        if (aKeelDepth > 0.0) {
            keelDepth = aKeelDepth;
        } else {
            System.err.println("Fatal Error!");
            System.exit(0);
        }
    }
    
    public void setNoSails(int aNoSails) {
        if ( aNoSails > 0 ) {
            noSails = aNoSails;
        } else {
            System.err.println("Fatal Error!");
            System.exit(0);            
        }
    }
    
    public void setMotorType(String aMotorType) {
        motorType = aMotorType;
    }
    
    public double getKeelDepth() {
        return keelDepth;
    }
    
    public int getNoSails() {
        return noSails;
    }
    
    public String getMotorType() {
        return motorType;
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
