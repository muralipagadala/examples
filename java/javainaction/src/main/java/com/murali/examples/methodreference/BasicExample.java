package com.murali.examples.methodreference;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

import com.murali.examples.domain.Apple;

public class BasicExample {
	private static List<Apple> inventory = Arrays.asList(new Apple(1, 80, "green"),
			new Apple(2, 155, "green"), new Apple(3, 120, "red"));
	public static void main(String[] args) {
	
		
		//Thread.currentThread()::dumpStack
		//String::substring
		//System.out::println
		
		instanceMethodReferenceExample_1();
		instanceMethodReferenceExample_2();
		
		//Quiz : what are equivalent method references for the following lambda expressions.
		Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
		//Ans
		stringToInteger = Integer::parseInt;
		BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
		contains = List::contains;
		
		
	}
	
	
	private static void instanceMethodReferenceExample_1(){
		List<String> str = Arrays.asList("a","b","A","B");
		//Here the lambda expression has a signature compatible with the function descriptor of Comparator.
		str.sort((s1, s2)-> s1.compareToIgnoreCase(s2));
		System.out.println("Sorted Strings :"+str);
		
		//Method reference
		str.sort(String::compareToIgnoreCase);
		System.out.println("Sorted Strings with method reference :"+str);
	}
	
	private static void instanceMethodReferenceExample_2(){
		//Here the lambda expression has signature compatible with the function descriptor of Comparator
		inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
		
		//Method reference
		inventory.sort(comparing(Apple::getWeight));
		System.out.println("Sorted apples :"+inventory);
	}
}
