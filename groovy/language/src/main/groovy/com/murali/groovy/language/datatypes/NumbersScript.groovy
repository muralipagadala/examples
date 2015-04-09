def months = 12
def amount = 10
def total = months * amount
println total

assert Integer == months.class

def seconds = 100L
assert Long == seconds.class

def balance = 1.23F
assert Float == balance.class

months = 12G
assert BigInteger == months.class

balance = 1.23G
assert BigDecimal == balance.class

Integer myInteger = new Object()
println myInteger

