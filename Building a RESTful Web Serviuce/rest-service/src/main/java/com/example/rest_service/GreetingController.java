package com.example.rest_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

// http requests are sent from browser / app / whatever
// http request is received by the controller
@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // when a GET request to URL + @GetMapping parameter happens, runs the following code ↓
    @GetMapping("/greetings")

    // "@RequestParam" requests a query parameter from the URL
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        // returns new Greeting obj with an id and the name
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
