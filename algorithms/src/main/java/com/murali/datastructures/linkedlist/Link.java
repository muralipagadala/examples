package com.murali.datastructures.linkedlist;

public class Link {

	private int data;
	
	private Link next;
	
	public Link(int data){
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	
	public Link getNext() {
		return next;
	}

	public void setNext(Link next) {
		this.next = next;
	}
	
	public void display(){
		System.out.println("Data : "+data);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Link other = (Link) obj;
		if (data != other.data)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Link [data=" + data + "]";
	}
	
	

}
