package com.murali.groovy.advanced.mop

Integer.metaClass.invokeMethod = { String name, args ->
	System.out.println("Call to $name intercepted on $delegate")	
	
	def validMethod = Integer.metaClass.getMetaMethod(name, args)
	if(validMethod){
		System.out.println("Running pre filter...")
		result = validMethod.invoke(delegate, args)
		System.out.println("Running post filter...")
		result
	}else{
		Integer.metaClass.invokeMissingMethod(delegate, name, args)
	}
}

println 5.floatValue()
println 5.intValue()
try {
println 5.empty()
} catch(Exception ex) {
println ex
}