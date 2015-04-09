package com.murali.algorithms.recursion;

import org.testng.annotations.Test;

public class AnagramTest {
	
	static int size;
	static int count;
	static char[] arrChar = new char[100];

	@Test
	public void testAnagram(){
		String word = "TEA";
		count = 0;
		size = word.length();
		for(int i = 0; i < size; i++){
			arrChar[i] = word.charAt(i);
		}
		doAnagram(size);
	}
	
	public void doAnagram(int size){
		if(size == 1){
			return;
		}
		for(int i =0; i < size; i++){
			doAnagram(size - 1);
			if(size==2){
				display();
			}
			rotate(size);
		}
	}
	
	public static void rotate(int newSize) {
		int j;
		int position = size - newSize;
		char temp = arrChar[position]; // save first letter
		for (j = position + 1; j < size; j++)
			// shift others left
			arrChar[j - 1] = arrChar[j];
		arrChar[j - 1] = temp; // put first on right
	}
	
	private void display(){
		if(count < 99)
			System.out.print(" ");
		
		if(count < 9)
			System.out.print(" ");
		System.out.print(++count + " ");
		
		for(int j=0; j<size; j++)
			System.out.print( arrChar[j] );
		
		System.out.print(" ");
		System.out.flush();
		if(count%6 == 0)
			System.out.println("");
	}
}
