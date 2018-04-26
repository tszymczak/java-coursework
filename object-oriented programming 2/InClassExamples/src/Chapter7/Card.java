// Card class represents a playing card.
package Chapter7;
public class Card
{
    private String face; // face of card
    private String suit; // suit of card
    
    // two-argument constructor initializes card's face and suit
    public Card( String cardFace, String cardSuit )
    {
        face = cardFace; // initialize face of card
        suit = cardSuit; // intitialize suit of card
    } // end of two-argument Card constructor
    
    // return card face
    public String getFace()
    {
        return face;
    } // end method getFAce
    
    // return card suit
    public String getSuit()
    {
        return suit;
    } // end method getSuit
    
    // return String representation of single card
    public String toString()
    {
        return face + " of " + suit;
    } // end method toString
} // end class Card