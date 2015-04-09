package com.murali.examples.lambda.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.murali.examples.domain.Apple;

public class FilteringApples {

	private static List<Apple> inventory = Arrays.asList(new Apple(1, 80, "green"),
			new Apple(2, 155, "green"), new Apple(3, 120, "red"));
	public static void main(String... args) {
		findGreenApplesIn4DifferentWays();
		System.out.println("\n\n");
		findHeavyApplesIn4DifferentWays();
		System.out.println("\n\n");
		findWeirdApples();
		System.out.println("\n\n");
		findGreenHeavyApples();
		
		inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
		
		
		
	}
	
	private static void sortApples(){
		Comparator<Apple> appleComparator = new Comparator<Apple>(){
			@Override
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		};
		
		Collections.sort(inventory,  new Comparator<Apple>(){
			@Override
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});
	}
	
	private static void findGreenApplesIn4DifferentWays(){
		List<Apple> greenApples = 
				inventory.stream().filter(apple -> isGreenApple(apple)).collect(Collectors.toList());
		System.out.println("1.Green Apples :"+greenApples);
		
		greenApples = 
				inventory.stream().filter(FilteringApples::isGreenApple).collect(Collectors.toList());
		System.out.println("2.Green Apples :"+greenApples);
		
		greenApples = filterApples(inventory, FilteringApples::isGreenApple);
		System.out.println("3.Green Apples :"+greenApples);
		
		greenApples = filterApples(inventory, (Apple apple) -> "green".equalsIgnoreCase(apple.getColor()));
		System.out.println("4.Green Apples :"+greenApples);
	}
	
	private static void findHeavyApplesIn4DifferentWays(){
		List<Apple> heavyApples = 
				inventory.stream().filter(apple -> isHeavyApple(apple)).collect(Collectors.toList());
		System.out.println("1.Heavy Apples :"+heavyApples);
		
		heavyApples = 
				inventory.stream().filter(FilteringApples::isHeavyApple).collect(Collectors.toList());
		System.out.println("2.Heavy Apples :"+heavyApples);
		
		heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
		System.out.println("3.Heavy Apples :"+heavyApples);
		
		heavyApples = filterApples(inventory, (Apple apple) -> apple.getWeight() > 150);
		System.out.println("4.Heavy Apples :"+heavyApples);
	}
	
	private static void findWeirdApples(){
		List<Apple> weirdApples = filterApples( inventory, 
				(Apple apple) -> apple.getWeight() < 80 || "brown".equals(apple.getColor()));
		System.out.println("Weird Apples :"+weirdApples);
	}
	
	private static void findGreenHeavyApples(){
		List<Apple> greenAndHeavyApples = filterApples( inventory, 
				(Apple apple) -> "green".equalsIgnoreCase(apple.getColor()) && apple.getWeight() > 150);
		System.out.println("1.Green and Heavy Apples :"+greenAndHeavyApples);
		
		//How can I achieve this
		/*greenAndHeavyApples = filterApples( inventory, (FilteringApples::isGreenApple && FilteringApples::isHeavyApple));
		System.out.println("2.Green and Heavy Apples :"+greenAndHeavyApples);*/
		
		greenAndHeavyApples = filterApples( inventory, FilteringApples::isGreenApple,FilteringApples::isHeavyApple);
		System.out.println("2.Green and Heavy Apples :"+greenAndHeavyApples);
	}
	
	private static List<Apple> filterApples_old(List<Apple> apples, Predicate<Apple> predicate){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : apples){
			if(predicate.test(apple)){
				result.add(apple);
			}
		}
		return result;
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
	
	private static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> predicate, Predicate<Apple> predicate2){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : apples){
			if(predicate.test(apple) && predicate2.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}
	
	
	
	private static boolean isGreenApple(Apple apple){
		return "green".equalsIgnoreCase(apple.getColor());
	}
	
	public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

}
