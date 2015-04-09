package com.murali.groovy.advanced.construct

enum CoffeeSize { SHORT, SMALL, MEDIUM, LARGE, MUG }

def orderCoffee(size){
	println "Order for coffee received with size $size"
	switch(size){
		case [CoffeeSize.SMALL, CoffeeSize.SHORT] : 
		println "you're health conscious"
		break
		case CoffeeSize.MEDIUM..CoffeeSize.LARGE:
		println "you gotta be a programmer"
		break
		case CoffeeSize.MUG:
		println "you should try Caffeine IV"
		break
	}
}

orderCoffee(CoffeeSize.SMALL)
orderCoffee(CoffeeSize.LARGE)
orderCoffee(CoffeeSize.MUG)
print 'Available sizes are: '
for(size in CoffeeSize.values()){
	println size
}