def greeting(name){
	def salutation = 'Hello '
	
	def greeter = { println "$salutation $name"}
	greeter()
}

greeting('Dolly')

class MyClass{
	def member = 'original'
	
	def method(String param){
		def local = member
		return{
			println "Member: $member  Local: $local  Parameter: $param"
		}
	}
}

MyClass clazz = new MyClass()
def clos1 = clazz.method('First')
clos1()

clazz.member = "modified "
def clos2 = clazz.method("Second")
clos2()
clos1()
