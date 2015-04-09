import static java.util.Calendar.*

def me = 'Tarzan'
def you = 'Jane'
def line = "me $me, you $you"
assert line == 'me Tarzan, you Jane'

def date = new Date()
def dateMap = [y:date[YEAR]-1900, m:date[MONTH], d:date[DAY_OF_MONTH]]
def out = "Year $dateMap.y  Month $dateMap.m  Day $dateMap.d"
//assert out == 'Year 114  Month 3  Day 24'

println line.getClass().getName()
assert line.strings[0] == 'me '
assert line.strings[1] == ', you '
assert line.values[0] == 'Tarzan'
assert line.values[1] == 'Jane'

println 'Hello Groovy!'