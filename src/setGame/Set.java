package setGame;

import java.util.HashSet;

import enums.Color;
import enums.Number;
import enums.Shading;
import enums.Shape;

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

    public boolean isValid() {
        HashSet<Color> colors = new HashSet<Color>();
        HashSet<Shape> shapes = new HashSet<Shape>();
        HashSet<Shading> shadings = new HashSet<Shading>();
        HashSet<Number> numbers = new HashSet<Number>();
        for (Card card : this.cards) {
            colors.add(card.getColor());
            shapes.add(card.getShape());
            shadings.add(card.getShading());
            numbers.add(card.getNumber());
        }
        
        // if any of these sets have 2 elements then they must have 2 of one
        // attribute and 1 of another and is hence not a set
        boolean hasSize2 = colors.size() == 2 || shapes.size() == 2 || shadings.size() == 2 || numbers.size() == 2;
        return !hasSize2;
    }

}
