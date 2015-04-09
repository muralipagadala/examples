def indian = { style, meat, rice -> 
	return "${meat} ${style} with ${rice} rice."
}

def vindaloo = indian.curry('Vindaloo')
assert vindaloo("Chicken", "Fried") == "Chicken Vindaloo with Fried rice."

def korma = indian.curry("Korma")
assert korma('Chicken', 'Vegetable') == 'Chicken Korma with Vegetable rice.'

def chictikka = indian.curry('Chicken', 'Tikaa')
assert chictikka('Boiled') == 'Chicken Tikka with Boiled rice.'

def lambkorma = korma.curry('Lamb')
assert lambkorma('Boiled') == 'Lamb Korma with Boiled rice.'

def lambkormaboiled = lambkorma.curry('Boiled')
assert lambkormaboiled == 'Lamb Korma with Boiled rice.'