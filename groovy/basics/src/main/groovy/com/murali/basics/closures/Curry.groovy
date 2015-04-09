def adder = {x,y -> return x+y}
def addOne = adder.curry(1)
assert 6 == addOne(5)