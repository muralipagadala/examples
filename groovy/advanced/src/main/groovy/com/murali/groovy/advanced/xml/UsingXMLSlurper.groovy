package com.murali.groovy.advanced.xml

languages = new XmlSlurper().parse(new FileReader('C:/examples/groovy/advanced/src/main/groovy/com/murali/groovy/advanced/xml/languages.xml'))
println "Languages and authors"

languages.language.each {
  println "${it.@name} authored by ${it.author[0].text()}"
}

def languagesByAuthor = { authorName ->
    languages.language.findAll { it.author[0].text() == authorName }.collect { 
      it.@name }.join(', ')
}
println "Languages by Wirth:" + languagesByAuthor('Wirth')