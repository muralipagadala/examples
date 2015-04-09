package com.murali.datastructures.stacks;

public class Stack {

	private int[] stack;
	private int top;
	
	public Stack(){
		stack = new int[5];
		top = -1;
	}
	
	public Stack(int size){
		stack = new int[size];
		top = -1;
	}
	
	public void push(int element){
		if(isFull())
			throw new RuntimeException("Stack is full can't push an item.");
		stack[++top] = element;
	}
	
	public int pop(){
		return stack[top--];
	}
	
	public int peek(){
		return stack[top];
	}
	
	public boolean isFull(){
		return top == stack.length -1;
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public int size(){
		return top + 1;
	}
}
