package com.murali.groovy.advanced

import groovy.util.GroovyTestCase

class ListTest extends GroovyTestCase{
	void testListSize(){
		def list = [1,2]
		assertEquals "ArrayList size must be 2", 2, list.size()
	}
}
