package com.murali.groovy.advanced.compile.mop

class CheckingAccount {
	def audit(amount) {
		if(amount > 10000) print "auditing..."
	}
	def deposit(amount) {
		println "depositing ${amount}..."
	}
	def withdraw(amount) {
		println "withdrawing ${amount}..."
	}
}

def account = new CheckingAccount()
account.deposit(1000)
account.deposit(12000)
account.withdraw(11000)