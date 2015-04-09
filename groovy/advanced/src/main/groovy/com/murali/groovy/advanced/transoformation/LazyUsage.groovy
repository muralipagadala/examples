package com.murali.groovy.advanced.transoformation

class Heavy {
	def size = 10
	Heavy() {
		println "Creating Heavy with $size"
	}
}
class AsNeeded {
	def value
	@Lazy Heavy heavy1 = new Heavy()
	@Lazy Heavy heavy2 = { new Heavy(size: value) }()
	AsNeeded() {
		println "Created AsNeeded"
	}
}
def asNeeded = new AsNeeded(value: 1000)
println asNeeded.heavy1.size
println asNeeded.heavy1.size
println asNeeded.heavy2.size