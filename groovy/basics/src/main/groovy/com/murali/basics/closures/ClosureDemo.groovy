def log = ''
(1..10).each {counter -> log += counter }
assert log == '12345678910'

log = ''
(1..10).each{ log += it }
assert log == '12345678910'


def Closure printer(){
	return {line -> println line}
}

class SizeFilter {
	Integer limit
	boolean sizeUpTo(String value) {
		return value.size() <= limit
	}
}

SizeFilter filter6 = new SizeFilter(limit:6)
SizeFilter filter5 = new SizeFilter(limit:5)

Closure sizeUpto6 = filter6.&sizeUpTo

def words = ['long string', 'medium', 'short', 'tiny']

assert 'medium' == words.find(sizeUpto6)
assert 'short' == words.find(filter5.&sizeUpTo)

