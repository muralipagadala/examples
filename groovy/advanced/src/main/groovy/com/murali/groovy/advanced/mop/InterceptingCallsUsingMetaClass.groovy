package com.murali.groovy.advanced.mop


class Vehicle {
	def check() {
		System.out.println "check called..."
	}

	def start() {
		System.out.println "start called..."
	}

	def drive() {
		System.out.println "drive called..."
	}
}

Vehicle.metaClass.invokeMethod = { String name, args ->
	System.out.println("Call to $name interpreted..")
	
	if(name != 'check'){
		System.out.println("Running Filter...")
		Vehicle.metaClass.getMetaMethod('check').invoke(delegate, null)
	}
	
	def validMethod = Vehicle.metaClass.getMetaMethod(name, args)
	if(validMethod){
		validMethod.invoke(delegate, args)
	}else{
		Vehicle.metaClass.invokeMissingMethod(delegate, name,args)
	}
}
	
car = new Vehicle()

car.start()
car.drive()
car.check()
try {
  car.speed()
} catch(Exception ex) {
  println ex
}