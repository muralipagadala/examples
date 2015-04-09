package com.murali.datastructures.linkedlist;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DoubleEndedLinkListTest {

private DoubleEndedLinkList linkList;
	
	@BeforeMethod
	public void setUp(){
		linkList = new DoubleEndedLinkList();
	}
	
	@AfterMethod
	public void tearDown(){
		linkList = null;
	}
	
	@Test
	public void testEmpty(){
		Assert.assertTrue(linkList.isEmpty());
	}
	
	@Test(enabled=true)
	public void testAddAndIterateForward(){
		for(int i = 5; i >=1; i--){
			linkList.insertFirst(new Link(i));
		}
		Assert.assertEquals(linkList.size(),5);
		System.out.println("After insert first : ( first --> last ) :");
		Link current = linkList.get();
		while(current != null){
			current.display();
			current = current.getNext();
		}
	}
	
	@Test(enabled=true)
	public void testAddAndIterateBackward(){
		for(int i = 5; i >=1; i--){
			linkList.insertFirst(new Link(i));
		}
		
		for(int i = 5; i >=1; i--){
			linkList.insertLast(new Link(i * 2));
		}
		System.out.println("After insert last : ( first --> last ) :");
		Assert.assertEquals(linkList.size(),10);
		Link current = linkList.get();
		while(current != null){
			current.display();
			current = current.getNext();
		}
	}
	
	@Test
	public void testInsertLast(){
		for(int i = 5; i >=1; i--){
			linkList.insertLast(new Link(i * 2));
		}
		System.out.println("After insert last : ( first --> last ) :");
		Assert.assertEquals(linkList.size(),5);
		Link current = linkList.get();
		while(current != null){
			current.display();
			current = current.getNext();
		}
	}
	
	@Test
	public void testAddFirst(){
		
	}
	
	@Test
	public void testAddLast(){
		
	}
}
