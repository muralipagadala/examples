package com.murali.groovy.advanced

import com.murali.groovy.advanced.test.CodeWithHeavierDependencies

import groovy.util.GroovyTestCase

class TestUsingExpandoMetaClass extends GroovyTestCase{

	void testMyMethod(){
		def result
		def emc = new ExpandoMetaClass(CodeWithHeavierDependencies, true)
		emc.println = {text -> result - text}
		emc.someAction = {->25}
		emc.initialize()
		
		def testObj = new CodeWithHeavierDependencies()
		testObj.metaClass = emc
		testObj.myMethod()
		assertEquals 35, result
	}
}
