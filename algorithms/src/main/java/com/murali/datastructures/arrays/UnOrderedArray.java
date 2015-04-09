package com.murali.datastructures.arrays;

/**
 * @author Murali Pagadala
 *
 */
public class UnOrderedArray {

	private int[] elements;
	private int index;
	
	public UnOrderedArray(){
		elements = new int[20];
	}
	
	public UnOrderedArray(int initialsize){
		elements = new int[initialsize];
	}
	
	public void insert(int element){
		elements[index++] = element;
	}
	
	public boolean delete(int element){
		for(int i = 0; i < index; i++){
			if(element == elements[i]){
				elements[i] = 0;
				fillTheHoles();
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteAndFill(int element){
		for(int i = 0; i < index; i++){
			if(element == elements[i]){
				fillTheHoles(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean find(int element){
		for(int i = 0; i < index; i++){
			if(element == elements[i]){
				return true;
			}
		}
		return false;
	}
	
	private void fillTheHoles(int index){
		for(int i = index; i < this.index; i++){
			elements[i] = elements[i+1];
		}
	}
	
	private void fillTheHoles(){
		for(int i = 0; i < index-1; i++){
			if(elements[i] == 0){
				elements[i] = elements[i+1];
				elements[i+1] = 0;
			}
		}
	}
	
	public int[] toArray(){
		int[] array = new int[index];
		for(int i = 0; i < index; i++){
			array[i] = elements[i];
		}
		return array;
	}
	
	public int[] createReverseArray(){
		int[] array = new int[index];
		for(int i = index - 1, j = 0; i >= 0; i--, j++){
			array[j] = elements[i];
		}
		return array;
	}
	
	
	public int[] reverse(){
		int length = index;
		for(int i = 0; i < length/2; i++){
			int temp = elements[i];
			elements[i] = elements[length-1-i];
			elements[length-i-1] = temp;
		}
		return elements;
	}
	
	public int max(){
		int max = elements[0];
		for(int i = 1; i < index; i++){
			max = elements[i] > max ? elements[i] : max;
		}
		return max;
	}
	
	public int min(){
		int min = elements[0];
		for(int i = 1; i < index; i++){
			min = elements[i] > min ? min : elements[i] ;
		}
		return min;
	}
	
	public int size(){
		return elements.length;
	}
	
	public void display(){
		for(int i = 0; i < index; i++){
			System.out.println("Element :"+elements[i]);
		}
	}
}
