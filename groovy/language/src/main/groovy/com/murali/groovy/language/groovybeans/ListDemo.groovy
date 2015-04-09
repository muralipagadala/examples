def roman = ['', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII']
roman.each{
	number ->
	print number
}

assert roman[4] == 'IV'

roman[8] = 'VIII'
println ''
roman.each{
	number ->
	print number
}