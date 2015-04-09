package com.generics.examples.wildcard.bounded;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Collection;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class WildCardCaptureTest {

	/**
	 * its not legal to write from the copy back into the original, bcz we are
	 * trying to write from a list of objects into a list of unknow type.
	 * 
	 * @param list
	 */
	public void reverse_1(List<?> list) {
		/*
		 * List<Object> tempList = new ArrayList<Object>(list); for(int i = 0; i
		 * < list.size(); i++){ list.set(i, tempList.get(list.size()-i-1));
		 * //COMPILE ERROR }
		 */
		reverse_2(list);
	}

	/**
	 * Here we say that the Type variable 'T' has captured the wild card.
	 * 
	 * @param list
	 */
	public <T> void reverse_2(List<T> list) {
		List<T> tempList = new ArrayList<T>();
		for (int i = 0; i < list.size(); i++) {
			list.set(i, tempList.get(list.size() - i - 1));
		}

	}

	/**
	 * Wild cards may not appear at the top level in class instance create
	 * expressions (new) In explicit parameters in generic method calls or in
	 * super types.
	 */

	@Test
	public void testWildCardCreationWhileCreatingInstance_1() {
		/**
		 * Why following restriction
		 *
		 * Java designers had in mind that every wildcard type is short hand for
		 * some ordinary type, so they believed that ultimately every object is
		 * created with an ordinary type.
		 *
		 *
		 */
		// List<?> list = new ArrayList<?>();
		List<?> list_1 = new ArrayList<Object>();
		List<?> list_2 = new ArrayList<Integer>();
	}

	@Test
	public void testWildCardCreationWhileCreatingInstance_2() {
		List<List<?>> list = new ArrayList<List<?>>();
		list.add(Arrays.asList(1, 2, 3));
		list.add(Arrays.asList("one", "two", "three"));
		assertEquals(list.size(), 2);
	}

	/**
	 * GENERIC METHOD CALLS : If a generic method call includes explicit type
	 * parameters. those type parameters must not be wild cards.
	 */

	public static <T> List<T> factory() {
		return new ArrayList<T>();
	}

	@Test
	public void testWildCardCreationInGenericMethods_1() {

	}

	/**
	 * SUPER TYPES : When a class instance is created, it invokes the
	 * initializer for its supertype. Hence any restriction that applies to
	 * instance creation must also applies to supertypes. In a class declaration
	 * if the supertype or super interface has type parameters these types must
	 * not be wild cards.
	 *
	 */
	@Test
	public void testWildCardCreationInSuperTypes() {
		// class AnyList extends ArrayList<?> //compile-error
		// class AnyList implements List<?> // compile-error

		// class AnayList extends ArrayList<List<?>> //Valid
	}
}