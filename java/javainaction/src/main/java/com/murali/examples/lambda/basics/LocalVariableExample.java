package com.murali.examples.lambda.basics;

/**
 * free variables / capturing lambdas 
 * @author Murali Pagadala
 *
 */
public class LocalVariableExample {

	public static void main(String...args) {
		int portNumber = 1337;
		Runnable r = () -> System.out.println(portNumber);
		//portNumber = 1338; // Error : local variables referenced from a lambda expression must be final or effectively final
	}
}
