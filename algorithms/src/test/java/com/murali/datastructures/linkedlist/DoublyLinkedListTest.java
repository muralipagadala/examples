package com.murali.datastructures.linkedlist;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DoublyLinkedListTest {

	private DoublyLinkedList linkedList;
	
	@BeforeMethod
	public void setUp(){
		linkedList = new DoublyLinkedList();
	}
	
	@AfterMethod
	public void tearDown(){
		linkedList = null;
	}
}
