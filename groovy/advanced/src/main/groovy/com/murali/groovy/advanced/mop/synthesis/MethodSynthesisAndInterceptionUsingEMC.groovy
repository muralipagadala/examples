package com.murali.groovy.advanced.mop.synthesis

class Person5 {
  def work() { "working..." }
}

Person5.metaClass.invokeMethod = { String name, args ->
  System.out.println "intercepting call for ${name}"
  
  def method = Person5.metaClass.getMetaMethod(name, args)
  
  if (method) {
    method.invoke(delegate, args)
  } else {
    Person5.metaClass.invokeMissingMethod(delegate, name, args)
  }
} 

Person5.metaClass.methodMissing = { String name, args ->
  def plays = ['Tennis', 'VolleyBall', 'BasketBall']

  System.out.println "methodMissing called for ${name}"
  def methodInList = plays.find { it == name.split('play')[1]}
  
  if (methodInList) {
    def impl = { Object[] vargs ->
        "playing ${name.split('play')[1]}..."
    }
      
    Person5.metaClass."$name" = impl //future calls will use this
    
    impl(args)
  } else {
    throw new MissingMethodException(name, Person5.class, args)
  }
}

jack = new Person5()
println jack.work()
println jack.playTennis()
println jack.playTennis()