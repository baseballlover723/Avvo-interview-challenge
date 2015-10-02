package setGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {
    // assume that a deck must have between 12 and 75 cards
    public static int MIN_DECK_SIZE = 12;
    public static int MAX_DECK_SIZE = 75;
    private ArrayList<Card> remainingCards;
    private ArrayList<Card> revealedCards;

    public Deck() {
        this(new Random().nextInt(MAX_DECK_SIZE - MIN_DECK_SIZE) + MIN_DECK_SIZE);
    }

    public Deck(int deckSize) {
        this.remainingCards = new ArrayList<Card>();
        this.revealedCards = new ArrayList<Card>();
        for (int k = 0; k < deckSize; k++) {
            this.remainingCards.add(Card.generateRandomCard());
        }
    }

    public Deck(Card[] cards) {
        this();
        for (Card card : cards) {
            this.remainingCards.remove(this.remainingCards.size() - 1);
        }
        this.revealedCards = new ArrayList<Card>(Arrays.asList(cards));
    }

    public ArrayList<Card> getRemainingCards() {
        return this.remainingCards;
    }

    public ArrayList<Card> getRevealedCards() {
        return this.revealedCards;
    }

}
