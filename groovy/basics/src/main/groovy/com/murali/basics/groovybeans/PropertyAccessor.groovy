class SomeClass{
	def someProperty
	public someField
	private someOtherField
}

def store = []
def someClass = new SomeClass()
someClass.properties.each{ 
	property ->
	store += property.key
	store += property.value
}

assert store.contains('someProperty')
assert !store.contains('someField')
assert !store.contains('someOtherField')

assert store.contains('class')
//assert store.contains('metaClass')
//assert someClass.properties.size() == 3

def boxer = new Expando()
assert null == boxer.takeThis
boxer.takeThis == 'ouch!'
assert 'ouch!' == boxer.takeThis