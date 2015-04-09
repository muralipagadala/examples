package com.murali.mixed.greet.service.impl;

import com.murali.mixed.greet.service.GreetingService;

public class GreetingServiceImpl implements GreetingService {
    public String greet(final String name) {
        return "Hello " + (name != null ? name : "stranger") + ". Greeting from Java.";
    }
}
