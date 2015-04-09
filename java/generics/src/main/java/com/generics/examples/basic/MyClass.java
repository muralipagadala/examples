package com.generics.examples.basic;

public class MyClass<X> {

	public <T> MyClass(T t) {

	}

	public static void main(String... args) {
		MyClass<Integer> mc = new MyClass<Integer>("Murali");
	}
}