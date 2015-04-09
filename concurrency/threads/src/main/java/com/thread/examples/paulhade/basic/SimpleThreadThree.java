package com.thread.examples.paulhade.basic;

public class SimpleThreadThree extends Thread{
	private Thread createrThread;

    public SimpleThreadThree(){
    	createrThread = Thread.currentThread();
    }

    public void printMsg(){
    	Thread t = Thread.currentThread();
    	if(t == createrThread){
    		System.out.println("Creater Thread");
    	}else if( t == this){
    		System.out.println("Child Thread");
    	}else{
    		System.out.println("Mystery Thread");
    	}
    }

    public void run(){
    	for(int i = 0; i < 20; i++){
    		printMsg();
        }
    }

    public static void main(String...args) throws InterruptedException{
    	SimpleThreadThree thread = new SimpleThreadThree();
        thread.start();
       for(int i = 0; i < 10; i++){
        	thread.printMsg();
        	Thread.sleep(1000);
        }
    }

}