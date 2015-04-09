package com.murali.examples.datatypes;

public class TypeCheckDemo {

	public static void main(String...args){
		Integer number = (Integer) getNumber();
		System.out.println("Number :"+number);
	}
	
	private static Object getNumber(){
		return new Integer(20);
	}
}
