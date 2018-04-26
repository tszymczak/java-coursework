// DecoOfCards class represents a deck of playing cards.
package Chapter7;
import java.util.Random;
public class DeckOfCards
{
    String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
        "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
    String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };
    private Card deck[]; // array of Card objects
    private int currentCard; // the index of next Card to be dealt
    private final int NUMBER_OF_CARDS = 52; // constant number of cards
    private Random randomNumbers; // random number generator
    
    // constructor fills deck of cards
    public DeckOfCards() {
        deck = new Card[ NUMBER_OF_CARDS ]; // create array of Card objects
        currentCard = 0; // initialize currentCard
        randomNumbers = new Random(); // create random number generator
        
        // populate deck with Card objects
        for ( int count = 0; count < deck.length; count++ )
            deck[ count ] =
                new Card( faces[ count % 13 ], suits[ count / 13 ] );
        
    }
    
    // shuffle deck of cards with one-pass algorithm
    public void shuffle() {
        currentCard = 0; // reinitialize currentCard
        Card temp;
        // for each card, pick another random card and swap them
        for ( int first = 0; first < deck.length; first++ ) {
            int second = randomNumbers.nextInt( NUMBER_OF_CARDS );
            temp = deck[ first ];
            deck[ first ] = deck[ second ];
            deck[ second ] = temp;
        } // end for
    } // end method shuffle
    
    // deal one card
    public Card dealCard()
    {
        // determing whether cards remain to be dealt
        if ( currentCard < deck.length )
            return deck[ currentCard++ ]; // return current Card in array
        else
            return null; // return null to indicate that all cards were dealt
    } // end method dealCard
} // end class DeckOfCards