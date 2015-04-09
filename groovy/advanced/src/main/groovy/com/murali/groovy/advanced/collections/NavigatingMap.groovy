package com.murali.groovy.advanced.collections

langs = ['C++' : 'Stroustrup', 'Java' : 'Gosling', 'Lisp' : 'McCarthy']
langs.each { entry -> println "Language $entry.key was authored by $entry.value" }

langs.each { language, author ->
	println "Language $language was authored by $author"
}