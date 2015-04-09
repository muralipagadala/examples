import static java.util.Calendar.*

println 'Hello Groovy'

def language = 'Groovy'
println "Hello $language"

println ''' ========================== 
					Triple Single Quote : Total : $0.02'''

def x = 'x'
assert x instanceof String

char y = 'y'
assert y instanceof Character

def z = 'z'.toCharacter()
assert z instanceof Character

def date = new Date(0)
def timeZone = TimeZone.getTimeZone('EST')
def format = 'd MMM YYYY HH:mm:SS z'
def out = "Date is ${date.format(format,timeZone)} ! "
println out