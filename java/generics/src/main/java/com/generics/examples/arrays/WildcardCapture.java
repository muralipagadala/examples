package com.generics.examples.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardCapture {
	public static void main(String... args) {
		List<String> names = Arrays.asList("Murali", "Pagadala", "Cigna");
		reverse(names);
		for (String name : names) {
			System.out.println(name);
		}
	}

	private static <T> void rev(List<T> list) {
		List<T> tempList = new ArrayList<T>(list);
		for (int i = 0; i < tempList.size(); i++) {
			list.set(i, tempList.get(list.size() - i - 1));
		}
	}

	public static void reverse(List<?> list) {
		rev(list);
	}
}