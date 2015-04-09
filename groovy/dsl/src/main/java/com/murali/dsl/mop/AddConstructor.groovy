package com.murali.dsl.mop

class Emp {
	def firstName
	def lastName
	def address1
	def address2
}

Emp.metaClass.constructor = {
	String first, String last ->
	new Emp(firstName:first, lastName:last)
}
def e2 = new Emp('Murali', 'Pagadala')

def e = new Emp(firstName:'Murali',lastName:'Pagadala')
