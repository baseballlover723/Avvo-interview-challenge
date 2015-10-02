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

    public boolean hasSetRevealed() {
        if (this.revealedCards.size() < 3) {
            return false;
        }
        for (int i = 0; i < this.revealedCards.size() - 2; i++) {
            for (int k = i + 1; k < this.revealedCards.size() - 1; k++) {
                for (int j = k + 1; j < this.revealedCards.size(); j++) {
                    Card card1 = this.revealedCards.get(i);
                    Card card2 = this.revealedCards.get(k);
                    Card card3 = this.revealedCards.get(j);
                    Set set = new Set(card1, card2, card3);
                    if (set.isValid()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public ArrayList<Card> getRemainingCards() {
        return this.remainingCards;
    }

    public ArrayList<Card> getRevealedCards() {
        return this.revealedCards;
    }

}
