package com.thread.examples.basic;

public class TwoThread extends Thread{
	public void run(){
		callAndPrint();
    }
	
	private static void callAndPrint(){
		for( int i = 0; i < 10; i++){
			try {
				System.out.println(currentThread().getName()+" : "+i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String...args){
		Thread currentThread = new TwoThread();
		currentThread.start();
		callAndPrint();
    }
}
