package setGame;

public class Set {

	private Card card1;
	private Card card2;
	private Card card3;

	public Set(Card card1, Card card2, Card card3) {
		this.card1 = card1;
		this.card2 = card2;
		this.card3 = card3;
	}
	
	public Card getCard1() {
		return this.card1;
	}
 
	public Card getCard2() {
		return this.card2;
	}
 
	public Card getCard3() {
		return this.card3;
	}
	
	public boolean isValid(){
		return false;
	}
 
}
