package com.thread.examples.pc;

public class Consumer implements Runnable {

	private Queue q;

	public Consumer(Queue q) {
		this.q = q;
		new Thread(this).start();
	}

	public void run() {
		try {
			System.out.println("Get: " + q.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}