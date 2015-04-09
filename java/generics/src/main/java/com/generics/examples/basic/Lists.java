package com.generics.examples.basic;

import java.util.ArrayList;
import java.util.List;

public class Lists {
	public static <T> List<T> toList(T... array) {
		List<T> newList = new ArrayList<T>();
		for (T item : array) {
			newList.add(item);
		}
		return newList;
	}

	/*
	 * public static List toList(Object... array){ List objectList = new
	 * ArrayList(); for(Object obj : array){ objectList.add(obj); } return
	 * objectList; }
	 */

	public static <T> List<T> addAll(List<T> list, T... elements) {
		for (T element : elements) {
			list.add(element);
		}
		return list;
	}
}