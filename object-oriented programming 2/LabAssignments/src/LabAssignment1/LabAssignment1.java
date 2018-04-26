package LabAssignment1;

import java.util.Random;

/**
 * Lab Assignment 1
 * A program that plays a simple game of craps.
 * @author Thomas Szymczak
 */
public class LabAssignment1 {

    /**
     * Play a game of craps.
     * @param args Arguments are accepted but discarded.
     */
    public static void main(String[] args) {
        int diceCount;
        
        diceCount = rollDice();
        determineOutcome(diceCount);
    }
    
    /**
     * Determine the outcome of a game of craps, given the first roll.
     * @param diceCount The first roll
     * @return Whether the player wins or loses.
     */
    public static boolean determineOutcome(int diceCount) {
        String winMsg = "You win", loseMsg = "You Lose";
        int point;
        
        if ( diceCount == 2 || diceCount == 3 || diceCount == 12 ) {
            System.out.println(winMsg);
            return false;
        } else if ( diceCount == 7 || diceCount == 11 ) {
            System.out.println(loseMsg);
            return true;
        }
        
        // Roll again until we get an outcome.
        point = diceCount;
        System.out.println("The point is " + point);

        while ( true ) {
            diceCount = rollDice();

            if ( diceCount == point) {
                System.out.println(winMsg);
                return true;
            } else if ( diceCount == 7 ) {
                System.out.println(loseMsg);
                return false;
            }
        }
        
    }
    /**
     * Simulate rolling two dice. The result is printed.
     * @return The sum of the dice.
     */
    public static int rollDice() {
        Random rng = new Random();
        int a, b, sum;
        a = rng.nextInt(6) + 1;
        b = rng.nextInt(6) + 1;
        sum = a + b;
        
        System.out.println("You rolled " + a + " + " + b + " = " + sum);
        return sum;
    }
    
}
