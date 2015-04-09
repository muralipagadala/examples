def map = [a:1, b:2]
map.each{key, value -> map[key] = value * 2 }
assert map == [a:2, b:4]

Closure doubler = {key, value -> map[key] = value * 2 }
map.each(doubler)
assert map == [a:4, b:8]

def doublerMethod(entry){
	entry.value = entry.value * 2
}

doubler = this.&doublerMethod
map.each(doubler)
assert map == [a:8, b:16]