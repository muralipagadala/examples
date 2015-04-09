package com.murali.script.groovy.xml

root = new XmlSlurper().parse('C:/examples/groovy/java-groovy/src/main/java/com/murali/script/groovy/xml/books.xml')
println root.book[1].title