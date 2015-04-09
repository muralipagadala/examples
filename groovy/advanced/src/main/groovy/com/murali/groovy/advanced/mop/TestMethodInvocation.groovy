package com.murali.groovy.advanced.mop

import groovy.util.GroovyTestCase

class TestMethodInvocation extends GroovyTestCase{

	void testInterceptedMethodCallonPOJO() {
		def val = new Integer(3)
		Integer.metaClass.toString = {->'Intercepted'}
		assertEquals 'Intercepted', val.toString()
	}
	
	void testInterceptableCalled() {
		def obj = new AnInterceptable()
		assertEquals 'intercepted', obj.existingMethod()
		assertEquals 'intercepted', obj.nonExistingMethod()
	}
	
	void testInterceptedExistingMethodCalled() {
		AGroovyObject.metaClass.existingMethod2 = {-> 'intercepted' }
		def obj = new AGroovyObject()
		assertEquals 'intercepted', obj.existingMethod2()
	}
	
	void testUnInterceptedExistingMethodCalled() {
		def obj = new AGroovyObject()
		assertEquals 'existingMethod', obj.existingMethod()
	}
	
	void testPropertyThatIsClosureCalled() {
		def obj = new AGroovyObject()
		assertEquals 'closure called', obj.closureProp()
	}
	
	class AGroovyObject {
		def existingMethod() { 'existingMethod' }
		def existingMethod2() { 'existingMethod2' }
		def closureProp = { 'closure called' }
	}
	
	class AnInterceptable implements GroovyInterceptable {
		def existingMethod() { }
		def invokeMethod(String name, args) { 
			'intercepted' 
		}
	}
	
	void testMethodMissingCalledOnlyForNonExistent() {
	    def obj = new ClassWithInvokeAndMissingMethod()
	    assertEquals 'existingMethod', obj.existingMethod()
	    assertEquals 'missing called', obj.nonExistingMethod()
	  }

	void testInvokeMethodCalledForOnlyNonExistent() {
	    def obj = new ClassWithInvokeOnly()
	    assertEquals 'existingMethod', obj.existingMethod()
	    assertEquals 'invoke called', obj.nonExistingMethod()
	  }
  
	void testMethodFailsOnNonExistent() {
	    def obj = new TestMethodInvocation()
	    shouldFail (MissingMethodException) { obj.nonExistingMethod() }
	  }
	
	class ClassWithInvokeAndMissingMethod {
		def existingMethod() { 'existingMethod' }
		def invokeMethod(String name, args) { 'invoke called' }
		def methodMissing(String name, args) { 'missing called' }
	}
	class ClassWithInvokeOnly {
		def existingMethod() { 'existingMethod' }
		def invokeMethod(String name, args) { 'invoke called' }
	}
}
