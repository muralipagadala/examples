package com.murali.examples.domain;

public class Apple {
	private int weight = 0;
	private String color = "";
	private int id;

	public Apple(int id, int weight, String color) {
		this.id = id;
		this.weight = weight;
		this.color = color;
	}
	
	public Apple(){
		
	}
	
	public Apple(int id){
		this.id = id;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void eat(){
		System.out.println("eating apple");
	}

	@Override
	public String toString() {
		return "Apple [weight=" + weight + ", color=" + color + ", id="
				+ id + "]";
	}

}