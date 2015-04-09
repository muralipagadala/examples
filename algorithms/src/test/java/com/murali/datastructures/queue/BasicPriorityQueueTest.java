package com.murali.datastructures.queue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicPriorityQueueTest {
	
	private BasicPriorityQueue queue;
	
	@BeforeMethod
	public void setUp(){
		queue = new BasicPriorityQueue();
	}
	
	@AfterMethod
	public void tearDown(){
		queue = null;
	}
	
	@Test
	public void testInsert(){
		
	}
	
}
