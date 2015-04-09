package com.thread.examples.semaphore.basic;

public class PCDemo {

	public static void main(String... args) {
		Queue q = new Queue();

		new Producer(q);
		new Consumer(q);

	}

}