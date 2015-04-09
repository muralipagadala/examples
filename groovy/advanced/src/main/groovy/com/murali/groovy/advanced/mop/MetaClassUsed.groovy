package com.murali.groovy.advanced.mop

def printMetaClassInfo(instance) {
	print "MetaClass of ${instance} is ${instance.metaClass.class.simpleName}"
	println " with delegate ${instance.metaClass.delegate.class.simpleName}"
}
printMetaClassInfo(2)
println "MetaClass of Integer is ${Integer.metaClass.class.simpleName}"
println "Adding a method to Integer metaClass"
Integer.metaClass.someNewMethod = { -> /* */ }
printMetaClassInfo(2)
println "MetaClass of Integer is ${Integer.metaClass.class.simpleName}"