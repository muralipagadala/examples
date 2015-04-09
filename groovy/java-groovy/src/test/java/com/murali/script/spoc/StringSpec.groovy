package com.murali.script.spoc

import spock.lang.Specification

class StringSpec extends Specification{

	String llap
	
	def setup() { llap = 'Live Long and Propser'}
	
	def "LLaP has 21 characters"(){
		expect : llap.size() == 21
	}
	
	def "LLaP has 4 words"() {
		expect: llap.split(/\W/).size() == 4
	}
	
	def "LLaP has 6 vowels"() {
		expect: llap.findAll(/[aeiou]/).size() == 6
	}
	
	def "Access inside the string doesn't throw an exception"() {
		when: llap.charAt(llap.size() - 1)
		then: notThrown(IndexOutOfBoundsException)
	}
	def "Access beyond the end of the string throws exception"() {
		when: llap.charAt(llap.size() + 1)
		then: thrown(IndexOutOfBoundsException)
	}
}
