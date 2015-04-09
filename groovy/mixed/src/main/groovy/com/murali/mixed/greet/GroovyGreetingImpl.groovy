package com.murali.mixed.greet

import com.murali.mixed.greet.service.GreetingService;

class GroovyGreetingImpl implements GreetingService {
	String greet(String name) {
		"Hello ${name ?: 'stranger'}. Greeting from Groovy"
	}
}