package com.murali.examples.functionalinterfaces;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PrimitiveExample {

	public static void main(String...args){
		IntPredicate evenNumbers = (int i) -> i % 2 == 0;
		System.out.println("No autoboxing : "+evenNumbers.test(1000));
		
		Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 1;
		System.out.println("Autoboxing : "+oddNumbers.test(1000));
	}
}
