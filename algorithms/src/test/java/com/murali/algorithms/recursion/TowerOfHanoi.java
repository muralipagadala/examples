package com.murali.algorithms.recursion;

import org.testng.annotations.Test;

public class TowerOfHanoi {
	private int count = 0;

	@Test
	public void testTowersOfHanoi(){
		doTowers(5, 'A', 'B', 'C');
		System.out.println("Total steps :"+count);
	}
	
	private void doTowers(int top, char from , char inter, char to){
		count++;
		if(top == 1){
			System.out.println("Disk 1 from " + from + " to "+ to);
		}else{
			doTowers(top-1, from, to, inter);
			System.out.println("Disk " + top +" from " + from + " to "+ to);
			doTowers(top-1, inter, from, to);
		}
	}
}
