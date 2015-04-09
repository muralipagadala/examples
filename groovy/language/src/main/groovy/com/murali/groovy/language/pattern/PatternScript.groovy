import java.util.regex.Matcher

assert 'abc' == /abc/
assert '\\d' == /\d/

def reference = 'hello'
assert reference == /$reference/

def shoutedWord = ~/\b[A-Z]+\b/
def matcher = ('EUREKA' =~ shoutedWord)
assert matcher.matches()

assert "1234" ==~ /\d+/

assert "Green Eggs and Spam" == 'Spam Spam'.replaceFirst(/Spam/, 'Green Eggs and')

def name = /Murali/
println "Name  is $name"

assert "The armor was colored silver" == "The armour was coloured silver".replaceAll(/ou/, 'o')

def dashedToCamelCase(orig) {
	orig.replaceAll(/-(\w)/){fullMatch, firstCharacter -> firstCharacter.toUpperCase()}
}

assert 'firstName' == dashedToCamelCase('first-name')
assert "oneTwoThreeFourFiveSixSevenEight" == dashedToCamelCase("one-two-three-four-five-six-seven-eight")

assert ['foobar', 'bazbar'] == ['foobar', 'bazbar', 'barquux'].grep(~/.*bar$/)

def twister = 'she sells sea shells at the sea shore of seychelles'

assert twister =~ /s.a/

def finder = (twister =~ /s.a/)
assert finder instanceof Matcher

assert twister ==~ /(\w+\s\w+)*/

def WORD = /\w+/
matches = (twister ==~ /($WORD $WORD)*/)
assert matches instanceof Boolean

assert !(twister ==~ /s.e/)

def wordsByx = twister.replaceAll(WORD, 'x')
assert wordsByx == 'x x x x x x x x x x'
def words = twister.split(/ /)
assert words.size() == 10
assert words[0] == 'she'