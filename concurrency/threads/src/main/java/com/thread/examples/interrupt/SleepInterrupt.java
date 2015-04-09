package com.thread.examples.interrupt;

public class SleepInterrupt extends Object implements Runnable {

	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()+" is in run() - about to sleep for 20 seconds");
			Thread.sleep(20000);
			System.out.println(Thread.currentThread().getName()+" in run() - woke up");
		} catch (InterruptedException x) {
			System.out.println(Thread.currentThread().getName()+" in run() - interrupted while sleeping");
			for(int i = 0 ; i < 100; i++){
				System.out.println("Running even after interrupt...");
			}
			return;
		}

		System.out.println(Thread.currentThread().getName()+"  in run() - doing stuff after nap");
		System.out.println(Thread.currentThread().getName()+"  in run() - leaving normally");
	}

	public static void main(String[] args) {
		SleepInterrupt si = new SleepInterrupt();
		Thread t = new Thread(si);
		t.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("interrupting "+t.getName() +" .. by  "+Thread.currentThread().getName());
		t.interrupt();
		System.out.println("exiting main thread");
	}

}
