def n = 1..10
assert n.contains(5)

assert !n.contains(15)
assert n.size() == 10

assert n.from == 1
assert n.to == 10

assert n.reverse() == 10..1

def totalClinks = 0
def partyPeople = 100
1.upto(partyPeople){
	guestNumber ->
	clinksWithGuest = guestNumber -1
	totalClinks += clinksWithGuest
}

assert totalClinks == (partyPeople * (partyPeople-1)) / 2

def clinks = 0
for(remainingGuests in 1..10){
	clinks += remainingGuests
}
println "RemainingGuest  $clinks"