package com.murali.datastructures.iterator;

import com.murali.datastructures.linkedlist.Link;
import com.murali.datastructures.linkedlist.LinkList;

public class ListIterator {

	private Link current;
	private Link previous;
	private LinkList list;
	
	public ListIterator(LinkList list){
		this.list = list;
		reset();
	}
	
	public void reset(){
		current = list.get();
		previous = null;
	}
	
	public Link next(){
		previous = current;
		current = current.getNext();
		return current;
	}
	
	public boolean hasNext(){
		return ( current.getNext() == null);
	}
	
	public void insertAfter(Link link){
		
	}
	
	public void insertBefore(Link link){
		
	}
	
	public boolean deleteCurrent(){
		
		return false;
	}
	
}
