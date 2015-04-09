package com.murali.datastructures.iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.murali.datastructures.linkedlist.LinkList;

public class ListIteratorTest {

	private ListIterator iterator;
	
	@BeforeMethod
	public void setUp(){
		//iterator = new ListIterator();
	}
	
	@AfterMethod
	public void tearDown(){
		iterator = null;
	}
}
