package com.murali.groovy.advanced.mop.dynamicclasses

carA = new Expando(year:2010, miles:0)
assert carA.year == 2010
assert carA.miles == 0

println carA

car = new Expando(year: 2012, miles: 0, turn: { println 'turning...' })

car.drive ={
	miles += 10
	println "$miles miles driven"
}

car.drive()
car.turn()