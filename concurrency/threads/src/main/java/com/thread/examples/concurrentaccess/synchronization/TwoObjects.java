package com.thread.examples.concurrentaccess.synchronization;

public class TwoObjects {

	private String objId;
	
	public TwoObjects(String objId){
		this.objId = objId;
	}
	
	public void print(String msg){
		threadPrint("objID=" + objId + " - " + msg);
	}
	
	public static void threadPrint(String msg) {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " : " + msg);
	}
	
	private synchronized void doStuff(int value){
		print("Entering - doStuff()");
		int num = value * 2 + objId.length();
		print("in doStuff() - local variable num=" + num);
		
		try{
			Thread.sleep(2000);
		}catch(InterruptedException ie){
			
		}
		print("Leaving - doStuff()\n\n");
	}
	
	public static void main(String...args){
		final TwoObjects o1 = new TwoObjects("obj-1");
		final TwoObjects o2 = new TwoObjects("obj-2");
		
		Runnable r = new Runnable(){
			public void run(){
				o1.doStuff(3);
			}
		};
		
		Thread t = new Thread(r, "Thread-A");
		t.start();
		
		try {
			Thread.sleep(200);
		}
		catch (InterruptedException x) {
		}
		
		Runnable r2 = new Runnable(){
			public void run(){
				o2.doStuff(7);
			}
		};
		
		Thread t2 = new Thread(r2, "Thread-B");
		t2.start();
	}
}
