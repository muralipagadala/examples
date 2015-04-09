package com.generics.examples.basic;

public class DynamicBox<T> {//implements Box<T> {
	T element;

	public T get() {
		return element;
	}

	public void put(T element) {
		this.element = element;
	}

}
