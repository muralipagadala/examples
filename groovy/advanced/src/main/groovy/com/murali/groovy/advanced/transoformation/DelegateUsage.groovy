package com.murali.groovy.advanced.transoformation

import groovy.transform.*

class Worker {
	def work() {
		println 'get work done'
	}
	def analyze() {
		println 'analyze...'
	}
	def writeReport() {
		println 'get report written'
	}
}
class Expert {
	def analyze() {
		println "expert analysis..."
	}
}

class Manager{
	@Delegate Worker worker = new Worker()
	@Delegate Expert expert = new Expert()
}

def bernie = new Manager()
bernie.analyze()
bernie.work()
bernie.writeReport()