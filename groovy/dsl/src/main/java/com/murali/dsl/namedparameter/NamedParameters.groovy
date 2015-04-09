class POGO{
	def a = 0
	def b = 0
	def c = 0
}

def pogo = new POGO(a:1, b:2, c:3)
assert pogo.a == 1
assert pogo.b == 2
assert pogo.c == 3

def namedParamsMethod(params, param2, param3) {
	assert params.a == 1
	assert params.b == 2
	assert params.c == 3
	assert param2 == "param1"
	assert param3 == "param2"
}
//namedParamsMethod(a:1, b:2, c:3, "param1","param2")

namedParamsMethod a:1, "param1", b:2, "param2", c:3

def transfer( customer, from_account, to_account, amount) {
	println """debiting $amount from $from_account account,
		crediting $to_account account for $customer"""
}

transfer("Joe Bloggs", "checking", "savings", 100.00)

def transfer( transaction, amount) {
	println """debiting ${amount} from ${transaction.from} account,
		crediting ${transaction.to} for ${transaction.for}"""
}

transfer 100.0, from:'Checking', to:'Savings', for:'Joe Bloggs'
transfer for: 'Joe Bloggs', 200.00, from: 'checking', to: 'savings'

def sendMessage(message, id){
	println "Sending $message to $id"
}

sendMessage 'GroovyDSL', 'Murali'