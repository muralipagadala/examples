package com.murali.groovy.advanced.domain

class Car {
	private def miles = 0
	private final year
	
	Car(year){
		this.year = year
	}
}

Car car = new Car(2008)
println "Year: $car.year"
println "Miles: $car.miles"
println 'Setting miles'
car.miles = 25
println "Miles: $car.miles"