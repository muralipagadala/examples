package com.murali.groovy.advanced.mop.synthesis

class Person2 {
	def work() { "working..." }
  
	def plays = ['Tennis', 'VolleyBall', 'BasketBall']
	
	def methodMissing(String name, args) {
	  System.out.println "methodMissing called for $name"
	  def methodInList = plays.find { it == name.split('play')[1]}
	  
	  if (methodInList) {
		def impl = { Object[] vargs ->
			"playing ${name.split('play')[1]}..."
		}
		  
		Person2 instance = this
		instance.metaClass."$name" = impl //future calls will use this
		
		impl(args)
	  } else {
		throw new MissingMethodException(name, Person2.class, args)
	  }
	}
  }
  
  jack = new Person2()
  println jack.playTennis()
  println jack.playTennis()