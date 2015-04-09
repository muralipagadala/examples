package com.murali.groovy.advanced

import com.murali.groovy.advanced.test.ClassWithDependency
import groovy.util.GroovyTestCase

class TestUsingAHandTossedMock extends GroovyTestCase{
	void testMethodA() {
		def testObj = new ClassWithDependency()
		def fileMock = new Expando(result:'', write : {result = it}) //new HandTossedFileMock()
		testObj.methodA(1, fileMock)
		assertEquals "The value is 1.", fileMock.result
	}
}


class HandTossedFileMock {
	def result
	def write(value) {
		result = value
	}
}