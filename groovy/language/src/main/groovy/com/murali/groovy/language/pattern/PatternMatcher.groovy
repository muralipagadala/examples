def myFairStringy = 'The rain in Spain stays mainly in the plain!'

def wordEnding = /\w*ain/
def rhyme = /\b$wordEnding\b/
def found = ''

myFairStringy.eachMatch(rhyme) { match ->
	found += match + ' '
}
assert found == 'rain Spain plain '

found = ''

(myFairStringy =~ rhyme).each{
	match ->
	found += match +' '
}

assert found == 'rain Spain plain '

def cloze = myFairStringy.replaceAll(rhyme){
	it-'ain'+'___'
}
assert cloze == 'The r___ in Sp___ stays mainly in the pl___!'