package com.murali.script.spoc

import spock.lang.Specification

import spock.lang.Unroll;

class HelloSpock extends Specification{

	@Unroll
	def "#name should be #length"(){
		expect : name.size() == length
		
		where:
		name | length
		"Spock" | 5
		"Kirk" | 4
		"Scotty" | 6
		'McCoy' | 5
	}
	
	def "check lengths using arrays"() {
		expect: name.size() == length

		where:
		name << ["Spock","Kirk","Scotty"]
		length << [5,4,6]
	}
	
	def "check lengths using pairs"() {
		expect: name.size() == length
		where:
		[name,length] << [["Spock",5],["Kirk",4],["Scotty",6]]
	}
}
