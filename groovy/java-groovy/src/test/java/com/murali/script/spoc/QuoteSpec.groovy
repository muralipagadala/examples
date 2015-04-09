package com.murali.script.spoc

import spock.lang.Specification

class QuoteSpec extends Specification{
	String quote = """I am endeavoring, ma'am, to construct a
					mnemonic memory circuit, using stone knives and bear skins."""
	
	List<String> strings
	
	def setup(){ strings = quote.tokenize(" ,.") }
	
	def "test string has 16 words"() {
		expect: strings.size() == 15
		
		println strings
	}
	
	def "adding a word increases total by 1"() {
		when: strings << 'Fascinating'
		then: strings.size() == old(strings.size()) + 1
	}
}
