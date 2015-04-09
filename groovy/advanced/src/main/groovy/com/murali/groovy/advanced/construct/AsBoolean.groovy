package com.murali.groovy.advanced.construct

class Glass {
	String content
	
	/*def asBoolean(){
		return content //?.isEmpty()
	}*/
}

//def glass = new Glass(content:'Water')
glass = new Glass()
if(glass) println 'Glass is not empty'

lst0 = null
if(lst0){
	println 'lst0 true'
}else{
	println 'lst0 false'
}

