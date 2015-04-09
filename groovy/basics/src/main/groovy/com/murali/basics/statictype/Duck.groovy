import groovy.transform.TypeChecked

class DuckDemo{
	def methodMissing(String name, args){
		println "$name"
	}
}

def duck = new DuckDemo()
duck.quack()


@TypeChecked
class Person {
	String firstName
	String lastName
	int age
}
def person = new Person(firstname: 'Peter', lastname:'Jackson')
assert person.firstName == 'Peter'