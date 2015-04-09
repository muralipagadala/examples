package com.murali.examples.lambda.basics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.murali.examples.domain.Apple;

public class ComposingPredicates {

	private static List<Apple> inventory = Arrays.asList(new Apple(1, 80, "green"),
			new Apple(2, 155, "green"), new Apple(3, 120, "red"));

	public static void main(String... args) {
		TriFunction<Apple, Integer, Integer, String> redAppleCreator = Apple::new;
		Apple apple = redAppleCreator.apply(2,  120, "red");
		
		Predicate<Apple> redApple = a -> "red".equalsIgnoreCase(a.getColor());
		Predicate<Apple> greenApple = a -> "green".equalsIgnoreCase(a.getColor());
		Predicate<Apple> notRedApple = redApple.negate();
		Predicate<Apple> redAndHeavyWeightApple = redApple.and(a -> a.getWeight() > 150);
		Predicate<Apple> redAndHeavyWeightOrGreenApple = redAndHeavyWeightApple.or(greenApple);
		
	}
}
