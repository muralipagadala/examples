package com.murali.groovy.language.basics

for(i in 0..2){
	println 'Merry Groovy'
}

0.upto(2) { print "$it"}
println ''
3.times(){print "$it" }
println ''

0.step(10, 2) { print "$it"}

println "cmd /C dir".execute().text
