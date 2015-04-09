package com.murali.groovy.advanced

import com.murali.groovy.advanced.test.CodeWithHeavierDependenciesExt

import groovy.util.GroovyTestCase

class TestCodeWithHeavierDependenciesUsingOverriding extends GroovyTestCase{
	void testMyMethod(){
		def testObj = new CodeWithHeavierDependenciesExt()
		testObj.myMethod()
		assertEquals 35, testObj.result
	}
	
	void testMyJavaMethod() {
		def testObj = new ExtendedJavaCode()
		
		def originalPrintStream = System.out
		def printMock = new PrintMock()
		System.out = printMock
		
		try {
			testObj.myMethod()
		} finally {
			System.out = originalPrintStream
		}
		assertEquals 35, printMock.result
	}
}


class PrintMock extends PrintStream {
	PrintMock() {
		super(System.out)
	}
	def result
	void println(int text) {
		result = text
	}
}