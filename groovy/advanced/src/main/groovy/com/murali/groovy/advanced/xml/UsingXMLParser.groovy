package com.murali.groovy.advanced.xml

languages = new XmlParser().parse(new FileReader('C:/examples/groovy/advanced/src/main/groovy/com/murali/groovy/advanced/xml/languages.xml'))

println 'Languages and Authors'

languages.each{
	println "${it.@name} authored by ${it.author[0].text()}"
}

def languagesByAuthor = { authorName ->
	languages.findAll { it.author[0].text() == authorName }.collect { it.@name }.join(', ')
}