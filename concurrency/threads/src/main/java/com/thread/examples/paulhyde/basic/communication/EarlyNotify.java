package com.thread.examples.paulhyde.basic.communication;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EarlyNotify {

	private List<String> list;

	public EarlyNotify() {
		list = Collections.synchronizedList(new LinkedList<String>());
	}

	public static void print(String msg) {
		System.out.println(Thread.currentThread().getName() + " : " + msg);
	}

	public String removeItem() throws InterruptedException {
		print("in removeItem() - entering");
		synchronized (list) {
			while (list.isEmpty()) {
				print("in removeItem() - about to wait");
				list.wait();
				print("in removeItem() - done with wait");
			}
			print("in removeItem() - leaving");
			return list.remove(0);
		}
	}

	public void addItem(String item) {
		print("in addItem() - entering");
		synchronized (list) {
			list.add(item);
			print("in addItem() - just added item :" + item);

			list.notifyAll();
			print("in addItem() - just notified");
		}
		print("in addItem() - leaving");
	}

	public static void main(String... args) {
		final EarlyNotify ea = new EarlyNotify();

		Runnable r1 = new Runnable() {
			public void run() {
				try {
					String item = ea.removeItem();
					print("in run() - returned item :" + item);
				} catch (InterruptedException e) {
					print("Interrupted");
				} catch (Exception e) {
					print("Threw Exception !!!\n " + e);
				}
			}
		};

		Runnable r2 = new Runnable() {
			public void run() {
				ea.addItem("Hello");
			}
		};

		try {
			Thread a1 = new Thread(r1, "Thread-A1");
			a1.start();

			Thread.sleep(500);

			Thread a2 = new Thread(r1, "Thread-A2");
			a2.start();

			Thread.sleep(500);

			Thread b1 = new Thread(r2, "Thread-B");
			b1.start();

			Thread.sleep(10000);

			a1.interrupt();
			a2.interrupt();

		} catch (InterruptedException ie) {

		}

	}
}