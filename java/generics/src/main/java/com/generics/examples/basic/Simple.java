package com.generics.examples.basic;

import static java.lang.System.out;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Simple {
	public static void main(String args[]) {
		List<Integer> ints = Arrays.asList(100, 200, 300);
		Integer i = 200;
		Integer j = 200;
		// assert i == j;

		List<Serializable> intList = Lists.<Serializable> toList(1, "Murali");
		out.println(intList);
	}

	public static Integer sumInteger(List<Integer> ints) {
		Integer s = 0;
		for (int n : ints) {
			s += n;
		}
		return s;
	}

	public static int sum(List<Integer> ints) {
		int s = 0;
		for (int n : ints) {
			s += n;
		}
		return s;
	}

}