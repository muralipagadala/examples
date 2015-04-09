package com.murali.groovy.advanced.mop.inject

Integer.metaClass.daysFromNow = {
	->
	Calendar today = Calendar.instance
	today.add(Calendar.DAY_OF_MONTH, delegate)
	today.time
}
println 5.daysFromNow()

Integer.metaClass.'static'.isEven = {val -> val %2 == 0}

println "Is 2 even? " + Integer.isEven(2)
println "Is 3 even? " + Integer.isEven(3)

Integer.metaClass.constructor << {
	Calendar calendar -> calendar.get(Calendar.DAY_OF_YEAR)
}

println "Today's Date ${new Integer(Calendar.instance)}"

Integer.metaClass.constructor = { int val ->
	println "Intercepting constructor call"
	constructor = Integer.class.getConstructor(Integer.TYPE)
	constructor.newInstance(val)
}
println new Integer(4)
println new Integer(Calendar.instance)