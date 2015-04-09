package com.murali.basics.gpath

class LineItem {
	Product product
	int count
	int total(){
		return product.dollar * count
	}
}
