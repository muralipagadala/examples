assert [1,[2,3]].flatten() == [1,2,3]
assert [1,2,3].intersect([4,3,1]) == [3,1]
assert [1,2,3].disjoint([4,5,6])

list = [1,2,3]
popped = list.pop()
assert popped == 3
assert list == [1,2]

list = [1,2,3]
assert list.reverse() == [3,2,1]
assert [3,1,2].sort() == [1,2,3]

def nestedList = [[4,3], [3,2,1]]
nestedList = nestedList.sort{a,b->a[0] <=> b[0]}
assert nestedList == [[3,2,1],[4,3]]

nestedList = nestedList.sort{item -> item.size()}
assert nestedList == [[4,3], [3,2,1]]

def stack = [1,2]
stack << 3
stack << 4
stack.push(5)
assert stack == [1,2,3,4,5]