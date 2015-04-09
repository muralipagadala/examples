package com.thread.examples.threadlocal;

public class ThreadID extends ThreadLocal<Integer> {

	private int nextId;

	public ThreadID() {
		nextId = 10001;
	}

	private synchronized Integer getNewId() {
		Integer id = new Integer(nextId);
		nextId++;
		return id;
	}

	protected Integer initialValue() {
		print("in intialValue()");
		return getNewId();
	}

	public Integer getThreadID() {
		return get();
	}

	private void print(String msg) {
		System.out.println(Thread.currentThread().getName() + " : " + msg);
	}

}
