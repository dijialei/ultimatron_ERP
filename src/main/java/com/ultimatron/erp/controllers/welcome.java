package com.ultimatron.erp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("welcome")
public class welcome {
    @GetMapping
public ResponseEntity hello(){
        return ResponseEntity.status(200).body("hello!");
    }
}
