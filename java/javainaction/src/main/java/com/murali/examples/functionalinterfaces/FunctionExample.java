package com.murali.examples.functionalinterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {

	public static void main(String...args){
		List<Integer> counts = 
				map(
						Arrays.asList("Lambbads", "in" , "action"),
						(String s) -> s.length()
				);
		System.out.println("Counts :"+counts);
	}
	
	private static <T,R> List<R> map(List<T> elements, Function<T, R> f){
		List<R> result = new ArrayList<>();
		for(T element : elements){
			result.add(f.apply(element));
		}
		return result;
	}
}
