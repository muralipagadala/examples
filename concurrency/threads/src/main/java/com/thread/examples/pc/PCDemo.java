package com.thread.examples.pc;

public class PCDemo {

	public static void main(String... args) {
		Queue q = new Queue();

		new Producer(q);
		new Consumer(q);

	}

}