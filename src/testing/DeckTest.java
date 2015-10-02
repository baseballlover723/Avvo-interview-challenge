package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;
import enums.Number;
import enums.Shading;
import enums.Shape;
import setGame.Board;
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

    @Test
    public void initDeckWithCardsTest() {
        Card card1 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);
        Card card2 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
        Card card3 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.THREE);
        Card card4 = new Card(Color.RED, Shape.SQUIGGLE, Shading.EMPTY, Number.ONE);
        Card card5 = new Card(Color.RED, Shape.SQUIGGLE, Shading.STRIPED, Number.ONE);

        Card[] cards = new Card[] { card1, card2, card3, card4, card5 };
        Deck deck = new Deck(cards);
        assertArrayEquals((Object[]) cards, deck.getCards().toArray());

    }

}