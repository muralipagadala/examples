package com.murali.script.groovy.tools.ut

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

class JavaImplGroovyTest {

	private UtilityMethods impl;
	
	@BeforeClass
	public void setUp(){
		impl = new JavaUtilityMethods();
	}
	
	@Test
	void testGetPositives() {
		def correct = [1, 2, 3]
		def results = impl.getPositives(-3..3 as int[])
		assert results.every { it > 0 }
	}
	
	@Test
	void testIsPrime() {
		def primes = [2, 3,	5, 7, 11, 13, 17, 19, 23]
		primes.each { num ->
			assert impl.isPrime(num)
		}
		assert !impl.isPrime(9)
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	void testIsPrimeWithNegative() {
		impl.isPrime(-3)
	}

	@Test
	void testIsPalindrome() {
		assert impl.isPalindrome('No cab, no tuna nut on bacon')
		assert impl.isPalindrome('Do geese see God?')
		assert impl.isPalindrome("Go hang a salami; I'm a lasagna hog!")
		assert !impl.isPalindrome('This is not a palindrome')
	}
}
