package setGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {
    // assume that a deck must have between 12 and 75 cards
    public static int MIN_DECK_SIZE = 12;
    public static int MAX_DECK_SIZE = 75;
    protected ArrayList<Card> cards;

    public Deck() {
        this(new Random().nextInt(MAX_DECK_SIZE - MIN_DECK_SIZE) + MIN_DECK_SIZE);
    }

    public Deck(int deckSize) {
        this.cards = new ArrayList<Card>();
        for (int k = 0; k < deckSize; k++) {
            this.cards.add(Card.generateRandomCard());
        }
    }

    public Deck(Card[] cards) {
        this.cards = new ArrayList<Card>(Arrays.asList(cards));
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }
    
    public Card remove(int index) {
        return this.cards.remove(index);
    }
}
