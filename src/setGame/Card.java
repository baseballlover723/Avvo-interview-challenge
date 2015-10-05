package setGame;

import java.util.Random;

import enums.Color;
import enums.Number;
import enums.Shading;
import enums.Shape;

public class Card implements Comparable<Card>{
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
        Shape randomShape = Shape.values()[random.nextInt(Shape.values().length)];
        Shading randomShading = Shading.values()[random.nextInt(Shading.values().length)];
        Number randomNumber = Number.values()[random.nextInt(Number.values().length)];
        return new Card(randomColor, randomShape, randomShading, randomNumber);
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
    
    @Override
    public String toString() {
        return "[" + this.color + ", " + this.shape + ", " + this.shading + ", " + this.number + "]";
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.hashCode(), other.hashCode());
    }

}
