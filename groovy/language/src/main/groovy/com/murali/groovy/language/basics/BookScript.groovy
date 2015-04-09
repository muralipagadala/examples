import com.murali.groovy.language.basics.Book

Book gina = new Book('Groovy In Action')
assert gina.getTitle() == 'Groovy In Action'

assert reverseTitle(gina.getTitle()) == 'noitcA nI yvoorG'

def reverseTitle(title){
	title.reverse()
}