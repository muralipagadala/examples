package com.murali.datastructures.linkedlist;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortedListTest {

	private SortedList sortedList;
	
	@BeforeMethod
	public void setUp(){
		sortedList = new SortedList();
	}
	
	@AfterMethod
	public void tearDown(){
		sortedList = null;
	}
	
	@Test
	public void testInsert(){
		sortedList.insert(new Link(8));
		sortedList.insert(new Link(10));
		sortedList.insert(new Link(6));
		sortedList.insert(new Link(5));
		sortedList.insert(new Link(7));
		sortedList.insert(new Link(9));
		
		
		Assert.assertTrue(sortedList.size() == 6);
		
		Link current = sortedList.get();
		while(current != null){
			System.out.println(current);
			current = current.getNext();
		}
	}
	
	@Test
	public void testSizeEmpty(){
		Assert.assertTrue(sortedList.size() == 0);
	}
}
