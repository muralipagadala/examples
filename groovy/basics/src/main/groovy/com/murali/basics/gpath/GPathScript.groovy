package com.murali.basics.gpath

def ulcDate = new Date(107,0,1)

def ulcProduct = new Product(name:'ULC', dollar:1499)
def ve = new Product(dollar:499, name:'Visual Editor')

def invoices = [
		new Invoice(date:ulcDate, items:[
				new LineItem(product:ulcProduct, count:5),
				new LineItem(product:ve, count:1)
			]),
		new Invoice(date:[107,1,2], items:[
				new LineItem(product:ve, count:4)
			])
	]
//println invoices.items*.total()
//assert [1499*5, 499, 499*4] == invoices.items*.total()

assert ['ULC'] == invoices.items.grep{it.total() > 7000}.product.name