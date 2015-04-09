def greeting = 'Hello Groovy'

assert greeting.contains('Groovy')
assert greeting.size() == 12
assert greeting[0] == 'H'
assert greeting.startsWith('Hello')
assert greeting.getAt(1) == 'e'

assert greeting[6..11] == 'Groovy'
assert greeting.count('o') == 3
assert 'Hi'+greeting - 'Hello' == 'Hi Groovy'

assert 'x'.padLeft(3) == '  x'
assert 'x'.padRight(3) == 'x  '
assert 'x'.padRight(3, '_') == 'x__'
assert 'x'.center(3) == ' x '
assert 'x' * 3 == 'xxx'

greeting = 'Hello'
greeting <<= ' Groovy'
assert greeting instanceof StringBuffer

greeting << '!'
assert greeting.toString() == 'Hello Groovy!'
assert greeting instanceof StringBuffer

greeting[1..4] = 'i'
assert greeting.toString() == 'Hi Groovy!'