package com.murali.dsl.builder.custom

import java.util.Map;

class LogBuilder extends BuilderSupport{
	def indent = 0

	@Override
	protected void setParent(Object parent, Object child) {
		indent.times {print " "}
		println "setParent(${parent}, ${child})"
	}

	@Override
	protected Object createNode(Object name) {
		indent.times {print " "}
		println "createNode(${name})"
		indent++
		return name
	}

	@Override
	protected Object createNode(Object name, Object value) {
		indent.times {print " "}
		println "createNode(${name}, ${value})"
		indent++
		return name
	}

	@Override
	protected Object createNode(Object name, Map attributes) {
		indent.times {print " "}
		println "createNode(${name}, ${attributes})"
		indent++
		return name
	}

	@Override
	protected Object createNode(Object name, Map attributes, Object value) {
		indent.times {print " "}
		println "createNode(${name}, ${attributes}, ${value})"
		indent++
		return name
	}
	void nodeCompleted(parent, node) {
		indent--
		indent.times {print " "}
		println "nodeCompleted(${parent}, ${node})"
	}
}

def builder = new LogBuilder()

def customers = builder.customers{
	customer{
		id(1001){
			name(firstName:"Fred",surname:"Flintstone")
			address("billing", street:"1 Rock Road",city:"Bedrock")
			address("shipping", street:"1 Rock Road",city:"Bedrock")
		}
	}
}
