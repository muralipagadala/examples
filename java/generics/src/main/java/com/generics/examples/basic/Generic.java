package com.generics.examples.basic;

public class Generic<T> {

	private T object;

	public Generic(T object) {
		this.object = object;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public String getType() {
		return this.object.getClass().getName();
	}

}
