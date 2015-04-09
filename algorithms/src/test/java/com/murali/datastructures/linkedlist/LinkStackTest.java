package com.murali.datastructures.linkedlist;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkStackTest {
	
	private LinkStack linkStack;

	@BeforeMethod
	public void setUp(){
		linkStack = new LinkStack();
	}
	
	@AfterMethod
	public void tearDown(){
		linkStack = null;
	}
	
	@Test
	public void testPush(){
		for(int i = 5; i >=1; i--){
			linkStack.push(new Link(i));
		}
		Assert.assertEquals(linkStack.pop(), new Link(1));
		Assert.assertEquals(linkStack.pop(), new Link(2));
	}
	
	@Test
	public void testEmptyStack(){
		Assert.assertTrue(linkStack.isEmpty());
		for(int i = 5; i >=1; i--){
			linkStack.push(new Link(i));
		}
		Assert.assertFalse(linkStack.isEmpty());
	}
}
