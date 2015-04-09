package com.murali.algorithms.recursion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicRecursionTest {

	@Test
	public void testTraingleNumber(){
		long n = 10; 
		Assert.assertEquals(triangle(n), 55);
		
		n = 1000; 
		Assert.assertEquals(triangle(n), 500500);
	}
	
	@Test
	public void testFactorial(){
		long n = 5; 
		Assert.assertEquals(factorial(n), 120);
		
		n = 10; 
		Assert.assertEquals(factorial(n), 3628800);
	}
	
	public long triangle(long n){
		if(n == 1) //base case
			return n;
		return ( n  + triangle(n-1));
	}
	
	public long factorial(long n){
		if(n==1)  // base case
			return n;
		return ( n * factorial(n-1));
	}
}
