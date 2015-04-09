interface Flying{
	void fly()
}

interface Quacking{
	void quack()
}

class Bird implements Flying{
	void fly(){
		println "I'm Flying!"
	}
}

class Duck extends Bird{
	void quack(){
		println "Quack!"
	}
}

void birdsAndDucks(){
	def o = new Bird()
	o.fly()
	//o.quack()
	o = new Duck()
	o.fly()
	o.quack()
}

birdsAndDucks()