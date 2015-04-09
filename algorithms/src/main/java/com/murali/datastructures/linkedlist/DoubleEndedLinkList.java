package com.murali.datastructures.linkedlist;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class DoubleEndedLinkList {

	private int size;
	private Link first;
	private Link last;
	
	public void insertFirst(Link newLink){
		if(isEmpty()){
			last = newLink;
		}
		newLink.setNext(first);
		first = newLink;
		size++;
	}
	
	public void insertLast(Link newLink){
		if(isEmpty()){
			first = newLink;
		}else{
			last.setNext(newLink);
		}
		
		last = newLink;
		size++;
	}
	
	public Link remove(){
		Link temp = first;
		first = first.getNext();
		size--;
		return temp;
	}
	
	public Link get(){
		return first;
	}
	
	public Link getLast(){
		return last;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return (first == null);
	}
}
