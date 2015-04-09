package com.murali.groovy.advanced.construct

class Robot{
	def type, height,width
	def access(location, weight, fragile) {
		println "Received fragile? $fragile, weight: $weight, loc: $location"
	}
}

def robot = new Robot(type:1, height:2, width:3)
println "Robot type=$robot.type  height=$robot.height width=$robot.width"

robot.access(x: 30, y: 20, z: 10, 50, true)
robot.access(50, true, x: 30, y: 20, z: 10)