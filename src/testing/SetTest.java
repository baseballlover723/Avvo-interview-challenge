package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import setGame.Card;
import setGame.Set;
import enums.Color;
import enums.Number;
import enums.Shading;
import enums.Shape;

public class SetTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void initSetTest() {
		Card card1 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
		Card card2 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
		Card card3 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);

		set = new Set(card1, card2, card3);
		assertEquals(card1, set.getFirstCard());
		assertEquals(card2, set.getSecondCard());
		assertEquals(card3, set.getThirdCard());
	}

}
