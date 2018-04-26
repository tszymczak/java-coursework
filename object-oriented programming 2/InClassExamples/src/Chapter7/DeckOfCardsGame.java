package Chapter7;

/**
 *
 * @author thomas.szymczak
 */
public class DeckOfCardsGame {

    /**
     * @param args Arguments are accepted but ignored.
     */
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        Card[] hand = new Card[5];
        Card[] hand2 = new Card[7];
        
        for (int i = 0; i < hand.length; ++i )
            hand[i] = deck.dealCard();
        
        for (int i = 0; i < hand.length; ++i)
            System.out.println(hand[i].toString());
        
        deck.shuffle();

        System.out.println();
        
        for (int i = 0; i < hand2.length; ++i )
            hand2[i] = deck.dealCard();
        
        for (int i = 0; i < hand2.length; ++i)
            System.out.println(hand2[i].toString());
    }
    
}
