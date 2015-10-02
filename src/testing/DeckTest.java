package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;
import enums.Number;
import enums.Shading;
import enums.Shape;
import setGame.Card;
import setGame.Deck;

public class DeckTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void initDeckWithSizeTest() {
        int deckSize = 34;
        Deck deck = new Deck(deckSize);
        assertEquals(deckSize, deck.getCards().size());
    }

    @Test
    public void initDeckWithRandomSizeTest() {
        int numberOfTests = 10_000;
        for (int k = 0; k < numberOfTests; k++) {
            Deck deck = new Deck();
            assertTrue(deck.getCards().size() >= Deck.MIN_DECK_SIZE && deck.getCards().size() <= Deck.MAX_DECK_SIZE);
        }
    }
}