package com.murali.datastructures.arrays;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;

import org.testng.annotations.Test;

public class OrderedArray {

	private int[] array;
	private int totalElements;
	
	public OrderedArray(){
		array = new int[5];
	}
	
	public OrderedArray(int size){
		array = new int[size];
	}
	
	/**
	 * 1. Find the index to insert the element.
	 * 2. Iterate over elements and move them to the left.
	 * 3. insert element into into the index find in step 1.
	 * 
	 * handle the duplicate elements
	 */
	public void linearInsert(int value){
		int index;
		for(index = 0; index < totalElements; index++){
			if(array[index] > value){
				break;
			}
		}
		for(int moveIndex = totalElements ; moveIndex > index; moveIndex--){
			array[moveIndex] = array[moveIndex-1];
		}
		array[index] = value;
		totalElements++;	
	}
	
	public boolean linearSearch(int value){
		for(int i = 0; i < totalElements; i++){
			if(array[i] > value ){
				return false;
			}else if(array[i] == value){
				return true;
			}
		}
		return false;
	}
	
	public boolean binarySearch(int value){
		int lowerBound = 0;
		int upperBound = totalElements - 1;
		int curr = 0;
		while(true){
			curr = (lowerBound + upperBound)/2;
			if(array[curr] == value){
				return true;
			}else if(lowerBound > upperBound){
				return false;
			}else if(value < array[curr]){
				upperBound = curr-1;
			}else{
				lowerBound = curr +1;
			}
		}		
	}
	
	public boolean binaryRecursiveSearch(int searchKey){
		System.out.println("Total Elements :"+totalElements);
		return binaryRecursiveSearch(searchKey, 0, totalElements);
	}
	
	public boolean binaryRecursiveSearch(int searchKey, int lowerBound, int upperBound){
		int current = ( lowerBound + upperBound)/2;
		if(array[current] == searchKey){
			return true;
		}else if( lowerBound > upperBound){
			return false;
		}else {
			if(array[current] < searchKey){
				return binaryRecursiveSearch(searchKey, current + 1, upperBound);
			}else{
				return binaryRecursiveSearch(searchKey, lowerBound, current-1);
			}
		}
	}
	
	public static void main(String...args){
		OrderedArray tempArray = new OrderedArray();
		tempArray.linearInsert(1);
		tempArray.linearInsert(2);
		tempArray.linearInsert(3);
		tempArray.linearInsert(5);
		tempArray.linearInsert(4);
		
		System.out.println("Array :"+Arrays.toString(tempArray.toArray()));
		
		System.out.println("Binary Search :"+tempArray.binarySearch(1));
	}
	
	public boolean linearDelete(int value){
		for(int i = 0; i < totalElements; i++){
			if(array[i] > value ){
				return false;
			}else if(array[i] == value){
				if(i != totalElements-1){
					for(int moveIndex = i ; moveIndex < totalElements; moveIndex++){
						array[moveIndex] = array[moveIndex+1];
					}
					totalElements--;
				}else{
					array[i] = 0;
					totalElements--;
				}
				return true;
			}
		}
		return false;
	}
	
	public int[] toArray(){
		return array;
	}
}
