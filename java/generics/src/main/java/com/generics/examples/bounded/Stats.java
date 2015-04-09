package com.generics.examples.bounded;

public class Stats<T extends Number> {

	T[] array;

	public Stats(T[] array) {
		this.array = array;
	}

	public T[] get() {
		return this.array;
	}

	public boolean sameSum(Stats<?> obj) {
		if (getSum() == obj.getSum()) {
			return true;
		}
		return false;
	}

	public double getSum() {
		double average = 0;
		for (int i = 0; i < array.length; i++) {
			average += array[i].doubleValue();
		}
		return average;
	}
}
