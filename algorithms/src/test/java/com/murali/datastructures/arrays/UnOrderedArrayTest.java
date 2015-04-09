package com.murali.datastructures.arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Murali Pagadala
 *
 * -> Array must be initialized before accessing the elements.
 */
public class UnOrderedArrayTest {

	private UnOrderedArray array;
	
	@BeforeMethod
	public void setUp(){
		array = new UnOrderedArray(5);
		assertEquals(array.size(), 5);
	}
	
	@AfterMethod
	public void tearDown(){
		array = null;
	}
	
	@Test
	public void testSearchAndFindItem(){
		insertElements(5);
		assertTrue(array.find(4));
	}
	
	@Test
	public void testSearchAndDontFindItem(){
		insertElements(5);
		assertFalse(array.find(15));
	}
	
	@Test
	public void testDeleteElementAndFillTheHoles(){
		insertElements(5);
		//assertTrue(array.deleteAndFill(5));
		assertTrue(array.delete(5));
	}
	
	@Test
	public void testInsertElements(){
		insertElements(5);
	}
	
	@Test
	public void testMaxElement(){
		insertElements(5);
		assertEquals(array.max(), 5);
	}
	
	@Test
	public void testMinElement(){
		insertElements(5);
		assertEquals(array.min(), 1);
	}
	
	@Test
	public void testArrayCopy(){
		insertElements(5);
		int[] testArray = {1,2,3,4,5};
		int[] arrayCopy = array.toArray();
		assertTrue(Arrays.equals(testArray, arrayCopy));
	}
	
	@Test
	public void testArrayReverse(){
		insertElements(5);
		int[] testArray = {5,4,3,2,1};
		int[] reverseArray = array.createReverseArray();
		assertTrue(Arrays.equals(testArray, reverseArray));
	}
	
	@Test
	public void testArrayReverseCopy(){
		array = new UnOrderedArray(5);
		insertElements(5);
		int[] testArray = {5,4,3,2,1};
		int[] reverseArray = array.reverse();
		assertTrue(Arrays.equals(testArray, reverseArray));
	}
	
	@Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
	public void testInsertMoreElementsThanArrayAndThrowException(){
		insertElements(25);
	}
	
	
	private void insertElements(int size){
		for(int i = 1; i < size + 1; i++){
			array.insert(i);
		}
	}
}
