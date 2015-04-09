class Employee{
	def id
	def name
	
	Employee(id, name){
		this.id = id
		this.name = name;
	}	
}

def emp = new Employee(1, 'Murali')

assert emp.id == 1

def emp2 = [2, 'Murali'] as Employee
assert emp2.id == 2

Employee emp3 = [3, 'Murali']
assert emp3.id == 3

class Vendor{
	String name, product
}

def vendor_1 = new Vendor(name:'Canon')
assert vendor_1?.product?.size() == null

def vendorName =  'Canon'
def vendor_2 = new Vendor(name:vendorName, product:'ULC')
assert vendor_2.name == vendorName

def java.awt.Dimension area = [200, 100]
assert area.width == 200
assert area.height == 100