//Features Practice

//1. Closures and I/O Additions
def number = 0
new File("C:/examples/groovy/basics/src/main/groovy/com/murali/basics/closures/data.txt").eachLine{
	line ->
	number++
	println "$number.  $line"
}

//2. Collection Literals and Simplified Property Access
def classes = [String, List, Map]
for(def claz in classes){
	println claz.package.name
}

println('\n'+ [String, List, Map]*.package*.name)

//3.XML HANDLING THE GROOVY WAY: GPATH WITH DYNAMIC PROPERTIES

String customerFilePath = 'C:/examples/groovy/basics/src/main/groovy/com/murali/basics/closures/customers.xml'
def customers = new XmlSlurper().parse(new File(customerFilePath))

for(customer in customers.corporate.customer){
	println "${customer.@name}  Works for ${customer.@company}"
}



