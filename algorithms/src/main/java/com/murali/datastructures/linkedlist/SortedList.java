package com.murali.datastructures.linkedlist;

public class SortedList {

	private Link first;
	private int size;
	
	public void insert(Link newLink){
		Link previous = null;
		Link current = first;
		while(current != null && current.getData() < newLink.getData()){
			previous = current;
			current = current.getNext();
		}
		if(previous == null){
			first = newLink;
		}else{
			previous.setNext(newLink);
		}
		newLink.setNext(current);
		
		size++;
	}
	
	public Link get(){
		return first;
	}
	
	public Link remove(){
		Link temp = first;
		first = first.getNext();
		size--;
		return temp;
	}
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	public int size(){
		return size;
	}

}
