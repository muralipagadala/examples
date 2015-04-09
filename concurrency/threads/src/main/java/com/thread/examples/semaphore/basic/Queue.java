package com.thread.examples.semaphore.basic;

import java.util.concurrent.Semaphore;

public class Queue {

	private int n;
	private Semaphore consumerLock = new Semaphore(0);
	private Semaphore producerLock = new Semaphore(1);
	
	public void get(){
		try{
			consumerLock.acquire();
		}catch(InterruptedException ie){
			
		}
		System.out.println("Got :"+n);
		producerLock.release();
	}
	
	public void put(int n){
		try{
			producerLock.acquire();
		}catch(InterruptedException ie){
			
		}
		System.out.println("Put :"+n);
		this.n = n;
		consumerLock.release();
	}
}
