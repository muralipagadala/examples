package com.thread.examples.deprecated;

public class DeprecatedStop extends Object implements Runnable {
	public void run() {
		int count = 0;
		while (true) {
			System.out.println("Running ... count=" + count);
			count++;
			try {
				Thread.sleep(300);
			} catch (InterruptedException x) {
			}
		}
	}

	public static void main(String[] args) {
		DeprecatedStop ds = new DeprecatedStop();
		Thread t = new Thread(ds);
		t.start();
		System.out.println(t.getName() +" is Alive :"+t.isAlive());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException x) {
			System.out.println("Interrupted...");
		}
		t.stop();
		System.out.println(t.getName() +"  is Alive :"+t.isAlive());
		System.out.println("Stopped...");
	}
}