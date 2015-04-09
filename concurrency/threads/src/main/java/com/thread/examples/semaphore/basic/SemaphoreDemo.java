package com.thread.examples.semaphore.basic;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	public static void main(String...args){
		Semaphore lock = new Semaphore(1);
		new Incrementor("A", lock);
		new Decrementor("B", lock);
		//new Decrementor("C", lock);
	}
	
}
