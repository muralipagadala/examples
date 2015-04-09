package com.murali.groovy.advanced.mop.inject


class Person_1 {
	String firstName
	String lastName
	String getName() {
		"$firstName $lastName"
	}
}

class Friend {
	def listen() {
		"$name is listening as a friend"
	}
}

Person_1.mixin Friend

john = new Person_1(firstName: "John", lastName: "Smith")
println john.listen()

class Dog {
	String name
}

Dog.mixin Friend

buddy = new Dog(name: "Buddy")
println buddy.listen()

class Cat {
	String name
}
try {
	rude = new Cat(name: "Rude")
	rude.listen()
} catch(ex) {
	println ex.message
}

socks = new Cat(name: "Socks")
socks.metaClass.mixin Friend
println socks.listen()