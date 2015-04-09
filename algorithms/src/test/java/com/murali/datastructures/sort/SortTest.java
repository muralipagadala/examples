package com.murali.datastructures.sort;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import java.util.Arrays;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SortTest {
	
	private Sort sort;
	
	@BeforeMethod
	public void setUp(){
		sort = new Sort();
	}
	
	@AfterMethod
	public void tearDown(){
		sort = null;
	}
		
	@Test
	public void testBubbleSort(){
		int[] array = {20, 3, 11, 5, 4, 15, 7, 2, 6, 8, 10, 9,  1};
		int[] finalArrayy = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 15, 20};
		int[] sortedArray = sort.bubbleSort_2(array);
		assertTrue(Arrays.equals(finalArrayy, sortedArray));
	}
	
	@Test
	public void testSelectionSort(){
		int[] array = {20, 3, 11, 5, 4, 15, 7, 2, 6, 8, 10, 9,  1};
		int[] finalArrayy = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 15, 20};
		int[] sortedArray = sort.selectionSort(array);
		assertTrue(Arrays.equals(finalArrayy, sortedArray));
	}
	
	@Test
	public void testInsertionSort(){
		int[] array = {12, 3, 1, 5, 8};
		int[] finalArrayy = {1, 3, 5, 8, 12};
		int[] sortedArray = sort.insertionSort(array);
		assertTrue(Arrays.equals(finalArrayy, sortedArray));
	}
	
	@Test
	public void testObjectInsertionSort(){
		Person[] persons = new Person[10];
				
		persons[0] = new Person("Evans", "Patty", 24);
		persons[1] = new Person("Smith", "Doc", 59);
		persons[2] = new Person("Smith", "Lorraine", 37);
		persons[3] = new Person("Smith", "Paul", 37);
		persons[4] = new Person("Yee", "Tom", 43);
		persons[5] = new Person("Hashimoto", "Sato", 21);
		persons[6] = new Person("Stimson", "Henry", 29);
		persons[7] = new Person("Velasquez", "Jose", 72);
		persons[8] = new Person("Vang", "Minh", 22);
		persons[9] = new Person("Creswell", "Lucinda", 18);
		
		System.out.println("Before sort");
		display(persons);
		
		//sort.insertionSort(persons);
		sort.sortPersons(persons);
		
		System.out.println("After sort");
		display(persons);
	}
	
	private void display(Person[] persons){
		System.out.println("-------------------------------------------------------------------------------------");
		for(Person person : persons){
			System.out.println(person);
		}
		System.out.println("-------------------------------------------------------------------------------------");
	}
}
