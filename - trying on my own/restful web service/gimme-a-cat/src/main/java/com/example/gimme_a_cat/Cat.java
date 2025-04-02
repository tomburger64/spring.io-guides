package com.example.gimme_a_cat;

import com.fasterxml.jackson.annotation.JsonIgnore;

// don't wanna send back the id
// not sending back the bool value I only need it for getStupid
public record Cat(@JsonIgnore long id, int age, String name,@JsonIgnore boolean isStupid) {
    public String getStupid() {
        return isStupid ? "He is very stupid" : "He isn't stupid at all";
    }
}
