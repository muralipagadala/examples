import com.murali.script.groovy.pogo.Person

def person = new Person(name:'Murali')
assert person.name == 'Murali'
assert person.id == null

person = new Person(name:'Faith', id:1)
assert person.name == 'Faith'
assert person.id == 1

def willow = [name:'Willow', id:2] as Person
assert willow.name == 'Willow'
assert willow.id == 2

def persons = [person, willow]
assert ['Faith', 'Willow'] == persons*.name
assert persons.class == java.util.ArrayList 