package com.murali.dsl.builder

class CustomBuilderExample {

	int indent = 0;
	
	Object invokeMethod(String name, Object args){
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

def builder = new CustomBuilderExample ()
builder.murali{
	level1{
		level2{
			level3{
				
			}
		}
	}
}
