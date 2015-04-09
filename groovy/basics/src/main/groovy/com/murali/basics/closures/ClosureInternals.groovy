class Mother{
	int property = 1
	int method(){
		return 2
	}
	
	Closure birth(param){
		def local = 3
		def closure = { 
			caller ->
			[this, property, method(), local, param, caller, owner]
		}
		//return closure
	}
}

Mother julia = new Mother()
closure = julia.birth(4)

context = closure.call(this)

assert context.size() == 7

println context[0].class.name

assert context[1..4] == [1,2,3,4]

assert context[5] instanceof Script
assert context[6] instanceof Mother

firstClosure = julia.birth(4)
secondClosure = julia.birth(4)

assert !firstClosure.is(secondClosure)