package com.generics.examples.bounded;


public class DrawTest {

	public static void main(String... args) {
		Shape c = new Circle();
		Draw<Shape> circle = new Draw<Shape>(c);
		circle.doDraw();
	}
}