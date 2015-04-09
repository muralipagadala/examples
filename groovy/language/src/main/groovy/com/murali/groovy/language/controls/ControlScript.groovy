def list = [11,12,13,14,15]
for(j in list){
	assert j
}

list.each{item -> assert item }