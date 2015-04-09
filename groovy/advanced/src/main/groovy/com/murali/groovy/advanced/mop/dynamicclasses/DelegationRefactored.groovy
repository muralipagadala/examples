package com.murali.groovy.advanced.mop.dynamicclasses

class Manager2 { 
	{ delegateCallsTo Worker, Expert, GregorianCalendar }

	def schedule() {
		println "Scheduling ..."
	}
}