x = 1
assert x == 1
assert this.binding.variables['x'] == 1

def y = 2
assert y == 2
try{
	println this.binding.variables['y']
}catch(MissingPropertyException e){
	println e
}

bill = 7
bi1l = bill + 3

assert bill == 7