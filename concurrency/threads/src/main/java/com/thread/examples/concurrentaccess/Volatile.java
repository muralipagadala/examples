package com.thread.examples.concurrentaccess;

/**
 * Analysis : this program demonstrates the volatile key word
 * if boolean missedIt is not a volatile then run method runs 
 * forever, bcz it couldn't see the change in "value" member variable.
 * 
 * Either placing the volatile before value or missedIt will work.
 * If volatile is missing then run() method runs forever.
 * 
 * Volatile : JLS says that individual threads are permitted to have
 * a local copy of the member variable for performance reasons. But if the
 * multiple threads update/modify the same variable, other threads cannot 
 * see the update. Hence specify the variable as volatile.
 *
 */
public class Volatile implements Runnable{
	private int value;
	private volatile boolean missedIt;
	private long creationTime;
	
	public Volatile(){
		value = 10;
		missedIt = false;
		creationTime = System.currentTimeMillis();
	}

	public static void main(String...args){
		Volatile volatileDemo = new Volatile();
		try{
			Thread.sleep(200);
			
			Thread engine = new Thread( volatileDemo );
			engine.start();
			
			Thread.sleep(200);
			
			volatileDemo.workMethod();
		}catch(InterruptedException ie){
			
		}		
	}
	
	public void workMethod()throws InterruptedException{
		print("Entering workMethod()");
		
		print("in workMethod() about to sleep for 2 seconds");
		Thread.sleep(2000);
		
		
		value = 50;
		print("in workMethod() - just set value=" + value);
		
		print("in workMethod() about to sleep for 5 seconds");
		Thread.sleep(5000);
		
		missedIt = true;
		print("in workMethod() - just set missedIt=" + missedIt);
		
		print("in workMethod() about to sleep for 3 seconds");
		Thread.sleep(3000);
		
		print("Leaving workMethod()");
	}
	
	public void run(){
		print("Entering run()");
		
		while(value < 20){
			if(missedIt){
				int currentValue = value;
				Object lock = new Object();
				synchronized(lock){

				}
				int valueAfterSync = value;
				print("in run() - see value=" + currentValue +  ", but rumor has it that it changed!");  
				print("in run() - valueAfterSync=" +valueAfterSync);  
				break;  
			}
		}
		print("Leaving run()");
	}
	
	private void print(String msg) {
		long interval = System.currentTimeMillis() - creationTime;
		String tmpStr = "    " + ( interval / 1000.0 ) + "000";
		
		int pos = tmpStr.indexOf(".");
		String secStr = tmpStr.substring(pos - 2, pos + 4);

		String nameStr = "        " + Thread.currentThread().getName();
		nameStr = nameStr.substring(nameStr.length() - 8, nameStr.length());
		System.out.println(secStr + " " + nameStr + ": " + msg);
	}

}
