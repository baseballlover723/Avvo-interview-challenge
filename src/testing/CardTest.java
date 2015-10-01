package testing;

import static org.junit.Assert.*;

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
}
