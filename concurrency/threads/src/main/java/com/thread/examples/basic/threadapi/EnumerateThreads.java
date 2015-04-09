package com.thread.examples.basic.threadapi;

public class EnumerateThreads {

	public static void main(String...args){
		Thread[] threads = new Thread[Thread.activeCount()];
		//This method simply invokes the ThreadGroup.enumerate(Thread[]) method of the current thread's thread group.
		int count = Thread.enumerate(threads); 
		for(int i = 0; i < count; i++){
			System.out.println("Thread " + i + " is " +threads[i].getName());
		}
	}
}
