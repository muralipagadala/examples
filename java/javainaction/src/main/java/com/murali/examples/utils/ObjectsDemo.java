package com.murali.examples.utils;

import java.util.Objects;

import com.murali.examples.domain.Apple;

public class ObjectsDemo {

	private static Apple apple;
	
	public static void main(String...args){
		Apple apple = null;
		setApple(apple);
	}
	
	
	private static void setApple(Apple app){
		apple = Objects.requireNonNull(app, "Apple must not be null.");
	}
}
