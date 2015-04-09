package com.murali.examples.beans

import groovy.util.GroovyTestCase

class ExpectException extends GroovyTestCase{

	def divide(a, b) {
		a/b
	}

	void testExpectExceptionUsingTry() {
		try {
			divide(2, 0)
			fail "Expected ArithmeticException ..."
		} catch(ArithmeticException ex) {
			assertTrue true
		}
	}
	
	void testExpectException(){
		shouldFail{divide(2,0)}
		shouldFail(ArithmeticException){divide(2,0)}
		shouldFail ArithmeticException, {divide(2,0)}
	}
}
