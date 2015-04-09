package com.murali.datastructures.queue;

import java.util.Arrays;

public class BasicQueue {

	private int[] queue;
	private int front;
	private int rear;
	private int totalElements;
	
	public BasicQueue(){
		queue = new int[5];
		front = 0;
		rear = 0;
	}
	
	public BasicQueue(int size){
		queue = new int[size];
		front = 0;
		rear = 0;
	}
	
	/**
	 * What are the different scenarios/use cases when an item is inserted into queue.
	 * 1. When the queue is empty. front and rear must point to 0th element. Is this correct. verify it.
	 * 2. When the queue is full.
	 * @param item
	 */
	public void insert(int item){
		//System.out.println("Insert : "+front +" ---> "+rear );
		
		if(rear == queue.length){
			rear = 0;
		}
		queue[rear++] = item;
		totalElements++;
		//System.out.println("Array after insert : "+Arrays.toString(queue));
		//System.out.println(front +" ---> "+rear +" ---> "+queue[front]);
	}
	
	public int peek(){
		System.out.println("Front --> "+front);
		return queue[front];
	}
	
	/**
	 * 1. Remove the current item pointing by front.
	 * 2. Increment the front which goes upwards
	 * 3. If we remove all the items from queue from must go to 0 th position
	 * @return
	 */
	public int remove(){
		//System.out.println("Front :  --> "+front);
		if(front == queue.length){
			front = 0;
			//can we check whether rear is at the end of the queue as invariant.
		}
		totalElements--;
		int result = queue[front++];
		//System.out.println("Remove result :"+result +"  --> "+front);
		return result;
	}
	
	public boolean isFull(){
		return totalElements == queue.length;
	}
	
	public boolean isEmpty(){
		return totalElements == 0;
	}
	
	public int size(){
		return totalElements;
	}
	
}
