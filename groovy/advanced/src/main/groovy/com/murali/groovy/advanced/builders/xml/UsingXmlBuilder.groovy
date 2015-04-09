package com.murali.groovy.advanced.builders.xml

def builder = new groovy.xml.MarkupBuilder()
builder.languages{
	language(name: 'C++') { author('Stroustrup')}
	language(name: 'Java') { author('Gosling')}
	language(name: 'Lisp') { author('McCarthy')}
}
