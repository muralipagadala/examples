package com.murali.basics.dynamic

class Counter {
	public count = 0
}

def counter = new Counter()
counter.count = 1
assert counter.count == 1

def fieldName = 'count'
assert counter[fieldName] == 1
assert counter['count'] == 1
