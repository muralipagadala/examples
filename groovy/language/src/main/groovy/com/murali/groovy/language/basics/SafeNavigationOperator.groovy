package com.murali.groovy.language.basics

def display(message){
	println message?.reverse()
}

display('Message')
display(null)

class Wizard{
	def static learn(trick, action) {
		this
	}
}

Wizard.learn('alohomora', {/*...*/})