package com.thread.examples.paulhade.basic.priority;

public class GetPriority {

	public static void main(String... args) {
		System.out.println(Thread.currentThread().getName() + " --> "+ Thread.currentThread().getPriority());

		Thread t = new Thread(makeRunnable(), "ChildThread");
		t.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static Runnable makeRunnable() {
		Runnable r = new Runnable() {
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println(Thread.currentThread().getName()+ " --> " + Thread.currentThread().getPriority());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		return r;
	}
}
