package com.thread.examples.paulhyde.basic.communication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EarlyNotifyProblem {
	private List<String> list;
	
	public EarlyNotifyProblem(){
		list = Collections.synchronizedList(new ArrayList<String>());
	}
	
	public static void print(String msg) {
		System.out.println(Thread.currentThread().getName() + " : " + msg);
	}
	
	public String removeItem()throws InterruptedException {
		print("in removeItem() - entering");
		
		synchronized(list){
			if(list.isEmpty()){
				print("in removeItem() - about to wait()");
				list.wait();
				print("in removeItem() - done with wait()");
			}
			String item = list.get(0);
			print("in removeItem() - leaving\n");
			return item;
		}
	}
	
	public void addItem(String item){
		 print("in addItem() - entering");
		 synchronized(list){
			list.add(item);
			print("in addItem() - just added: ‘" + item + "‘");
			
			// After adding, notify any and all waiting 
			// threads that the list has changed.
			list.notifyAll();
			print("in addItem() - just notified");
		 }
		 print("in addItem() - leaving\n");
	}
	
	public static void main(String...args){
		final EarlyNotifyProblem enp = new EarlyNotifyProblem();
		
		Runnable runA = new Runnable() {
			public void run() {
				try {
					String item = enp.removeItem();
					print("in run() - returned: '" + item + "'");
				} catch ( InterruptedException ix ) {
					print("interrupted!");
				} catch ( Exception x ) {
					print("threw an Exception!!!\n" + x);
				}
			}
		};
	
		Runnable runB = new Runnable() {
			public void run() {
				enp.addItem("Hello!");
			}
		};
	
		try {
			Thread threadA1 = new Thread(runA, "threadA1");
			threadA1.start();
	
			Thread.sleep(500);
	
			// start a *second* thread trying to remove
			Thread threadA2 = new Thread(runA, "threadA2");
			threadA2.start();
	
			Thread.sleep(500);
	
			Thread threadB = new Thread(runB, "threadB");
			threadB.start();
	
			Thread.sleep(10000); // wait 10 seconds
	
			threadA1.interrupt();
			threadA2.interrupt();
		} catch ( InterruptedException x ) {
			x.printStackTrace();
		}
	}
}
