package testing;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import enums.Color;
import enums.Number;
import enums.Shading;
import enums.Shape;
import setGame.Board;
import setGame.Card;
import setGame.Deck;
import setGame.Game;
import setGame.Set;

public class GameTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void initGameTest() {
        Game game = new Game();
        assertFalse(game.getDeck().isEmpty());
        assertTrue(game.getBoard().isEmpty());
    }

    @Test
    public void initGameWithDeckTest() {
        Card card1 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);
        Card card2 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
        Card card3 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.THREE);
        Card card4 = new Card(Color.RED, Shape.SQUIGGLE, Shading.EMPTY, Number.ONE);
        Card card5 = new Card(Color.RED, Shape.SQUIGGLE, Shading.STRIPED, Number.ONE);
        Card card6 = new Card(Color.RED, Shape.DIAMOND, Shading.SOLID, Number.ONE);
        Card card7 = new Card(Color.RED, Shape.OVAL, Shading.SOLID, Number.ONE);

        Card[] cards = new Card[] { card1, card2, card3, card4, card5, card6, card7 };
        Deck deck = new Deck(cards);
        Game game = new Game(deck, new Board());
        assertArrayEquals((Object[]) cards, game.getDeck().toArray());
        assertFalse(game.getDeck().isEmpty());
    }

    @Test
    public void initGameWithBoardTest() {
        Card card1 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);
        Card card2 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
        Card card3 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.THREE);
        Card card4 = new Card(Color.RED, Shape.SQUIGGLE, Shading.EMPTY, Number.ONE);
        Card card5 = new Card(Color.RED, Shape.SQUIGGLE, Shading.STRIPED, Number.ONE);
        Card card6 = new Card(Color.RED, Shape.DIAMOND, Shading.SOLID, Number.ONE);
        Card card7 = new Card(Color.RED, Shape.OVAL, Shading.SOLID, Number.ONE);

        Card[] cards = new Card[] { card1, card2, card3, card4, card5, card6, card7 };

        Game game = new Game(new Deck(), new Board(cards));
        assertArrayEquals((Object[]) cards, game.getBoard().toArray());
        assertFalse(game.getDeck().isEmpty());
    }

    @Test
    public void PlaythroughTest1() {
        Card[] cards = new Card[12];
        for (int k = 0; k < 12; k++) {
            cards[k] = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);
        }
        ArrayList<Set> expectedSets = new ArrayList<Set>();
        for (int k = 0; k < 4; k++) {
            Card card = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);
            expectedSets.add(new Set(card, card, card));
        }

        Game game = new Game(new Deck(cards), new Board());
        game.startGame();
        game.playGame();
        ArrayList<Set> sets = game.getFoundSets();

        assertTrue(equalLists(expectedSets,sets));

        fail("Not yet implemented");
    }

    @Test
    public void PlaythroughTest2() {
        Card card1 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);
        Card card2 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);
        Card card3 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);

        Card card4 = new Card(Color.GREEN, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);
        Card card5 = new Card(Color.GREEN, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);
        Card card6 = new Card(Color.GREEN, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);

        Card card7 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
        Card card8 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
        Card card9 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);

        Card card10 = new Card(Color.RED, Shape.SQUIGGLE, Shading.EMPTY, Number.ONE);
        Card card11 = new Card(Color.RED, Shape.SQUIGGLE, Shading.EMPTY, Number.ONE);
        Card card12 = new Card(Color.RED, Shape.SQUIGGLE, Shading.EMPTY, Number.ONE);

        Card[] cards = new Card[] { card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11,
                card12 };
        fail("Not yet implemented");
    }

    @Test
    public void PlaythroughTest3() {
        fail("Not yet implemented");
    }

    // from the internet 
    // http://stackoverflow.com/questions/13501142/java-arraylist-how-can-i-tell-if-two-lists-are-equal-order-not-mattering
    public <T> boolean equalLists(ArrayList<T> expectedSets, ArrayList<T> sets) {
        if (expectedSets == null && sets == null) {
            return true;
        }

        if ((expectedSets == null && sets != null) || expectedSets != null && sets == null || expectedSets.size() != sets.size()) {
            return false;
        }

        // to avoid messing the order of the lists we will use a copy
        // as noted in comments by A. R. S.
        expectedSets = new ArrayList<T>(expectedSets);
        sets = new ArrayList<T>(sets);

        Comparator comparator = new Comparator<Card>() {
            // the actual order doesn't matter, this is just to put it in some
            // sort of consistent order to check equality
            public int compare(Card card1, Card card2) {
                return card1.hashCode() - card2.hashCode();
            }
        };
        Collections.sort(expectedSets, comparator);
        Collections.sort(sets, comparator);
        return expectedSets.equals(sets);
    }

}
