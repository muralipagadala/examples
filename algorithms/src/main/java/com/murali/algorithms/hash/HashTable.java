package com.murali.algorithms.hash;

public class HashTable {

	private Data[] hashTable;
	private int totalElements;
	
	public HashTable(int size){
		hashTable = new Data[size];
	}
	
	public void insert(int key){
		
	}
	
	public void insert(Data data){
		
	}
	
	public Data find(int key){
		return null;
	}
	
	public boolean delete(int key){
		return false;
	}
	
	public boolean isEmpty(){
		return (hashTable != null && totalElements > 0);
	}
	
	private int calculateHash(){
		return 0;
	}
	

}
