def http = [
	100:'CONTINUE',
	200:'OK',
	400:'BAD REQUEST'
]

assert http[200] == 'OK'

http.each {k,v -> println "$k --> $v"}

for(String httpCode : http){
	println httpCode
}