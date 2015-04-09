package com.murali.groovy.language.groovybeans

class Book {
	String title
}

def book = new Book()
book.setTitle('Groovy In Action')
assert book.getTitle() == 'Groovy In Action'

book.title = 'Java In Action'
assert book.title == 'Java In Action'