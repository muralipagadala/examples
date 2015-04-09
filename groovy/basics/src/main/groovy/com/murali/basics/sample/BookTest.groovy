import com.murali.basics.sample.Book
import com.murali.basics.sample.BookBean

Book gina = new Book('Groovy In Action')
assert gina.getTitle() == 'Groovy In Action'

def groovyBook = new BookBean()
//groovyBook.setTitle('Groovy In Action')
//assert groovyBook.getTitle() == 'Groovy In Action'

groovyBook.title = 'Groovy Rocks'
assert groovyBook.title == 'Groovy Rocks'
