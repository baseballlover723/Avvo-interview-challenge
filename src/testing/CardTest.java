package testing;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import setGame.Card;
import enums.Color;
import enums.Number;
import enums.Shading;
import enums.Shape;

public class CardTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void initCardTest() {
        Card card = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
        assertEquals(Color.RED, card.getColor());
        assertEquals(Shape.SQUIGGLE, card.getShape());
        assertEquals(Shading.SOLID, card.getShading());
        assertEquals(Number.TWO, card.getNumber());
    }

    @Test
    public void randomCardTest() {
        // this exists to prevent failures if just unlucky
        boolean gotBadLuck = false;
        for (int k = 0; k < 10; k++) {
            HashSet<Card> cards = new HashSet<Card>();
            for (int i = 0; i < 10; i++) {
                cards.add(Card.generateRandomCard());
            }
            // probably unique
            if (cards.size() < 9) {
                if (gotBadLuck) {
                    fail("not sufficiently random");
                }
                gotBadLuck = true;
            }
        }
        // if hasn't failed by here, card is sufficently random
    }
}
