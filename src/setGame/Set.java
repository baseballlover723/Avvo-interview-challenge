package setGame;

import java.util.HashSet;

import enums.Color;

public class Set {
	private Card[] cards;

	public Set(Card card1, Card card2, Card card3) {
		this.cards = new Card[3];
		this.cards[0] = card1;
		this.cards[1] = card2;
		this.cards[2] = card3;
	}
	
	public Card getCard1() {
		return this.cards[0];
	}
 
	public Card getCard2() {
		return this.cards[1];
	}
 
	public Card getCard3() {
		return this.cards[2];
	}
	
	public boolean isValid(){
		return false;
	}
 
}
