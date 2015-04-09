def adder = {x, y -> return x+y}

assert 5 == adder(2,3)
assert 10 == adder.call(6,4)

def benchmark(int repeat, Closure worker){
	def start = System.nanoTime()
	repeat.times{ worker(it)}
	def stop = System.nanoTime()
	return stop - start
}

def slow = benchmark(10000){(int) it /2 }
def fast = benchmark(10000){it.intdiv(2)}

assert fast * 5 > slow

def caller(Closure closure){
	closure.getParameterTypes().size()
}

assert caller{one ->} == 1
assert caller{one, two -> } == 2