def map = [a:[b:[c:1]]]

assert map.a.b.c == 1

if(map && map.a && map.a.x){
	assert map.a.x == null
}

try{
	assert map.a.x.c == null	
}catch(NullPointerException e){
	println e
}

assert map?.a?.x?.c == null