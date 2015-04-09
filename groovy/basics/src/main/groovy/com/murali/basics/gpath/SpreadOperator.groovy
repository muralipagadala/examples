def getList(){
	[1,2,3]
}

def sum(a,b,c){
	a+b+c
}

assert 6 == sum(*list)

def range = [1,2,3]
assert[0,1,2,3] == [0,*range]

def map = [a:1, b:2]
assert [x:0, a:1, b:2] == [x:0, *:map]
