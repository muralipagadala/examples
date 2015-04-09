package com.murali.script;

import org.testng.annotations.Test

import spock.lang.Specification

import com.murali.script.groovy.ast.ImmutablePoint

class ImmutablePointTest  extends Specification{
	def point = [x:3,y:4] as ImmutablePoint
	
	def "can use map ctor for immutable"(){
		expect : [3,4] == [point.x, point.y]
	}
	
	def "can't change x"(){
		when: point.x = 5
		then : thrown(ReadOnlyPropertyException)
	}
	
	def "can't change y"() {
		when: p.y = 5
		then: thrown(ReadOnlyPropertyException)
	}

}
