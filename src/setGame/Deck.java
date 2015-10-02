package setGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck extends ArrayList<Card>{
    // assume that a deck must have between 12 and 75 cards
    public static int MIN_DECK_SIZE = 12;
    public static int MAX_DECK_SIZE = 75;

    public Deck() {
        this(new Random().nextInt(MAX_DECK_SIZE - MIN_DECK_SIZE) + MIN_DECK_SIZE);
    }

    public Deck(int deckSize) {
        super();
        for (int k = 0; k < deckSize; k++) {
            this.add(Card.generateRandomCard());
        }
    }

    public Deck(Card[] cards) {
        super(Arrays.asList(cards));
    }
}
