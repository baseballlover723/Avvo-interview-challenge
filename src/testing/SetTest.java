package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import enums.Color;
import enums.Number;
import enums.Shading;
import enums.Shape;
import setGame.Card;
import setGame.Set;

public class SetTest {

	private ArrayList<Set> validSets;
	private ArrayList<Set> invalidSets;

	@Before
	public void setUp() throws Exception {
		this.validSets = new ArrayList<Set>();
		this.invalidSets = new ArrayList<Set>();

		Card card1 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);
		Card card2 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
		Card card3 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.THREE);

		Card card4 = new Card(Color.RED, Shape.SQUIGGLE, Shading.EMPTY, Number.ONE);
		Card card5 = new Card(Color.RED, Shape.SQUIGGLE, Shading.STRIPED, Number.ONE);

		Card card6 = new Card(Color.RED, Shape.DIAMOND, Shading.SOLID, Number.ONE);
		Card card7 = new Card(Color.RED, Shape.OVAL, Shading.SOLID, Number.ONE);

		Card card8 = new Card(Color.GREEN, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);
		Card card9 = new Card(Color.PURPLE, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);

		Card card10 = new Card(Color.GREEN, Shape.DIAMOND, Shading.EMPTY, Number.TWO);
		Card card11 = new Card(Color.PURPLE, Shape.OVAL, Shading.STRIPED, Number.THREE);

		Card card12 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
		Card card13 = new Card(Color.GREEN, Shape.DIAMOND, Shading.SOLID, Number.ONE);
		Card card14 = new Card(Color.PURPLE, Shape.OVAL, Shading.SOLID, Number.THREE);

		Card card15 = new Card(Color.GREEN, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);

		this.validSets.add(new Set(card1, card1, card1));
		this.validSets.add(new Set(card1, card2, card3));
		this.validSets.add(new Set(card1, card4, card5));
		this.validSets.add(new Set(card1, card6, card7));
		this.validSets.add(new Set(card1, card8, card9));
		this.validSets.add(new Set(card1, card10, card11));
		this.validSets.add(new Set(card12, card13, card14));

		this.invalidSets.add(new Set(card1, card2, card10));
		this.invalidSets.add(new Set(card1, card2, card4));
		this.invalidSets.add(new Set(card1, card2, card6));
		this.invalidSets.add(new Set(card1, card2, card8));
		this.invalidSets.add(new Set(card12, card13, card15));
	}

	@Test
	public void initSetTest() {
		Card card1 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
		Card card2 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
		Card card3 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);

		Set set = new Set(card1, card2, card3);
		assertEquals(card1, set.getCard1());
		assertEquals(card2, set.getCard2());
		assertEquals(card3, set.getCard3());
		assertFalse(set.isValid());
	}

	@Test
	public void validSetTest() {
		for (Set set : this.validSets) {
			assertTrue(set.isValid());
		}
	}

	@Test
	public void invalidSetTest() {
		for (Set set : this.invalidSets) {
			assertFalse(set.isValid());
		}
	}
}
