package com.murali.groovy.advanced.construct

//Groovy we can make method and constructor parameters optional
def log(x, base=10){
	Math.log(x) / Math.log(base)
}

println log(1024)
println log(1024, 10)
println log(1024, 2)

def display(name='Murali'){
	println name
}

display()
display('Murali')
display('Pagadala')

//Groovy also treats the trailing array parameter as optional

def task(name, String[] details){
	println "$name  -  $details"
}

task 'Call', '123-456-7890'
task 'Call', '123', '234'
task 'Check Mail'