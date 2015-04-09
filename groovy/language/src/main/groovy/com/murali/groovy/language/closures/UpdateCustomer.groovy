class Customer{
	int id
	String name
}


def getCustomerRecord(id){
	new Customer(id:id, name:'Murali')
}

/*def withCustomer (id, c ) {
	def cust = getCustomerRecord(id)
	c.call(cust)
}
withCustomer(12345) { 
	customer -> println "Found customer ${customer.name}" 
}
*/
def locked(Closure c){
	println "Transaction lock"
	c()
	println "Transaction release"
}

def updateCustomer (id, c) {
	println "get customer record"
	Customer cust = getCustomerRecord(id)
	println "Customer name was ${cust.name}"
	c.call(cust)
	println "Customer name is now ${cust.name}"
	println "save customer record"
	//saveCustomerRecord(cust)
}

locked{
	updateCustomer(12){customer ->
		customer.name = 'Barney'
	}
}