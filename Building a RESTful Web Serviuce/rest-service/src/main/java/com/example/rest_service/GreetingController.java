package com.example.rest_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

// in spring, http requests are handled by a "controller"
// gotta write "@RestController" above the controller class

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // greeting method that returns an obj
    // "@GetMapping" makes GET requests to *url*/greeting get "mapped" to this method ↓
    @GetMapping("/greetings")
    
    // "@RequestParam" makes the name value from the query string bind with the "name" parameter
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
