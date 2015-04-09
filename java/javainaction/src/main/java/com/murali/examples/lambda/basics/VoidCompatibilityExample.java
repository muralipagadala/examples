package com.murali.examples.lambda.basics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class VoidCompatibilityExample {

	public static void main(String...args){
		List<String> titles = Arrays.asList("Lambbads", "in" , "action");
		
		/**
		 * If a lambda has a statement expression as its body, it's compatible with a function descriptor
		 * that returns void ( provided the parameter list is compatible too).
		 * 
		 * For example, both of the following lines are legal even though the method add of a List returns a boolean 
		 * and not void as expected in the Consumer context ( T -> void )
		 */
		Predicate<String> p = s -> titles.add("Java");
		Consumer<String> c = s -> titles.add("Groovy");
	}
}
