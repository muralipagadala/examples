package com.murali.datastructures.arrays;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import java.util.Arrays;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrderedArrayTest {

	private OrderedArray array;
	
	@BeforeMethod
	public void setUp(){
		array = new OrderedArray();
	}
	
	@AfterMethod
	public void tearDown(){
		array = null;
	}
	

	@DataProvider(name = "arrayInput")
	public Object[][] getTwoElementInputs() {
	  Object[][] inputs = new Object[][] {
	    new int[][] { {2, 1, 4, 0, 3}, {0, 1, 2, 3, 4}},
	    new int[][] { {20, 10, 39, 0, 3}, {0, 3, 10, 20, 39}},
	    new int[][] { {5, 4, 3, 2, 1}, {1, 2, 3, 4, 5}},
	    new int[][] { {1, 2, 3, 4, 5} , {1, 2, 3, 4, 5} }
	  };
	  return inputs;
	}

	
	@Test(dataProvider="arrayInput")
	public void testLinearInsert(int[] input, int[] output){
		for(int i = 0; i < input.length; i++){
			array.linearInsert(input[i]);
		}
		int[] arrayCopy = array.toArray();
		assertTrue(Arrays.equals(arrayCopy, output));
	}
	
	@Test
	public void testLinearSearch(){
		for(int i = 5; i > 0; i--){
			array.linearInsert(i);
		}
		assertTrue(array.linearSearch(5));
		assertFalse(array.linearSearch(10));
	}
	
	@Test
	public void testBinarySearch(){
		for(int i = 5; i > 0; i--){
			array.linearInsert(i);
		}
		assertTrue(array.binarySearch(5));
		assertFalse(array.binarySearch(10));
	}
	
	@Test
	public void testBinaryRecursiveSearch(){
		for(int i = 5; i > 0; i--){
			array.linearInsert(i);
		}
		System.out.println("Array after insert :"+Arrays.toString(array.toArray()));
		assertTrue(array.binaryRecursiveSearch(5));
		//assertFalse(array.binaryRecursiveSearch(10));
	}
	
	@Test
	public void testLinearDelete(){
		int[] originalArray = {1,2,3,4,0};
		for(int i = 5; i > 0; i--){
			array.linearInsert(i);
		}
		assertTrue(array.linearDelete(5));
		assertTrue(Arrays.equals(originalArray, array.toArray()));
		
		assertTrue(array.linearDelete(2));
		int[] originalArray2 = {1,3,4,0,0};
		assertTrue(Arrays.equals(originalArray2, array.toArray()));
		
		assertTrue(array.linearDelete(1));
		int[] originalArray3 = {3,4,0,0,0};
		assertTrue(Arrays.equals(originalArray3, array.toArray()));
	}
	
	
	@Test(expectedExceptions={ArrayIndexOutOfBoundsException.class} )
	public void testInsertMoreElementsThanSizeAndThrowException(){
		for(int i = 0; i < 10; i++){
			array.linearInsert(i);
		}
	}
}
