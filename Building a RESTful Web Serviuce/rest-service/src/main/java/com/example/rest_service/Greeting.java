package com.example.rest_service;

// a record class generates constructor, getters, toString, equals and hashcode methods automatically
// also it does link the parameters' values to the instance variables automatically
// this is pretty cool
public record Greeting(long id, String content) {}
