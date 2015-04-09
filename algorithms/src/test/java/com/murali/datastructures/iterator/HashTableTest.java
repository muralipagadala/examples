package com.murali.datastructures.iterator;

import org.testng.annotations.Test;

import com.murali.algorithms.hash.HashTable;

public class HashTableTest {

	private HashTable hashTable;
	
	@Test
	public void setUp(){
		hashTable = new HashTable(10);
	}
	
	@Test
	public void tearDown(){
		hashTable = null;
	}
	
	@Test
	public void findElement(){
		
	}
	
	@Test
	public void testInsertElement(){
		
	}
	
	@Test
	public void testDeleteElement(){
		
	}
}
