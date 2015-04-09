package com.murali.datastructures.arrays;

public class GenericArray<E> {
	
	//Code is commented bcz we cannot create generic arrays in java
	private E[] array;
	
	public GenericArray(int size){
		//array = new E[size];
	}
	public void setElement(int index, E element){
		array[index] = element;
	}
	
	public E getElement(int index){
		return array[index];
	}
	
}
