package com.murali.groovy.advanced.gdk

class Car{
	def miles, fuelLevel
}

def car = new Car(miles:20, fuelLevel:50)

properties = ['miles', 'fuelLevel']

properties.each{ name -> 
	println "$name = ${car[name]}"
}

car[properties[1]] = 100
println "Car fuel level is now ${car.fuelLevel}"