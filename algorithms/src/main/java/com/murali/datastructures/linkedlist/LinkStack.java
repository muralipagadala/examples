package com.murali.datastructures.linkedlist;

public class LinkStack {

	private LinkList linkList;
	
	public LinkStack(){
		linkList = new LinkList();
	}
	
	public void push(Link newLink){
		linkList.add(newLink);
	}
	
	public Link pop(){
		return linkList.remove();
	}
	
	public boolean isEmpty(){
		return linkList.isEmpty();
	}
}
