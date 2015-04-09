assert true
assert !false

assert ('a' =~ /./)
assert !('a' =~ /b/)

assert [1]
assert ![]

Iterator itr = [1].iterator()
assert itr
itr.next()
assert !itr

assert [a:1]
assert ![:]

assert !0

assert !null

assert new Object()

class AlwaysFalse{
	boolean asBoolean(){
		println 'asBoolean called..'
		return true
	}
	
	def boolean hello(){ println 'hello called..'}
}

assert new AlwaysFalse()

def x = 1
if(x==2){
	assert false
}

if((x=3)){
	println x
}

assert x == 3

def store = []
while(x = x -1 ){
	store << x
}

while(x = 2){
	println x
	break
}
assert store == [2, 1]

if(0)
	assert false
	
if([])
	assert false
	
if('nonempty')
	assert false