package Die;

import java.util.Random;

/**
 * This class represents a single die to be used by any application.
 * @author Thomas Szymczak
 * 12/2/2015
 */

public class Die {
    // data fields
    // We grow data here.
    private int value;
    private final int SIDES;
    
    // constructor
    public Die()
    {
        SIDES = 6;
        roll();
    }
    
    public void roll()
    {
        Random rGen = new Random();
        value = rGen.nextInt(SIDES) + 1;
    }
    
    // Accessor method
    public int getValue()
    {
        return value;
    }
}
