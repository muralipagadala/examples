package com.murali.groovy.advanced.domain

class Car2{
	private int miles = 0
	private final year
	
	Car2(year){
		this.year = year
	}
	
	def getMiles(){
		return miles
	}
	
	private void setMiles(miles){
		throw new IllegalAccessException("you're not allowed to change miles")
	}
	def drive(dist) {
		if (dist > 0) miles += dist
	}
}

def car = new Car2(2012)
println "Year: $car.year"
println "Miles: $car.miles"
println 'Driving'
car.drive(10)
println "Miles: $car.miles"

println 'Can I set the year'
try{
	car.year = 2013
}catch(ReadOnlyPropertyException ex){
	println ex.message
}
println 'Can I set the miles'
try{
	car.miles = 20
}catch(IllegalAccessException ex){
	println ex.message
}