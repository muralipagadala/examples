package com.generics.examples.basic;

import java.util.List;

public class Util {

	public static <K, V> boolean compare(Pair<K, V> pair_1, Pair<K, V> pair_2) {
		return (pair_1.getKey().equals(pair_2.getKey()) && pair_1.getValue()
				.equals(pair_2.getValue()));
	}

	public static <T extends Comparable<T>> int countGreaterThan(T[] array,
			T element) {
		int count = 0;
		for (T e : array) {
			if (e.compareTo(element) > 0) {
				++count;
			}
		}
		return count;
	}

	public static void print(List<?> list) {
		for (Object obj : list) {
			System.out.println(obj.toString());
		}
	}
}
