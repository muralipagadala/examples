package com.murali.groovy.language.groovybeans

import groovy.transform.Immutable

@Immutable
class FixedBook {
	String title
}

def gina = new FixedBook(title:'Groovy In Action')
def regina = new FixedBook(title:'Groovy In Action')

assert gina.title == 'Groovy In Action'
assert gina == regina //If I remove @Immuatable this assertion fails why.


try{
	gina.title = 'Oops'
	assert false, 'Should not reach here'
}catch(ReadOnlyPropertyException expected){
	println "Error $expected.message"
}
