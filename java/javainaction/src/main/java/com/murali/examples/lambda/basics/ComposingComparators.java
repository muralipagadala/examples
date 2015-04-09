package com.murali.examples.lambda.basics;

import static java.util.Comparator.comparing;
import java.util.Arrays;
import java.util.List;

import com.murali.examples.domain.Apple;

public class ComposingComparators {
	private static List<Apple> inventory = Arrays.asList(new Apple(1, 80, "green"),
			new Apple(2, 155, "green"), new Apple(3, 120, "red"));

	public static void main(String... args) {
		chainingComparator();
		//reverseComparator();
	}
	
	
	private static void reverseComparator(){
		inventory.sort(comparing(Apple::getWeight));
		System.out.println("Sorted Apples :"+inventory);
		inventory.sort(comparing(Apple::getWeight).reversed());
		System.out.println("Reversed Sorted Apples :"+inventory);
	}
	
	private static void chainingComparator(){
		inventory.sort(comparing(Apple::getWeight).thenComparing(Apple::getId).thenComparing(Apple::getColor));
		System.out.println("Sorted Apples :"+inventory);
	}
}

