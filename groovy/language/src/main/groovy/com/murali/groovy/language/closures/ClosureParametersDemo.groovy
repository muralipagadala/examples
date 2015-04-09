def list = [1, 2, 3, 5, 7]
def defaultParams = { print it }
def dynamicParams = { something -> println something }
def intParams = { int something -> println something }
def stringParams = { String something -> println something }

assert list.each { defaultParams}
assert list.each { dynamicParams } 
assert list.each { intParams }
//list.each stringParams

def greet = { name -> println "Hello ${name}"}
//greet "Murali", "Pagadala"

greet = { firstName, lastName -> println "Hello, $firstName  $lastName"}
//assert greet( "Murali", "Pagadala" ) == 'Hello, Murali  Pagadala'

greet = { -> println 'Hello World' }

def exception = false
try{
	greet "Murali"
}catch(Exception e){
	exception = true
}
assert exception


def greetString = { greeting, name = 'World!' -> return "$greeting  $name"}
assert greetString('Hello') == 'Hello  World!'
assert greetString('Hello', 'Murali') == 'Hello  Murali'

def defaultParams1 = {
	one = "one" ,two = 2, three -> return "${one} ${two} ${three}"
}

assert defaultParams1( "trois" ) == 'one 2 trois'
assert defaultParams1('un', 'trios') == 'un 2 trios'
assert defaultParams1('un', 2) == 'un 2 2'


def defaultParams2 = { String one = "one",int two = 2, three = "three" ->return "${one} ${two} ${three}"}
assert defaultParams2( "trois" ) == 'trois 2 three'
assert defaultParams2( "un", 3 ) == 'un 3 three'

def defaultParams3 = { String one = "one",  int two = 2, String three -> return "${one} ${two} ${three}" }
assert defaultParams3( "un" , 3, "trois" ) == "un 3 trois"

def defaultParams4 = { String one = "one", int two = 2, String three = "three" -> 	return "${one} ${two} ${three}" }
assert defaultParams4( "un" ) == "un 2 three"
assert defaultParams4( "un", 3 ) == "un 3 three"
assert defaultParams4( "un" , 3, "trois" ) == "un 3 trois"
