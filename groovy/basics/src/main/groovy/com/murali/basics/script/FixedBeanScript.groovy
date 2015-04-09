import com.murali.basics.sample.FixedBean

println '\n\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Start Fixed Bean Script @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n'
def gina = new FixedBean('Groovy In Action')
def regina = new FixedBean(title:'Groovy In Action')

assert gina.title == 'Groovy In Action'
assert gina == regina

try{
	gina.title = 'Oops!'
	assert false, 'Should not reach here'
}catch(ReadOnlyPropertyException expected){
	println "Expected Error: '$expected.message'"
}
println '\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ End Fixed Bean Script @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@'