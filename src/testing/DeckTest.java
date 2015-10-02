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
        assertEquals(deckSize, deck.getRemainingCards().size());
    }

    @Test
    public void initDeckWithRandomSizeTest() {
        int numberOfTests = 10_000;
        for (int k = 0; k < numberOfTests; k++) {
            Deck deck = new Deck();
            assertTrue(deck.getRemainingCards().size() >= Deck.MIN_DECK_SIZE &&
                    deck.getRemainingCards().size() <= Deck.MAX_DECK_SIZE);
        }
    }

    @Test
    public void hasSetRevealedTest() {
        Card card1 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);
        Card card2 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
        Card card3 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.THREE);
        Card card4 = new Card(Color.RED, Shape.SQUIGGLE, Shading.EMPTY, Number.ONE);
        Card card5 = new Card(Color.RED, Shape.SQUIGGLE, Shading.STRIPED, Number.ONE);

        Deck deck = new Deck(new Card[]{card1, card2, card3, card4, card5});
        assertTrue(deck.hasSetRevealed());
    }
    @Test
    public void hasNoSetRevealedTest() {
        Card card1 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);
        Card card3 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.THREE);
        Card card4 = new Card(Color.RED, Shape.SQUIGGLE, Shading.EMPTY, Number.ONE);
        Card card10 = new Card(Color.GREEN, Shape.DIAMOND, Shading.EMPTY, Number.TWO);

        Deck deck = new Deck(new Card[]{card1, card3, card4, card10});
        assertFalse(deck.hasSetRevealed());
    }
}