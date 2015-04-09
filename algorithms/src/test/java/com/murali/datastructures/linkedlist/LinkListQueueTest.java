package com.murali.datastructures.linkedlist;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkListQueueTest {
	
	private LinkListQueue queue;

	@BeforeMethod
	public void setUp(){
		queue = new LinkListQueue();
	}
	
	@AfterMethod
	public void tearDown(){
		queue = null;
	}
	
	@Test
	public void testInsert(){
		queue.add(new Link(1));
		//queue.add(new Link(2));
		//queue.add(new Link(3));
		//queue.add(new Link(4));
		//queue.add(new Link(5));
		
		/*Assert.assertEquals(new Link(1), queue.remove());
		Assert.assertEquals(new Link(2), queue.remove());
		queue.add(new Link(6));
		queue.add(new Link(7));
		Assert.assertEquals(new Link(3), queue.remove());
		Assert.assertEquals(new Link(4), queue.remove());
		Assert.assertEquals(new Link(5), queue.remove());
		Assert.assertEquals(new Link(6), queue.remove());
		Assert.assertEquals(new Link(7), queue.remove());
		queue.add(new Link(8));
		Assert.assertEquals(new Link(8),  queue.remove());*/
	}
	

}
