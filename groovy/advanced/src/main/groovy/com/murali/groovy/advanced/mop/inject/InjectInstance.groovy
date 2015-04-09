package com.murali.groovy.advanced.mop.inject

class Person {
	def play() {
		println 'playing...'
	}
}

def emc = new ExpandoMetaClass(Person)
/*emc.sing = {
	'lalalalalla'
}
emc.initialize()*/

def jack = new Person()
def paul = new Person()

//jack.metaClass = emc

jack.metaClass.sing = { ->
	'oh baby baby...'
}

/*jack.metaClass {
	sing = { -> 'oh baby baby...' }
	dance = { -> 'start the music...' }
}
*/
println jack.sing()

try {
	paul.sing()
} catch(ex) {
	println ex
}

jack.metaClass = null
try {
	jack.play()
	jack.sing()
} catch(ex) {
	println ex
}