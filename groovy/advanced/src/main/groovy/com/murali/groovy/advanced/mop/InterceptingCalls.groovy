package com.murali.groovy.advanced.mop

class Car implements GroovyInterceptable{
	def check() {
		System.out.println "check called..."
	}
	def start() {
		System.out.println "start called..."
	}
	def drive() {
		System.out.println "drive called..."
	}
	
	def invokeMethod(String name, args){
		System.out.println("Call to $name intercepted...")
		if(name != 'check'){
			System.out.print("running filter... ")
			Car.metaClass.getMetaMethod('check').invoke(this, null)
		}
		
		def validMethod = Car.metaClass.getMetaMethod(name)
		
		if (validMethod != null) {
			validMethod.invoke(this, args)
		} else {
			Car.metaClass.invokeMethod(this, name, args)
		}
	}
	
	
}

car = new Car()

car.start()
car.drive()
car.check()
try {
  //car.speed()
} catch(Exception ex) {
  println ex
}