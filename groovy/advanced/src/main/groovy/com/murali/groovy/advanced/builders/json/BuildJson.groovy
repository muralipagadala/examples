package com.murali.groovy.advanced.builders.json

class Person {
	String first
	String last
	def sigs
	def tools
}
john = new Person(first: "John", last: "Smith",
sigs: ['Java', 'Groovy'], tools: ['script': 'Groovy', 'test': 'Spock'])

builder = new groovy.json.JsonBuilder(john)

writer = new StringWriter()
builder.writeTo(writer)
println writer

builder = new groovy.json.JsonBuilder()

builder{
	firstName john.first
	lastName john.last
	"special interest groups" john.sigs
	"preferred tools" {
		numberOfTools john.tools.size()
		tools john.tools
		}
}
writer.flush()
writer.close()

writer = new StringWriter()
builder.writeTo(writer)
println writer