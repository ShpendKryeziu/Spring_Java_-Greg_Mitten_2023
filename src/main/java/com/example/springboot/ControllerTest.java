package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {
    @GetMapping("/info")
    public ResponseEntity<String> info() { return ResponseEntity.ok("200 Ok"); }
}
