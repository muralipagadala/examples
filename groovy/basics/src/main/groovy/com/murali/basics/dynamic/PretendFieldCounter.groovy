package com.murali.basics.dynamic

class FieldCounter {
	public count = 0
	
	Object get(String name){
		return 'pretend value'
	}
	
	void set(String name, Object value){
		count++
	}
}

def pretender = new FieldCounter()
assert pretender.count == 0
println pretender.isNoField == 'pretend value'
pretender.isNoFieldEither = 'just to increase counter'
assert pretender.count == 1