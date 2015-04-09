package com.thread.examples.pc;

public class Producer implements Runnable {
	private Queue q;

	public Producer(Queue q) {
		this.q = q;
		new Thread(this).start();
	}

	public void run() {
		for (int i = 1; i < 11; i++) {
			System.out.println("Put: " + i);
			try {
				q.put(i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
