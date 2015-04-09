package com.murali.script.groovy.ast

class SmartPhone {

	@Delegate Camera camera = new Camera()
	@Delegate Phone phone = new Phone()
}
