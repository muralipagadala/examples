java.util.List mylist = [1, 2, 3]
assert mylist.size() == 3
assert mylist[0] == 1

assert mylist instanceof ArrayList

java.util.List longList = (0..1000).toList()
assert longList.contains(500)

mylist = [ 'a', 'b', 'c', 'd', 'e', 'f']
def inbound = 0
def outbound = 2
assert mylist[inbound..outbound] == ['a','b', 'c']
assert mylist[0,2,4] == ['a', 'c', 'e']
mylist[0..2] = ['x','y','z']
assert mylist == ['x','y','z','d','e','f']

println mylist[-1]

mylist = ['a', 'b', 'c']
assert mylist.isCase('a')
assert 'b' in mylist

assert ['x', 'a', 'z'].grep(mylist) == ['a']
def candidate = 'c'

switch(candidate){
	case mylist : assert true;
				  break
		default : assert false
}

if(mylist) assert true

java.util.List myList = []
if (myList) assert false


assert [1, [2,3]].flatten() == [1,2,3]
assert [1,2,3].intersect([4,3,1]) == [3,1] 

assert [1,2,3].disjoint([4,5,6])

list = [1,2,3]
assert 3 == list.pop()
assert list == [1,2]

assert list.reverse() == [2,1]

list = [3,2,1]
assert list.sort() == [1,2,3]

def list = [ [0,1], [0,1,2]]
list = list.sort{a, b -> a[0] <=> b[0]}
println list

list = [1,2,3]
assert list.first() == 1
assert list.last() == 3
assert list.head() == 1
assert list.tail() == 3
assert list.count(2) == 1
assert list.max() == 3
assert list.min() == 1

def even = list.find{ item -> item % 2 == 0 }
assert even == 2

assert list.every{ item -> item < 5}
assert list.any{item -> item < 2}

