package com.murali.examples.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
	private static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
			
	public static void main(String... args) {
		forEach(
			numbers,
			(Integer i) -> System.out.println(i)
		);
		
		//forEach(numbers, (Integer i) -> System.out.println(i));
	}
	
	private static <T> void forEach(List<T> list, Consumer<T> consumer){
		for(T element : list){
			consumer.accept(element);
		}
		//list = null; // Demo of pass by value
	}

}
