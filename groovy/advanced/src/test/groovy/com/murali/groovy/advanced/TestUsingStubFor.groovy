package com.murali.groovy.advanced

import com.murali.groovy.advanced.test.ClassWithDependency
import groovy.util.GroovyTestCase

class TestUsingStubFor extends GroovyTestCase {
	void testMethodA(){
		def testObj = new ClassWithDependency()
		
		//def fileMock = new groovy.mock.interceptor.StubFor(java.io.FileWriter)
		def fileMock = new groovy.mock.interceptor.MockFor(java.io.FileWriter)
		def text
		fileMock.demand.write {text = it.toString()}
		fileMock.demand.close{}
		
		fileMock.use{
			testObj.methodB(1)
		}
		assertEquals "The value is 1.", text
	}
}
