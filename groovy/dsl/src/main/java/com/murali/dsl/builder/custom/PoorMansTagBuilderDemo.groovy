package com.murali.dsl.builder.custom

class PoorMansTagBuilder {
	int indent = 0
	def methodMissing(String name, args) {
		indent.times {print " "}
		println "<${name}>"
		indent++
		args[0].delegate = this // Change delegate to the builder
		args[0].call()
		indent--
		indent.times {print " "}
		println "</${name}>"
	}
}

def builder = new PoorMansTagBuilder()

builder.root{
	level1{
		level2{
			
		}
	}
}