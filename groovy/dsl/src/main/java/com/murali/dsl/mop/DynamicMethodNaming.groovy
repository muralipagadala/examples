package com.murali.dsl.mop

class CustomerRename {
	def firstName
	def lastName
	def address1
	def address2
}
def c = new CustomerRename()


c.properties.keySet().findAll { !(it =~ /lass/)} .each {
	CustomerRename.metaClass."print_${it}" = { -> println delegate."${it}" }
}

def cust = new CustomerRename(firstName:"Fred",lastName:"Flintstone",	address1:"Rock Road",address2:"Bedrock")

cust.print_firstName()
cust.print_lastName()