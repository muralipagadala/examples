class PropPretender {
	def propertyMissing(String name) {
		"accessed $name"
	}
}
def bounce = new PropPretender()
assert bounce.hello == 'accessed hello'

def propertyMissing(String name) {
	int result = 0
	name.each {
		result <<= 1
		if (it == 'I') result++
	}
	return result
}

assert IIOI + IOI == I00I0

class DynamicPretender{
	def propertyMissing(String name){
		whatToDo(name)
	}
	Closure whatToDo = {name -> "accessed $name"}
}

def one = new DynamicPretender()
assert one.hello == 'accessed hello'
one.whatToDo = { name -> name.size()}
assert one.hello == 5