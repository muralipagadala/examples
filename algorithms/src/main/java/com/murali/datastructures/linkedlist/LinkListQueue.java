package com.murali.datastructures.linkedlist;

public class LinkListQueue {

	private DoubleEndedLinkList linkList;
	
	public LinkListQueue(){
		linkList = new DoubleEndedLinkList();
	}
	
	public void add(Link newLink){
		linkList.insertLast(newLink);
	}
	
	public Link remove(){
		return linkList.remove();
	}
	
	public boolean isEmpty(){
		return linkList.isEmpty();
	}
}
