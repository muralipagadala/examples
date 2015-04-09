import groovy.util.Expando

def customer = new Expando()
assert customer.properties == [:]

assert customer.id == null

customer.id = 1001

customer.firstName = "Fred"
customer.surname = "Flintstone"
customer.street = "1 Rock Road"
assert customer.id == 1001
assert customer.properties == [
	id:1001, firstName:'Fred',
	surname:'Flintstone', street:'1 Rock Road']
customer.properties.each { println it }

customer.prettyPrint = {
	println "Customer has following properties"
	customer.properties.each {
		if (it.key != 'prettyPrint')
			println " " + it.key + ": " + it.value
	}
}

customer.prettyPrint()