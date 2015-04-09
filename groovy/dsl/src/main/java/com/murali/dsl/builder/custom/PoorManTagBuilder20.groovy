package com.murali.dsl.builder.custom

class PoorManTagBuilder_1 extends BuilderSupport{

	def indent = 0
	def createNode(name){
		indent.times {print " "}
		println "<${name}>"
		indent++
		return name
	}
	def createNode(name, value){
		indent.times {print " "}
		println "<${name}>" + value
		indent++
		return name
	}
	def createNode(name, Map attributes){
		indent.times {print " "}
		print "<${name} "
		print attributes.collect { "${it.key}='${it.value}'" }.join(' ')
		println ">"
		indent++
		return name
	}
	def createNode(name, Map attributes, value){
		indent.times {print " "}
		print "<${name} "
		print attributes.collect { "${it.key}='${it.value}'" }.join(' ')
		println ">" + value
		indent++
		return name
	}
	void setParent(parent, child){
		// Don't care since we are just streaming to output
	}
	void nodeCompleted(parent, node) {
		indent--
		indent.times {print " "}
		println "</${node}>"
	}
}


def builder = new PoorManTagBuilder_1()
def customers = builder.customers {
	customer {
		id(1001)
		name(firstName:"Fred",surname:"Flintstone")
		address("billing", street:"1 Rock Road",city:"Bedrock")
		address("shipping", street:"1 Rock Road",city:"Bedrock")
	}
}