package setGame;

import java.util.Random;

import enums.Color;
import enums.Number;
import enums.Shading;
import enums.Shape;

public class Card {
    private Color color;
    private Shape shape;
    private Shading shading;
    private Number number;

    public Card(Color color, Shape shape, Shading shading, Number number) {
        this.color = color;
        this.shape = shape;
        this.shading = shading;
        this.number = number;
    }

    public Color getColor() {
        return this.color;
    }

    public Shape getShape() {
        return this.shape;
    }

    public Shading getShading() {
        return this.shading;
    }

    public Number getNumber() {
        return this.number;
    }

    public static Card generateRandomCard() {
        Random random = new Random();
        Color randomColor = Color.values()[random.nextInt(Color.values().length)];
        // System.out.println(randomColor);
        return new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != Card.class) {
            return false;
        }
        Card otherCard = (Card) other;
        return this.color == otherCard.getColor() && this.shape == otherCard.getShape() &&
                this.shading == otherCard.getShading() && this.number == otherCard.getNumber();
    }

    @Override
    public int hashCode() {
        return this.color.hashCode() + this.shape.hashCode() + this.shading.hashCode() + this.number.hashCode();
    }
}
