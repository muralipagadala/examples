assert 1 == (-1).abs()
assert 2 == 2.5.toInteger()
assert 2 == 2.5 as Integer
assert 2 == (int)2.5
assert 3 == 2.5f.round()
assert 3.142 == Math.PI.round(3)
assert '2'.isNumber()

def store = ''

10.times {
	store += 'x'
}

assert store == 'xxxxxxxxxx'
store = ''

1.upto(5) { number ->
	store += number
}

assert store == '12345'

store = ''
2.downto(-2) {number ->
	store += number + ' '
}	

assert store == '2 1 0 -1 -2 '