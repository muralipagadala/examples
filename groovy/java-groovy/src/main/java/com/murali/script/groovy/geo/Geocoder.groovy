package com.murali.script.groovy.geo

class Geocoder {

	def base = 'http://maps.google.com/maps/geo?'
	
	void fillInLatLong(Location loc) {
		def addressFields = loc.street?[loc.street, loc.city,loc.state]:[loc.city, loc.state]
		def address = addressFields.collect {
			URLEncoder.encode(it,'UTF-8')
		}.join(',+')
		def params = [q:address,sensor:false,output:'csv',key:'ABQIAAAAaUTtvoQeYKO5TqAv0hl2QxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxTU9rH8s89rxCtRwCKUkQ3Q6sYsNg']
		def url = base + params.collect { k,v -> "$k=$v" }.join('&')
		loc.latitude = 3
		loc.longitude = 4
	}
}
