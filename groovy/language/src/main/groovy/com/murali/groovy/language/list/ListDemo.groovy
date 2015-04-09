myList = ['a', 'b', 'c']
assert myList.isCase('b')
assert 'a' in myList

def candidate = 'c'
switch(candidate){
	case myList : assert true; break
	default : assert false
}

assert ['x', 'a' , 'z'].grep(myList) == ['a']

myList = []
if(myList)
	assert false

def exp =''
for(i in [1,'*',5]){
	exp += i
}
assert exp == '1*5'