class Post{
	int count
	def info(){
		"This is Groovy Goodness post #$count!"
	}
}

count = 0
def info(){
	"Count value is $count."
}

def printInfo = {
	count++
	info()
}

assert 'Count value is 1.' == printInfo()
assert 'ClosureDelegate' == printInfo.delegate.class.name
assert 'ClosureDelegate' == printInfo.owner.class.name

printInfo.resolveStrategy = Closure.DELEGATE_FIRST
printInfo.delegate = new Post(count:100)
assert "This is Groovy Goodness post #101!" == printInfo()