package com.generics.examples.arrays;

public class ArrayDemo {
	public static void main(String... args) {
		Integer[] intArray = { 1, 2, 3 };
		Number[] numArray = intArray;
		numArray[0] = 20;
		for (Number n : numArray) {
			System.out.println("Number : " + n);
		}

		numArray[2] = 3.42;

		for (Number n : numArray) {
			System.out.println("Number : " + n);
		}
	}
}
