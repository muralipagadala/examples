package com.generics.examples.bounded;

public class Circle extends Shape implements Drawable {

	public String getName() {
		return this.getClass().getName();
	}

	public void draw() {
		System.out.println("Drawing Circle");
	}

}