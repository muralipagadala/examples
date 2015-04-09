class Pretender{
	String methodMissing(String name, Object args){
		"called $name with $args"
	}
}

def bounce = new Pretender()
assert bounce.hello('world') == 'called hello with [world]'

class MiniGorm {
	def db = []
	def methodMissing(String name, Object args) {
		db.find { it[name.toLowerCase()-'findby'] == args[0] } //#1
	}
}

def people = new MiniGorm() 
def dierk = [first: 'Dierk', last:'Koenig']
def paul = [first: 'Paul', last:'King']
people.db << dierk << paul

println people.db

assert people.findByFirst('Dierk') == dierk
assert people.findByLast('King') == paul