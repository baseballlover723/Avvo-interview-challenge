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
import setGame.Game;

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
        fail("Not yet implemented");
    }

    @Test
    public void PlaythroughTest2() {
        fail("Not yet implemented");
    }

    @Test
    public void PlaythroughTest3() {
        fail("Not yet implemented");
    }

}
