//Simple closure
def closure = {return 'Hello Groovy Closure'}
assert closure() == 'Hello Groovy Closure'

//Parameter closure
def add = {a,b->a+b}
assert add(3, 4) ==  7

//If closure takes single parameter then we can omit the '->' token and use implicit 'it' variable
def display = {it}
assert display(10) == 10

//Free Variables
def bonus = 100  //Free Variable
def incByBonus = {salary -> salary + bonus}
assert incByBonus(100) ==  200

def incrementer (){
	count = 0
	return { count += 1 }
}
def counter = incrementer()
assert counter() == 1
assert counter() == 2
assert counter() == 3

def newCounter = incrementer()
assert newCounter() == 1
assert counter() != 4 //Why is differnt from JavaScript


//this, owner, delegate
class Simple{
	def closure = {
		println "This ${this.class.name}"
		println "Delegate ${delegate.class.name}"
		println "Owner ${owner.class.name}"
		
		def nestedClosure = {
			println "Nested owner ${owner.class.name}"
		}
		nestedClosure()
	}
}


def simpleClosure = new Simple().closure
simpleClosure.delegate = this
simpleClosure()

//Closure as method arguments
def list = ['a','b','c']
def newList = []
def listClosure = {it.toUpperCase() }
list.collect(newList, listClosure)
assert newList == ['A', 'B', 'C']


list = ['a','b','c']
newList = []
list.collect(newList){
	it.toUpperCase()
}
assert newList == ['A', 'B', 'C']

