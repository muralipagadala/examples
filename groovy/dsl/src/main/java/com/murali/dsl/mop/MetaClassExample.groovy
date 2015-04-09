package com.murali.dsl.mop

class Customer{
	int id
	String firstName
	String surname
	String street
	String city
	
	Object invokeMethod(String name, Object args) {
		if (name == "prettyPrint") {
			println "#Customer has following properties#"
			this.properties.each {
				println " " + it.key + ": " + it.value
			}
		}
	}
}

def fred = new Customer(id:1001,firstName:"Fred",surname:"Flintstone", street:"1 Rock Road",city:"Bedrock")
def barney = new Customer(id:1002,firstName:"Barney",surname:"Rubble", street:"2 Rock Road",city:"Bedrock")

def customerList = [ fred, barney]

customerList.each{
	it.prettyPrint()
}
