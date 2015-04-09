println 'Map Demo'
def myMap = [a:1, b:2, c:3]
assert myMap instanceof LinkedHashMap
assert myMap.size() == 3
assert myMap['a'] == 1

def emptyMap = [:]
assert emptyMap.size() == 0

def explicitMap = new TreeMap()
explicitMap.putAll(myMap)
assert explicitMap['a'] == 1

def composed = [x:'y', *:myMap]
assert composed == [x:'y', a:1, b:2, c:3]

assert myMap.get('a') == 1
assert myMap.a == 1
assert myMap.get('a', 0)

myMap = ['a.b':4]
assert myMap.'a.b' == 4

myMap = [a:1, b:2, c:3]
def other = [b:2, c:3, a:1]

assert myMap == other

assert !myMap.isEmpty()
assert myMap.containsKey('a')
assert myMap.containsValue(1)
assert myMap.entrySet() instanceof Collection

myMap.every{ entry -> println entry.value}

assert myMap.keySet() == ['a', 'b', 'c'] as Set
assert myMap.values().toList() == [1, 2, 3]

def store = ''
myMap.each { 
	entry -> 
	store += entry.key 
	store += entry.value 
}
println store


store = ''
for(key in myMap.keySet()){
	store += key
}
println store

for(value in myMap.values()){
	store += value
}
println store

myMap.clear()
assert myMap.isEmpty()

myMap = [a:1, b:2, c:3]
myMap.remove('a')
assert myMap.size() == 2

assert [a:1] + [b:2] == [a:1, b:2]

myMap = [a:1, b:2, c:3]
def abMap = myMap.subMap(['a', 'b'])

def adMap = myMap.findAll{ entry -> entry.value < 3}
assert adMap.size() == 2
assert adMap.a == 1

def found = myMap.find{ entry -> entry.value < 2 }
assert found.key == 'a'
assert found.value == 1

def doubled = myMap.collect{ entry -> entry.value *= 2 }
assert doubled instanceof List
assert doubled.every { item -> item % 2 == 0}
