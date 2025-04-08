package com.example.consuming_rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// @JsonIgnoreProperties(ignoreUnknown = true)
// ignores all json properties that don't match the parameters ↓
@JsonIgnoreProperties(ignoreUnknown = true)
public record Quote(String type, Value value) { }