package com.murali.groovy.advanced.transoformation

str1 = 'hello'
str2 = str1
str3 = new String('hello')
str4 = 'Hello'

println "str1 == str2: ${str1 == str2}"  //true
println "str1 == str3: ${str1 == str3}" // true
println "str1 == str4: ${str1 == str4}" // false

println "str1.is(str2): ${str1.is(str2)}" //true
println "str1.is(str3): ${str1.is(str3)}" //false
println "str1.is(str4): ${str1.is(str4)}" //false