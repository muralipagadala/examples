package com.murali.examples.beans;

public class Car {
	private int miles;

	public int getMiles() {
		return miles;
	}

	public void drive(int dist) {
		if(dist < 0 ){
			dist = 0;
		}
		miles += dist;
	}
}