package com.murali.datastructures.queue;


import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.murali.datastructures.queue.BasicQueue;

public class BasicQueueTest {

	private BasicQueue queue;
	
	@BeforeMethod
	public void setUp(){
		queue = new BasicQueue();
	}
	
	@AfterMethod
	public void tearDown(){
		queue = null;
	}
	
	@Test
	public void testInsert(){
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
		queue.insert(5);
		
		Assert.assertEquals(1, queue.remove());
		Assert.assertEquals(2, queue.remove());
		queue.insert(6);
		queue.insert(7);
		Assert.assertEquals(3, queue.remove());
		Assert.assertEquals(4, queue.remove());
		Assert.assertEquals(5, queue.remove());
		Assert.assertEquals(6, queue.remove());
		Assert.assertEquals(7, queue.remove());
		queue.insert(8);
		Assert.assertEquals(8,  queue.remove());
	}
	
	@Test
	public void testPeek(){
		queue.insert(1);
		Assert.assertEquals(1, queue.peek());
		Assert.assertEquals(1, queue.peek());
	}
	
	@Test
	public void testInsertRemoveOps(){
		queue.insert(10); 
		queue.insert(20);
		queue.insert(30);
		queue.insert(40);
		Assert.assertEquals(10, queue.remove());
		Assert.assertEquals(20, queue.remove());
		Assert.assertEquals(30, queue.remove());
		
		queue.insert(50); 
		queue.insert(60); 
		queue.insert(70);
		queue.insert(80);
		
		Assert.assertEquals(40, queue.remove());
		Assert.assertEquals(50, queue.remove());
		Assert.assertEquals(60, queue.remove());
		Assert.assertEquals(70, queue.remove());
		Assert.assertEquals(80, queue.remove());
	}
	
	
}
