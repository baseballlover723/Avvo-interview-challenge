package setGame;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    // assume that a deck must have between 12 and 75 cards
    public static int MIN_DECK_SIZE = 12;
    public static int MAX_DECK_SIZE = 75;
    private ArrayList<Card> remainingCards;

    public Deck() {
        this(new Random().nextInt(MAX_DECK_SIZE - MIN_DECK_SIZE) + MIN_DECK_SIZE);
    }

    public Deck(int deckSize) {
        this.remainingCards = new ArrayList<Card>();
        for (int k=0;k<deckSize;k++) {
            this.remainingCards.add(Card.generateRandomCard());
        }
    }

    public ArrayList<Card> getRemainingCards() {
        return this.remainingCards;
    }

}
