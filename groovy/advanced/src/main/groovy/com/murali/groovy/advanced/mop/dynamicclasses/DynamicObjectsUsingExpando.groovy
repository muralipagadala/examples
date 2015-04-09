package com.murali.groovy.advanced.mop.dynamicclasses

data = new File('c:/examples/groovy/advanced/car.dat').readLines()
println data

props = data[0].split(",")
data -= data[0]
println data
println props

def averageMilesDrivenPerYear = { 
	miles.toLong() / (2008 - year.toLong())
}

assert averageMilesDrivenPerYear instanceof Closure

cars = data.collect {
	car = new Expando()
	it.split(", ").eachWithIndex { value, index ->
		car[props[index]] = value
	}
	car.ampy = averageMilesDrivenPerYear
	car
}

props.each { name -> print "$name " }
println " Avg. MPY"

ampyMethod = 'ampy'
cars.each{car ->
	for(String property : props) { print "${car[property]} " }
	println car."$ampyMethod"()
}