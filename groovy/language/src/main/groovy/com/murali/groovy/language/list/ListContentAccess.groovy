class Language implements Comparable<Language>{
	int id
	String name
	
	public int compareTo(Language lang) {
		return this.id <=> lang.id;
	}

	@Override
	public String toString() {
		return "Language [id=" + id + ", name=" + name + "]";
	}
}

def java = new Language(id:1, name:'Java')
def groovy = new Language(id:2,name:'Groovy')
def javascript = new Language(id:3,name:'JavaScript')

def languages = []
languages << java << groovy << javascript
assert languages.size() == 3

assert languages.first() == java
assert languages.head() == java

assert languages.tail() == [groovy,javascript]
assert languages.last() == javascript

assert languages.max() == javascript
assert languages.min() == java

assert languages.count(1) == 0

println languages.join('::')

def list = [1,2,3]
result = list.inject(0){clinks, guests -> clinks + guests}
println result
println list