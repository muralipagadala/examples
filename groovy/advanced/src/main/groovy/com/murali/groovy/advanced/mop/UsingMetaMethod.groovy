package com.murali.groovy.advanced.mop


str = 'hello'
methodName = 'toUpperCase'
methodOfInterest = str.metaClass.getMetaMethod(methodName)
println methodOfInterest.invoke(str)

print "Does String respond to toUpperCase()? "
println String.metaClass.respondsTo(str, 'toUpperCase') ? 'Yes' : 'No'

print "Does String respond to compareTo(String)? "
println String.metaClass.respondsTo(str, 'compareTo', "test")? 'yes' : 'no'

print "Does String respond to toUpperCase(int)? "
println String.metaClass.respondsTo(str, 'toUpperCase', 5)? 'yes' : 'no'