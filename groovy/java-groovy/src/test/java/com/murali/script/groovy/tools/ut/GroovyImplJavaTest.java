package com.murali.script.groovy.tools.ut;

import static org.testng.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroovyImplJavaTest {

	private UtilityMethods impl;
	
	@BeforeClass
	public void setUp(){
		impl = new GroovyUtilityMethods();
	}
	
	@Test
	public void testGetPositives() {
		int[] testValues = { -3, 1, 4, -1, 5, -2, 6 };
		List<Integer> testList = new ArrayList<Integer>();
		testList.add(1);
		testList.add(4);
		testList.add(5);
		testList.add(6);
		int[] results = impl.getPositives(testValues);
		for (int i : results) {
			assertTrue(testList.contains(i));
		}
	}
	
	@Test
	public void testIsPrime() {
		int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
		for (int p : primes) {
			assertTrue(impl.isPrime(p));
		}
		assertFalse(impl.isPrime(9), "9 is not prime");
	}
	
	@Test(expectedExceptions = { IllegalArgumentException.class })
	public void testNegativePrime() {
		impl.isPrime(-3);
	}
	
	@Test
	public void testIsPalindrome() {
		assertTrue(impl.isPalindrome("Step on no pets!"));
		assertTrue(impl.isPalindrome("Lisa Bonet ate no basil"));
		assertTrue(impl.isPalindrome("Are we not drawn onward, we few, drawn onward to new era!"));
		assertFalse(impl.isPalindrome("This is not a palindrome"));
	}
}