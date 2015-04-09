def flintstones = ["Fred","Barney", "Wilma", "Hello"]
println flintstones.findIndexOf (2){it == "Wilma"}

def closureMethod(Closure c){
	c.call()
}

closureMethod{
	println "Closure Called"
}

def closureMethodString(String s, Closure c){
	println s
	c()
}

closureMethodString("Line One"){
	println "Line Two"
}

def closureMethodString_2(String s, Closure c){
	println "Greet somone "
	c.call(s)
}

closureMethodString_2("Dolly"){ name ->
	println "Hello $name!"	
}

