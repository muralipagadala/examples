package com.murali.groovy.advanced.mop.synthesis

class Person3 implements GroovyInterceptable {
	def work() { "working..." }
	def plays = ['Tennis', 'VolleyBall', 'BasketBall']
	
	def invokeMethod(String name, args) {
	  System.out.println "intercepting call for $name"
	  
	  def method = metaClass.getMetaMethod(name, args)
	  
	  if (method) {
		method.invoke(this, args)
	  } else {
		metaClass.invokeMethod(this, name, args)
	  }
	}
	 
	def methodMissing(String name, args) {
	  System.out.println "methodMissing called for $name"
	  def methodInList = plays.find { it == name.split('play')[1]}
	  
	  if (methodInList) {
		def impl = { Object[] vargs ->
			"playing ${name.split('play')[1]}..."
		  }
		  
		Person3 instance = this
		instance.metaClass."$name" = impl //future calls will use this
  
		impl(args)
	  } else {
		throw new MissingMethodException(name, Person3.class, args)
	  }
	}
  }
  
  jack = new Person3()
  println jack.work()
  println jack.playTennis()
  println jack.playTennis()