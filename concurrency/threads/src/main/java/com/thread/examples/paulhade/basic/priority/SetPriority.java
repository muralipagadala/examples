package com.thread.examples.paulhade.basic.priority;

public class SetPriority {
	
	public static void main(String...args){
		Thread a = new Thread(makeRunnable(), "ThreadA");
		a.setPriority(8);
		a.start();
		
		Thread b = new Thread(makeRunnable(), "ThreadB");
		b.setPriority(2);
		b.start();
		
		Runnable r = new Runnable(){
			public void run(){
				Thread t = new Thread(makeRunnable(), "ThreadC");
			}
		};
		
		Thread d = new Thread(r, "ThreadD");
		d.setPriority(7);
		d.start();
		
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
			
		}
		a.setPriority(3);
		System.out.println("in main() - threadA.getPriority()=" + a.getPriority()); 
	}

	private static Runnable makeRunnable() {
		Runnable r = new Runnable() {
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("in run() - priority=" +Thread.currentThread().getPriority() +", name=" + Thread.currentThread().getName()); 
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		return r;
	}
}
