package com.murali.mixed.greet

import static org.junit.Assert.*;
import org.junit.Test;

import com.murali.mixed.greet.service.GreetingService

public class GroovyGreetingTest {
	final GreetingService service = new GroovyGreetingImpl()

    @Test 
    public void testGreet() {
    	println '\n\n\n########################################################################################\n\n'
        assertEquals "Hello Murali. Greeting from Groovy", service.greet("Murali")
    }
    
    @Test 
    public void testGreetNull() {
        assertEquals "Hello stranger. Greeting from Groovy", service.greet(null)
    }
}
