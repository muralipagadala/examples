package com.thread.examples.threadlocal;

public class ThreadIDMain implements Runnable {

	private ThreadID var;

	public ThreadIDMain(ThreadID var) {
		this.var = var;
	}

	public void run() {
		try {
			print("var.getThreadId=" + var.getThreadID());
			Thread.sleep(2000);
			print("var.getThreadId=" + var.getThreadID());
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	public static void print(String msg) {
		System.out.println(Thread.currentThread().getName() + " : " + msg);
	}

	public static void main(String... args) {
		ThreadID tid = new ThreadID();
		ThreadIDMain shared = new ThreadIDMain(tid);

		try {
			Thread t1 = new Thread(shared, "Thread-A");
			t1.start();

			Thread.sleep(500);

			Thread t2 = new Thread(shared, "Thread-B");
			t2.start();

			Thread.sleep(500);

			Thread t3 = new Thread(shared, "Thread-C");
			t3.start();
		} catch (InterruptedException ie) {
			print("Interrupted");
		}

	}
}