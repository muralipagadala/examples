package com.thread.examples.semaphore.basic;

import java.util.concurrent.Semaphore;

public class Decrementor implements Runnable{
	private String name;
	private Semaphore lock;
	
	public Decrementor(String name, Semaphore lock){
		this.name = name;
		this.lock = lock;
		new Thread(this).start();
	}

	public void run() {
		try {
			System.out.println(name +"  is waiting for a permit.");
			lock.acquire();
			System.out.println(name +"  gets a permit.");
			
			for(int i = 0; i < 5; i++){
				SharedResource.count--;
				System.out.println(name +":  "+SharedResource.count);
				Thread.sleep(1000);
			}
			
			System.out.println(name +"  releases the permit.");
			lock.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
