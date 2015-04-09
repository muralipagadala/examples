package com.murali.mixed.greet;

import com.murali.mixed.greet.service.GreetingService;
import com.murali.mixed.greet.service.impl.GreetingServiceImpl;

import static org.junit.Assert.*;
import org.junit.Test;

public class JavaGreetingTest {

	final GreetingService service = new GreetingServiceImpl();

    @Test 
    public void testGreet() {
        assertEquals("Hello Murali. Greeting from Java.", service.greet("Murali"));
    }
    
    @Test 
    public void testGreetNull() {
        assertEquals("Hello stranger. Greeting from Java.", service.greet(null));
    }
}
