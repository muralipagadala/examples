package com.murali.examples.methodreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import com.murali.examples.domain.Apple;

public class ConstructorReference {

	public static void main(String[] args) {
		simpleConstructorReference_1();
		constrctorReferenceWithParameters();
	}
	
	private static void simpleConstructorReference_1(){
		Supplier<Apple> supp = () -> new Apple(); 
		Supplier<Apple> supplier = Apple::new; //Constructor reference
		
		Apple a1 = supplier.get();
		Apple a2 = supplier.get();
		if(a1 == a2){
			System.out.println("Both the apples are equal.");
		}
		System.out.println(a1);
	}
	
	private static void constrctorReferenceWithParameters(){
		Function<Integer, Apple> lambdaFunction = (weight) -> new Apple(weight);
		Function<Integer, Apple> appleFunction = Apple::new; //Constructor reference 
		
		Apple apple = appleFunction.apply(10);
		System.out.println(apple);
		
		List<Integer> weights = Arrays.asList(4, 5, 6, 7);
		List<Apple> apples = map(weights, Apple::new);//Constructor reference
		System.out.println("Apples 1. "+apples);
		apples = map(weights, (weight) -> new Apple(weight));
		System.out.println("Apples 2. "+apples);
	}
	
	
	private static List<Apple> map(List<Integer> numbers, Function<Integer, Apple> appleCreator){
		List<Apple> result = new ArrayList<>();
		for(Integer num : numbers){
			result.add(appleCreator.apply(num));
		}
		return result;
	}
}
