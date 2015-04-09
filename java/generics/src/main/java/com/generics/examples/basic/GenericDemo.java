package com.generics.examples.basic;

public class GenericDemo {

	public static void main(String... args) {
		Generic<Integer> intGen = new Generic<Integer>(40);
		System.out.println(intGen.getType() + " --> " + intGen.getObject());

		Generic<String> strGen = new Generic<String>("40");
		System.out.println(strGen.getType() + " --> " + strGen.getObject());

	}
}