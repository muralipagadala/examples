def store = ''
for(String s in 'a'..'d'){
	store += s
}

assert store == 'abcd'

store = ''
for(i in [1,23]){
	store += i
}

assert store == '123'

def myString = 'Old School Java'
store = ''
for(int i = 0; i < myString.size(); i++ ){
	store += myString[i]
}
assert store == myString

myString = 'Java Range Index'
store = ''
for(int i : 0..<myString.size()){
	store += myString[i]
}

assert store == myString

myString = 'Groovy Range Index'
store = ''
for(i in 0..<myString.size()){
	store += myString[i]
}
assert store == myString

myString = 'Java String Iterable'
store = ''
for(String s : myString){
	store +=s
}
assert store == myString

myString = 'Groovy String Iterable'
store = ''
for(s in myString){
	store += s
}
assert store == myString

for( x in new Object())
	println "Printed once for object $x"

for(x in 0..9)println x

(0..9).each{println it}