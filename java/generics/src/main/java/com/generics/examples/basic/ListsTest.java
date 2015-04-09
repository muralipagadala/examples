package com.generics.examples.basic;

import java.io.Serializable;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import com.generics.examples.basic.Lists;

public class ListsTest {

	@Test
	public void testToList_1() {
		List<Integer> ints = Lists.<Integer> toList(1, 2, 3);
		assertTrue(ints.contains(1));
	}

	@Test
	public void testExplicitParameters() {
		// List<Serializable> sList = Lists.<Serializable>toList("x", "y", 1);
		// //Valid
		List<Comparable> sList = Lists.<Comparable> toList("x", "y", 1); // Valid
		// List<Object> sList = Lists.<Object>toList("x", "y", 1); //Valid
		assertTrue(sList.contains("x"));
	}

	@Test
	public void testAddAll() {
		List<Integer> ints_1 = Lists.toList(1, 2, 3);
		Integer[] ints_2 = new Integer[] { 4, 5, 6 };
		// List<Integer> ints_3 = Lists.addAll(ints_1, ints_2);
		List<Integer> ints_3 = Lists.addAll(ints_1, 4, 5, 6);
		assertTrue(ints_3.contains(6));
	}
}