package com.murali.groovy.advanced

import groovy.util.GroovyTestCase

import com.murali.groovy.advanced.test.CodeWithHeavierDependencies

class TestUsingCategories extends GroovyTestCase{
	void testMyMethod(){
		def testObj = new CodeWithHeavierDependencies();
		
		use(MockHelper){
			testObj.myMethod()
			assertEquals 35, MockHelper.result
		}
	}
}

class MockHelper {
	def static result
	def static println(self, text) {
		result = text
	}
	def static someAction(CodeWithHeavierDependencies self) {
		25
	}
}