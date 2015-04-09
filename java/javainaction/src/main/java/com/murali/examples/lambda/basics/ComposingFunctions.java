package com.murali.examples.lambda.basics;

import java.util.function.Function;

public class ComposingFunctions {

	public static void main(String...args){
		andExample();
		composeExample();
		customExample_1();
	}
	
	private static void andExample(){
		Function<Integer, Integer> add = x -> x + 1;
		Function<Integer, Integer> multiply = x -> x * 2;
		Function<Integer, Integer> addAndMultiply = add.andThen(multiply);
		int result = addAndMultiply.apply(2);  //equivalent in maths multiply(add(x))
		System.out.println("Result :"+result);
	}
	
	private static void composeExample(){
		Function<Integer, Integer> add = x -> x + 1;
		Function<Integer, Integer> multiply = x -> x * 2;
		Function<Integer, Integer> addAndMultiply = add.compose(multiply);
		int result = addAndMultiply.apply(2);  //equivalent in maths add(multiply(x))
		System.out.println("Result :"+result);
	}
	
	private static void customExample_1(){
		Function<String, String> addHeader = Letter::addHeader;
		Function<String, String> transformationPipeLine =
				addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);
		System.out.println(transformationPipeLine.apply("Java 8 examples of labda"));
	}
	
	private static void customExample_2(){
		Function<String, String> addHeader = Letter::addHeader;
		Function<String, String> transformationPipleLine = addHeader.andThen(Letter::addFooter);
	}
}
