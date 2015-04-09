package com.generics.examples.wildcard.bounded;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Collection;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class SubstituitionPrincipleTest {

	@Test
	public void testSubstitution_1() {

		List<Number> nums = new ArrayList<Number>();
		nums.add(20);
		nums.add(2.12);

		assertEquals(nums.toString(), "[20, 2.12]");
	}

	/**
	 * Following method will not compile bcz List<Integer> is not a subtype of
	 * List<Number>. Substitution principle do not work here.
	 */
	@Test
	public void testSubstitution_2() {
		List<Integer> ints = Arrays.asList(1, 2, 3);
		// List<Number> nums = ints; //COMPILE ERROR : Type mismatch : cannot
		// convert from List<Integer> to List<Number>
		List<Integer> nums = ints; // Allowed
	}

	@Test
	public void testSubstitution_3() {
		List<Number> nums = new ArrayList<Number>();
		List<Integer> ints = Arrays.asList(1, 2, 3);
		List<Double> doubles = Arrays.asList(1.0, 2.0, 3.0);
		nums.addAll(ints);
		nums.addAll(doubles);

		assertEquals(nums.toString(), "[1, 2, 3, 1.0, 2.0, 3.0]");
	}

	@Test
	public void testSubstitution_4() {
		List<Integer> ints = Arrays.asList(1, 2, 3);
		List<? extends Number> nums = ints;
		// nums.add(2.14); //Compile error : we cannot add a double to a List<?
		// extends Number> since it might be a list of some other type of Number
	}

	@Test
	public void testWildCardSuper() {
		List<Object> objList = Arrays.<Object> asList(1, 2, "Four");
		List<Integer> ints = Arrays.asList(5, 4);

		Collections.copy(objList, ints);
		assertEquals(objList.toString(), "[5, 4, Four]");
	}

	@Test
	public void testStrictType() {
		List<Integer> objList = Arrays.<Integer> asList(1, 2);
		List<Integer> ints = Arrays.asList(5, 4);
		copy(objList, ints);
		assertEquals(objList.toString(), "[5, 4]");
	}

	@Test
	public void testGetPrinciple() {
		List<Integer> ints = Arrays.asList(1, 2, 3);
		assertEquals(6.0, sum(ints));
	}

	@Test
	public void testPutPrinciple() {
		List<Integer> ints = new ArrayList<Integer>();
		add(ints, 10);
		assertEquals(ints.size(), 10);
	}

	// We can only put Null into a structure with <? extends T>
	@Test
	public void testPutWithNull() {
		List<Integer> ints = new ArrayList<Integer>();
		List<? extends Number> nums = ints;
		nums.add(null);
		assertEquals(nums.toString(), "[null]");
	}

	// We can only get an Object from <? super T>

	@Test
	public void testGetWithObjects() {
		List<Object> objs = Arrays.<Object> asList(1, 2, "Three");
		List<? super Integer> ints = objs;
		String s = "";
		for (Object obj : ints) {
			s += obj;
		}

		assertEquals(s, "12Three");
	}

	@Test
	public void testContainsAll_1() {
		Object obj = "one";
		List<Object> objList = Arrays.<Object> asList(1, 2, 3, "one");
		List<Integer> intList = Arrays.<Integer> asList(1, 2);

		assertTrue(objList.contains(obj));
		assertTrue(objList.containsAll(intList));
	}

	@Test
	public void testContainsAll_2() {
		Object obj = 1; // KEY to observe
		List<Object> objList = Arrays.<Object> asList(1, 2, 3, "one");
		List<Integer> intList = Arrays.<Integer> asList(1, 2);

		assertTrue(objList.contains(obj));
		assertTrue(objList.containsAll(intList));
	}

	/**
	 * Use 'extends' whenever you want to get the values from a structur. For
	 * example, iterator
	 *
	 */
	public static double sum(Collection<? extends Number> values) {
		double sum = 0.0;
		for (Number num : values) {
			sum += num.doubleValue();
		}
		return sum;
	}

	/**
	 * User 'super' keyword whenever you want to put the values into a
	 * structure.
	 *
	 */
	public static void add(Collection<? super Integer> values, int n) {
		for (int i = 0; i < n; i++) {
			values.add(i);
		}
	}

	// Do not use wildcards when you want to both put and get

	/**
	 * This method is too restrictive. It can only permits call when both
	 * destination and source are have exactly the same type.
	 *
	 */
	/*
	 * public <T> void copy(List<T> dest, List<T> src){ for(int i = 0; i <
	 * src.size(); i++){ dest.set(i, src.get(i)); } }
	 * 
	 * public <T> void copy( List<T> dest, List<? extends T> src){ for(int i =
	 * 0; i < src.size(); i++){ dest.set(i, src.get(i)); } }
	 */

	public <T> void copy(List<? super T> dest, List<T> src) {
		for (int i = 0; i < src.size(); i++) {
			dest.set(i, src.get(i));
		}
	}

	/**
	 * Use 'extends' keyword when you want to get the values from a structure
	 * Use 'super' keyword when you want to put the values into a structure Do
	 * not use wild cards when you want to put and get the values
	 *
	 * public static <T> void copy(List<? super T> dest, List<? extends T> src);
	 */
}
