package testing;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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
    public void playthroughTest1() {
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

        assertTrue(equalLists(expectedSets, sets));
    }

    @Test
    public void playthroughTest2() {
        ArrayList<Set> expectedSets = new ArrayList<Set>();
        Card card0 = new Card(Color.RED, Shape.DIAMOND, Shading.SOLID, Number.ONE);
        
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

        Card card13 = new Card(Color.RED, Shape.DIAMOND, Shading.EMPTY, Number.TWO);
        Card card14 = new Card(Color.RED, Shape.DIAMOND, Shading.EMPTY, Number.TWO);
        Card card15 = new Card(Color.RED, Shape.DIAMOND, Shading.EMPTY, Number.TWO);

        Card card16 = new Card(Color.GREEN, Shape.OVAL, Shading.SOLID, Number.ONE);
        Card card17 = new Card(Color.GREEN, Shape.OVAL, Shading.SOLID, Number.ONE);
        Card card18 = new Card(Color.GREEN, Shape.OVAL, Shading.SOLID, Number.ONE);
        
        Card card19 = new Card(Color.GREEN, Shape.SQUIGGLE, Shading.EMPTY, Number.ONE);
        Card card20 = new Card(Color.GREEN, Shape.SQUIGGLE, Shading.EMPTY, Number.ONE);

        expectedSets.add(new Set(card1, card2, card3));
        expectedSets.add(new Set(card4, card5, card6));
        expectedSets.add(new Set(card7, card8, card9));
        expectedSets.add(new Set(card10, card11, card12));
        expectedSets.add(new Set(card13, card14, card15));
        expectedSets.add(new Set(card16, card17, card18));

        Card[] cards = new Card[] { card0, card1, card2, card3, card4, card5, card6, card7, card8, card9, card10,
                card11, card12, card13, card14, card15, card16, card17, card18, card19, card20 };

        Collections.shuffle(Arrays.asList(cards));
        Game game = new Game(new Deck(cards), new Board());
        game.startGame();
        game.playGame();
        ArrayList<Set> sets = game.getFoundSets();

        assertTrue(equalLists(expectedSets, sets));
    }

    @Test
    public void playthroughTest3() {
        Card card1 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);
        Card card2 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
        Card card3 = new Card(Color.RED, Shape.DIAMOND, Shading.SOLID, Number.THREE);
        Card card4 = new Card(Color.GREEN, Shape.DIAMOND, Shading.EMPTY, Number.THREE);
        Card card5 = new Card(Color.GREEN, Shape.DIAMOND, Shading.STRIPED, Number.THREE);
        Card card6 = new Card(Color.GREEN, Shape.SQUIGGLE, Shading.EMPTY, Number.ONE);
        Card card7 = new Card(Color.GREEN, Shape.SQUIGGLE, Shading.EMPTY, Number.TWO);
        Card card8 = new Card(Color.PURPLE, Shape.DIAMOND, Shading.SOLID, Number.THREE);
        Card card9 = new Card(Color.GREEN, Shape.DIAMOND, Shading.SOLID, Number.TWO);
        Card card10 = new Card(Color.GREEN, Shape.DIAMOND, Shading.SOLID, Number.ONE);
        Card card11 = new Card(Color.GREEN, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);
        Card card12 = new Card(Color.GREEN, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
        Card card13 = new Card(Color.PURPLE, Shape.OVAL, Shading.EMPTY, Number.THREE);
        Card card14 = new Card(Color.RED, Shape.OVAL, Shading.EMPTY, Number.TWO);
        Card card15 = new Card(Color.RED, Shape.OVAL, Shading.EMPTY, Number.ONE);
        Card card16 = new Card(Color.RED, Shape.SQUIGGLE, Shading.EMPTY, Number.ONE);
        Card card17 = new Card(Color.RED, Shape.SQUIGGLE, Shading.EMPTY, Number.TWO);
        Card card18 = new Card(Color.RED, Shape.OVAL, Shading.SOLID, Number.THREE);
        Card card19 = new Card(Color.GREEN, Shape.OVAL, Shading.SOLID, Number.THREE);
        Card card20 = new Card(Color.RED, Shape.OVAL, Shading.STRIPED, Number.THREE);

        Card[] cards = new Card[] { card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11,
                card12, card13, card14, card15, card16, card17, card18, card19, card20 };
        Game game = new Game(new Deck(cards), new Board());
        game.startGame();
        game.playGame();
        
        assertTrue(game.getFoundSets().isEmpty());
    }

    // from the internet
    // http://stackoverflow.com/questions/13501142/java-arraylist-how-can-i-tell-if-two-lists-are-equal-order-not-mattering
    public <T> boolean equalLists(ArrayList<T> expectedSets, ArrayList<T> sets) {
        if (expectedSets == null && sets == null) {
            return true;
        }

        if ((expectedSets == null && sets != null) || expectedSets != null && sets == null ||
                expectedSets.size() != sets.size()) {
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
