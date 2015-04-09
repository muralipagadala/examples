package com.murali.groovy.language.closures

//this : refers to the instance of the class that the closure was defined in.
//owner: is the same as this, unless the closure was defined inside another closure in which case the owner refers to the outer closure.
//delegate: is the same as owner. But, it is the only one that can be programmatically changed, and it is the one that makes Groovy closures really powerful.

class MyClass {
	def outerClosure = {
		println this.class.name
		println owner.class.name
		println delegate.class.name
		
		def nestedClosure = {
			println '\n'
			println this.class.name
			println owner.class.name
			println delegate.class.name
		}
		nestedClosure()
	}
} 

def closure = new MyClass().outerClosure
closure()

println '\n'

class Simple{
	String simple = "Simple"
	def outerClosure = {
		println simple
		def nestedClosure = {
			println simple
		}
		nestedClosure()
	}
}

Simple simple = new Simple()
def simpleClosure = new Simple().outerClosure
simpleClosure()
println simple.simple
