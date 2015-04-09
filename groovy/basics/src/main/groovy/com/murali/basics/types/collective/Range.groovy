println 'Range Demo'
assert (0..10).contains(10)
assert (0..10).contains(5)

assert (0..<10).contains(10) == false

def a = (0..10)
//assert a instanceof Range
assert a.contains(5)

//a = new IntRange(0..10)
assert a.contains(5)

assert (0.1..1.0).containsWithinBounds(0.5)

def today = new Date()
def yesterday = today - 1

assert (today..yesterday).size() == 2

assert ('a'..'c').contains('b')
assert ('d'..'a').contains('c')

def log = ''
for(element in 5..9){
	log += element
}
assert log == '56789'

log = ''

(9..<5).each{element -> log += element}
assert log == '9876'

assert 5 in 0..10
assert (0..10).isCase(5)
