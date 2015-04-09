package com.murali.dsl.builder.custom

def method1(params, Closure closure){
	println "method1 $params"
	closure.call()
}

def method2(Closure closure){
	println 'method2'
	closure.call()
}

def method3(params){
	println "methods3 $params"
}

//Script scope
method1(param:'one'){ //Closure1 scope
	method2(){ //Closure2 scope
		method3 'hello'
	}//End Closure2
	method1(123){ //Closure3 scope 
		method1('nested'){ //Closure4 scope
			method3 10 // Owner of this is immediate method1
		}//End of Closure4 
	}//End of Closure3
}//End of Closure1

println 'Closure calls completed'
/**
 * Analysis
 * 
 * method1 is called with param:'one' and a Closure1
 * method1 prints the param and calls Closure1
 * Closure1 calls method2 and calls the Closure 2
 * 		Closure2 calls the method3 with a param as 'hello'
 * 		Closure2 completes
 * Closure1 calls the method1 with param 123
 * 		method1 println 123 and calls Closure 3
 * 				Closure 3 calls method1 with param 'nested' and calls Closure4
 * 					Closure4 completes
 * 				Closure 3 completes
 * Closure1 completes
 * 
 */
