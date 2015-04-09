package com.thread.examples.interrupt;

/**
 * the main thread interrupts itself (line 17). This does not have any effect other 
 * than setting an interrupted flag (which is internal to Thread) to true. 
 * ALTHOUGH INTERRUPTED, THE MAIN THREAD KEEPS RUNNING. 
 * The main thread proceeds to make note of the current real-time clock (line 7) 
 * and enters the try block (line 8). As soon as the sleep() is invoked (line 9), 
 * it notices that there is a pending interrupt and immediately throws an InterruptedException. 
 * @author MPAGTPNY
 *
 */
public class PendingInterrupt {

	public static void main(String... args) {
		if (args.length > 0) {
			Thread.currentThread().interrupt();
		}

		long startTime = System.currentTimeMillis();
		System.out.println("Thread interrutped :"+ Thread.currentThread().isInterrupted());
		try {
			Thread.sleep(2000);
			System.out.println("was NOT interrupted");

		} catch (InterruptedException x) {
			System.out.println("was interrupted");
		}

		System.out.println("elapsedTime="+ (System.currentTimeMillis() - startTime));

	}
}