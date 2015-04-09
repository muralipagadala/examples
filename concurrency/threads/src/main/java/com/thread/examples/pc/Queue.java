package com.thread.examples.pc;

public class Queue {
	public int value;
	private boolean valueSet;

	public synchronized void put(int n) throws Exception {
		while (valueSet) {
			wait();
		}
		value = n;
		valueSet = true;
		notifyAll();
	}

	public synchronized int get() throws Exception {
		while (!valueSet) {
			wait();
		}
		valueSet = false;
		notifyAll();
		return value;
	}
}
