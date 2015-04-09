package com.thread.examples.deprecated;

public class DeprecatedSuspendResume implements Runnable {

	private volatile int firstVal;
	private volatile int secondVal;

	public boolean areValuesEqual() {
		return (firstVal == secondVal);
	}

	public void run() {
		try {
			firstVal = 0;
			secondVal = 0;
			workMethod();
		} catch (InterruptedException x) {
			System.out.println("interrupted while in workMethod()");
		}
	}

	private void workMethod() throws InterruptedException {
		int val = 1;

		while (true) {
			stepOne(val);
			stepTwo(val);
			val++;
			System.out.println(Thread.currentThread().getName() +" is going to sleep inside workMethod()");
			Thread.sleep(200); // pause before looping again
			System.out.println(Thread.currentThread().getName() +" is woke up inside workMethod()");
		}
	}

	private void stepOne(int newVal) throws InterruptedException {
		System.out.println("################################ assigning firstValue :"+newVal);
		firstVal = newVal;
		System.out.println(Thread.currentThread().getName() +" is going to sleep inside stepOne()");
		Thread.sleep(300); // simulate some other long process
		System.out.println(Thread.currentThread().getName() +" is woke up inside stepOne()");
		
	}

	private void stepTwo(int newVal) {
		System.out.println("------------ assigning secondValue :"+newVal);
		secondVal = newVal;
	}

	public static void main(String[] args) {
		DeprecatedSuspendResume dsr = new DeprecatedSuspendResume();
		Thread t = new Thread(dsr);
		t.start();

		// let the other thread get going and run for a while
		try {
			System.out.println(Thread.currentThread().getName() +" is going to sleep inside main1()");
			Thread.sleep(1000);
		} catch (InterruptedException x) {
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("@@@@@@@@@@@@@@ Suspending :"+t.getName());
			t.suspend();
			System.out.println("********************8dsr.areValuesEqual()=" + dsr.areValuesEqual());
			t.resume();
			System.out.println("@@@@@@@@@@@@@@ Resumed :"+t.getName());
			try {
				// Pause for a random amount of time
				// between 0 and 2 seconds.
				System.out.println(Thread.currentThread().getName() +" is going to sleep inside main2()");
				Thread.sleep((long) (Math.random() * 2000.0));
			} catch (InterruptedException x) {
				// ignore
			}
		}

		System.exit(0); // abruptly terminate application
	}
}