package com.murali.groovy.advanced.mop

Integer.metaClass.invokeMethod = { String name, args -> /* */}
println Integer.metaClass.getClass().name