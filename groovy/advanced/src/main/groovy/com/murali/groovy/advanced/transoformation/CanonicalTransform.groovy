package com.murali.groovy.advanced.transoformation

import groovy.transform.*

@Canonical(excludes="lastName, age")
class Person{
	String firstName
	String lastName
	int age
}

def sara = new Person(firstName: "Sara", lastName: "Walker", age: 49)
println sara