package setGame;

import java.util.ArrayList;

public class Deck {
    // assume that a deck must have between 12 and 75 cards
    public static int MIN_DECK_SIZE = 12;
    public static int MAX_DECK_SIZE = 75;
    private ArrayList<Card> remainingCards;

    public Deck() {
    }

    public Deck(int deckSize) {
    }

    public ArrayList<Card> getRemainingCards() {
        return this.remainingCards;
    }

}
