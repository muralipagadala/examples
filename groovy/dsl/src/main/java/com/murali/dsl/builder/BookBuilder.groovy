import groovy.xml.*

def builder = new StreamingMarkupBuilder()
builder.encoding = 'UTF-8'

def books = builder.bind{
	mkp.xmlDeclaration()
	namespaces << [meta:'http://meta/book/info']
	
	books(count:3){
		book(count:1){
			title lang:'en', 'Groovy In Action'
			meta.isbn '1-932394-84-2'
		}
		book(count:2){
			title lang:'en', 'Groovy DSL'
			meta.isbn '0123725070'
		}
		book(count:3){
			title lang:'en', 'Groovy & Grails'
			comment << 'Not yet available.'
		}
		book(id: 4) {
			mkp.yieldUnescaped '<title>Griffon Guide</title>'
		}
	}
} 

println XmlUtil.serialize(books)