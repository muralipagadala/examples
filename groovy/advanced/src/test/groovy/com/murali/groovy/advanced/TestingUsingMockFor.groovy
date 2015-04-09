package com.murali.groovy.advanced

import groovy.util.GroovyTestCase;
import com.murali.groovy.advanced.test.ClassWithDependency

class TestingUsingMockFor extends GroovyTestCase {
	void testMethodA(){
		def testObj = new ClassWithDependency()
		
		def fileMock = new groovy.mock.interceptor.MockFor(java.io.FileWriter)
		def text
		fileMock.demand.write {text = it.toString()}
		fileMock.demand.close{}
		
		fileMock.use{
			testObj.methodC(1)
		}
		assertEquals "The value is 1.", text
	}
}
