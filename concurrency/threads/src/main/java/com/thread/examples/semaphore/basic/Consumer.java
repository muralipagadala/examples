package com.thread.examples.semaphore.basic;

public class Consumer implements Runnable {

	private Queue q;

	public Consumer(Queue q) {
		this.q = q;
		new Thread(this).start();
	}

	public void run() {
		for (int i = 1; i < 11; i++) {
			try {
				q.get();
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}