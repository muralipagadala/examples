package com.murali.examples.functionalinterfaces;

public class BasicDemoExamples {

	public static void main(String...args){
		Runnable r1 = () -> System.out.println("1.Hello World!");
		process(r1);
		
		Runnable r2 = new Runnable(){
			public void run(){
				System.out.println("2.Hello World!");
			}
		};
		process(r2);
		
		process(() -> System.out.println("3.Hello World!"));
	}
	
	private static void process(Runnable r){
		r.run();
	}
}
