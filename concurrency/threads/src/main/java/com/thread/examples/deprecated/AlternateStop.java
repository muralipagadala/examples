package com.thread.examples.deprecated;

public class AlternateStop extends Object implements Runnable {
	private volatile boolean stopRequested;
	private Thread runThread;

	public void run() {
		runThread = Thread.currentThread();
		System.out.println(runThread.getName() +" is started...");
		stopRequested = false;

		int count = 0;

		while (!stopRequested) {
			System.out.println("Running ... count=" + count);
			count++;

			try {
				System.out.println(Thread.currentThread().getName() +" is going to sleep.");
				Thread.sleep(300);
				System.out.println(Thread.currentThread().getName() +" is woke up.");
			} catch (InterruptedException x) {
				Thread.currentThread().interrupt(); // re-assert interrupt
				System.out.println(Thread.currentThread().getName() +" is interrupted.");
			}
		}
	}

	public void stopRequest() {
		stopRequested = true;
		if (runThread != null) {
			runThread.interrupt();
		}
	}

	public static void main(String[] args) {
		AlternateStop as = new AlternateStop();
		Thread t = new Thread(as);
		t.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException x) {
			System.out.println("Main thread interrupted...");
		}
		as.stopRequest();
	}
}