package com.murali.datastructures.linkedlist;


import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.murali.datastructures.arrays.OrderedArray;

public class LinkListTest {
	private LinkList linkList;
	
	@BeforeMethod
	public void setUp(){
		linkList = new LinkList();
	}
	
	@AfterMethod
	public void tearDown(){
		linkList = null;
	}
	
	@Test(enabled=true)
	public void testAdd(){
		for(int i = 5; i >=1; i--){
			linkList.add(new Link(i));
		}
		Assert.assertEquals(linkList.size(),5);
		Link current = linkList.get();
		while(current != null){
			current.display();
			current = current.getNext();
		}
	}
	
	@Test(enabled=true, expectedExceptions={RuntimeException.class}, expectedExceptionsMessageRegExp="Cannot add null link.")
	public void testAddNullThenThrowException(){
		Link link = null;
		linkList.add(link);
	}
	
	@Test(enabled=true)
	public void testFind(){
		for(int i = 5; i >=1; i--){
			linkList.add(new Link(i));
		}
		Assert.assertEquals(linkList.size(),5);
		Assert.assertTrue(linkList.find(new Link(4)));
		Assert.assertEquals(linkList.size(),5);
		
		Assert.assertEquals(new Link(1), linkList.get());
	}
	
	@Test(enabled=true)
	public void testFindSameValue(){
		for(int i = 5; i >=1; i--){
			linkList.add(new Link(1));
		}
		Assert.assertEquals(linkList.size(),5);
		Assert.assertTrue(linkList.find(new Link(1)));
		Assert.assertEquals(linkList.size(),5);
		
		Assert.assertEquals(new Link(1), linkList.get());
	}
	
	@Test(enabled=true)
	public void testRemoveSpecificLink(){
		for(int i = 5; i >=1; i--){
			linkList.add(new Link(i));
		}
		Assert.assertEquals(linkList.size(),5);
		Assert.assertTrue(linkList.find(new Link(4)));
		Assert.assertTrue(linkList.remove(new Link(4)));
		Assert.assertEquals(linkList.size(), 4);
		
		Assert.assertFalse(linkList.find(new Link(4)));
	}
	
	@Test(enabled=true)
	public void testRemoveFirstLink(){
		for(int i = 5; i >=1; i--){
			linkList.add(new Link(i));
		}
		Assert.assertEquals(linkList.size(),5);
		Assert.assertTrue(linkList.find(new Link(5)));
		Assert.assertTrue(linkList.remove(new Link(5)));
		Assert.assertEquals(linkList.size(), 4);
		
		Assert.assertFalse(linkList.find(new Link(5)));
	}
	
	@Test
	public void testRemoveLastLink(){
		for(int i = 5; i >=1; i--){
			linkList.add(new Link(i));
		}
		Assert.assertEquals(linkList.size(),5);
		Assert.assertTrue(linkList.find(new Link(1)));
		Assert.assertTrue(linkList.remove(new Link(1)));
		Assert.assertEquals(linkList.size(), 4);
		
		Assert.assertFalse(linkList.find(new Link(1)));
	}
	
	@Test(enabled=false)
	public void testRemove(){
		for(int i = 5; i >=1; i--){
			linkList.add(new Link(i));
		}
		Assert.assertEquals(linkList.size(),5);
		
		Assert.assertEquals(new Link(1), linkList.remove());
		Assert.assertEquals(new Link(2), linkList.remove());
		Assert.assertEquals(new Link(3), linkList.remove());
		Assert.assertEquals(new Link(4), linkList.remove());
		Assert.assertEquals(new Link(5), linkList.remove());
	}

}
