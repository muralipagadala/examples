package com.murali.groovy.advanced.test

class CodeWithHeavierDependenciesExt extends CodeWithHeavierDependencies {
	def result
	int someAction() {
		25
	}
	def println(text) {
		result = text
	}
}
