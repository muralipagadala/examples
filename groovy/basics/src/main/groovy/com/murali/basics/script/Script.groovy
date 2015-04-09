println "hello world from groovy version ${GroovySystem.version}"
def nick = 'ReGina'
def book = 'Groovy In Action'

assert "$nick is $book" == 'ReGina is Groovy In Action'

def x = 2
def y = 3
assert x + y == 5

assert x.plus(y) == 5
assert x instanceof Integer

def roman = ['', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII']
assert roman[4] == 'IV'

def http = [
		100:'CONTINUE',
		200:'OK',
		400:'BAD REQUEST'
	]

assert http[100] == 'CONTINUE'
assert http[200] == 'OK'

//Ranges

def range = 1..10
assert range.contains(5)
assert !range.contains(15)
assert range.size() == 10
assert range.from == 1
assert range.to == 10
assert range.reverse() == 10..1

//List.each method takes single parameter - Closure
roman.each{entry -> println entry}
