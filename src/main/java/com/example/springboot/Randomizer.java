package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Randomizer {
    @GetMapping("/random")
    public ResponseEntity<String> randomizer() {
        boolean b = Math.random() >= 0.5;
        if (b) { return ResponseEntity.status(200).body("Everything OK");
        } else return ResponseEntity.status(400).body("Bad request!") ;
    }
}
