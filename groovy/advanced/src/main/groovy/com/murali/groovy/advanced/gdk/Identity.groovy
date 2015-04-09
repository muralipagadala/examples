package com.murali.groovy.advanced.gdk

list = [1, 2, 3]

list.with{
	add(3)
	add(4)
	println list
}

list.with {
	println "this is ${this},"
	println "owner is ${owner},"
	println "delegate is ${delegate}."
}