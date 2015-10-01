package setGame;

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

}
