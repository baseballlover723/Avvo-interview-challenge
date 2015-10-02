package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import enums.Color;
import enums.Number;
import enums.Shading;
import enums.Shape;
import setGame.Board;
import setGame.Card;
import setGame.Deck;

public class BoardTest {

    @Test
    public void hasSetRevealedTest() {
        Card card1 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);
        Card card2 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
        Card card3 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.THREE);
        Card card4 = new Card(Color.RED, Shape.SQUIGGLE, Shading.EMPTY, Number.ONE);
        Card card5 = new Card(Color.RED, Shape.SQUIGGLE, Shading.STRIPED, Number.ONE);

        Board board = new Board(new Card[] { card1, card2, card3, card4, card5 });
        assertTrue(board.hasSetRevealed());
    }

    @Test
    public void hasNoSetRevealedTest() {
        Card card1 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);
        Card card3 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.THREE);
        Card card4 = new Card(Color.RED, Shape.SQUIGGLE, Shading.EMPTY, Number.ONE);
        Card card10 = new Card(Color.GREEN, Shape.DIAMOND, Shading.EMPTY, Number.TWO);

        Board board = new Board(new Card[] { card1, card3, card4, card10 });
        assertFalse(board.hasSetRevealed());

        board = new Board(new Card[] { card1, card3 });
        assertFalse(board.hasSetRevealed());
    }
}
