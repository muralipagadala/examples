package com.murali.examples.lambda.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import com.murali.examples.domain.Apple;

public class TypeInferenceExample {
	
	private static List<Apple> inventory = Arrays.asList(new Apple(1, 80, "green"),
			new Apple(2, 155, "green"), new Apple(3, 120, "red"));

	public static void main(String...args){
		List<Apple> greenApples = 
				filterApples(inventory, (Apple apple) -> "green".equalsIgnoreCase(apple.getColor()));
		
		/**
		 * Type inference from target type which Apple here. 
		 * Java compiler deduces this information from method context, or variable, or parameters or return type.
		 */
		greenApples = filterApples(inventory, a -> "green".equals(a.getColor()));
		
		
		Comparator<Apple> appleComparator = 
				(Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
		
		//Type Inference
		appleComparator = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());
	}
	
	private static <T> List<T> filterApples(List<T> elements, Predicate<T> predicate){
		List<T> result = new ArrayList<>();
		for(T element : elements){
			if(predicate.test(element)){
				result.add(element);
			}
		}
		return result;
	}
}
