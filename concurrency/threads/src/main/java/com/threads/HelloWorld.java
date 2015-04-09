package com.threads;

public class HelloWorld {
	private static String[] nums = new String[10000000];
	public static void main(String... args) {
		for (int i = 0; i < 10000000; i++) {
			System.out.println("Hello :"+i);
			nums[i] = "Hello "+i;
		}
	}
}
