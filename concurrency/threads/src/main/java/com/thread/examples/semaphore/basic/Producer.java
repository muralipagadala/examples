package com.thread.examples.semaphore.basic;

public class Producer implements Runnable {
	private Queue q;

	public Producer(Queue q) {
		this.q = q;
		new Thread(this).start();
	}

	public void run() {
		for (int i = 1; i < 11; i++) {
			try {
				q.put(i);
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
