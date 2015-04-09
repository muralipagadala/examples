package com.murali.groovy.advanced.mop

import groovy.util.GroovyTestCase

class MyGroovyTest extends GroovyTestCase{
	public void testAdd(){
		assert 1 == 1
		assert 2 + 2 == 4 : "We're in trouble, arithmetic is broken"
	}
}
