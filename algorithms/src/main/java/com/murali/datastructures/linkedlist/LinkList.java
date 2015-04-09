package com.murali.datastructures.linkedlist;

public class LinkList {

	private Link first;
	private int size;
	
	public void add(Link link){
		if(link == null){
			throw new RuntimeException("Cannot add null link.");
		}
		link.setNext(first);
		first = link;
		size++;
	}
	
	public int size(){
		return size;
	}
	
	public boolean find(Link link){
		if(link != null){
			Link current = first;
			while(current != null){
				if(current.equals(link)){
					return true;
				}
				current = current.getNext();
			}
		}
		return false;
	}
	
	public boolean remove(Link link){
		if(link != null){
			Link current = first;
			Link previous = first;
			while(!current.equals(link)){
				previous = current;
				current = current.getNext();	
			}	

			if(current != null && current.equals(link)){
				if(current == previous){
					first = current.getNext();
				}else{
					previous.setNext(current.getNext());
				}
				size--;
				return true;
			}
		}
		return false;
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
	
	public boolean isEmpty(){
		return (first == null);
	}
}
