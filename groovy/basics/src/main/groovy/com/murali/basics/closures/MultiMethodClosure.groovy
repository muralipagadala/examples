class MultiMethodSample {
	int mysteryMethod (String value) {
		return value.length()
	}
	int mysteryMethod (List list) {
		return list.size()
	}
	int mysteryMethod (int x, int y) {
		return x+y
	}
}

MultiMethodSample sample = new MultiMethodSample()
Closure multi = sample.&mysteryMethod

assert 10 == multi('string arg')
assert 3 == multi(['list' ,'of', 'values'])
assert 5 == multi(2,3)