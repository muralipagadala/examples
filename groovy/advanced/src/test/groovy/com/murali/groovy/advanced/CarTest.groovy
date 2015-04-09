package com.murali.groovy.advanced

import groovy.util.GroovyTestCase

class CarTest extends GroovyTestCase{
	def car
	
	void setUp(){
		car = new com.murali.examples.beans.Car() 
	}
	
	void testInitialize(){
		assertEquals 0, car.miles
	}
	
	void testDrive(){
		car.drive(10)
		assertEquals 10, car.miles
	}
	
	void testDriveNegativeInput(){
		car.drive(-10)
		assertEquals 0, car.miles
	}
}