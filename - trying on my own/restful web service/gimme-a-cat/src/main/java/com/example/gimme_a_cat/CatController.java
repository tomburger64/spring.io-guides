package com.example.gimme_a_cat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class CatController {

    @GetMapping("/cat")
    public Cat createACat(
            @RequestParam(value = "age", defaultValue = "5") int age,
            @RequestParam(value = "name", defaultValue = "Alfred the Killer") String name,
            @RequestParam(value = "isStupid", defaultValue = "false") boolean isStupid)
    {
        long id = new Random().nextLong();
        return new Cat(id, age, name, isStupid);
    }
}
