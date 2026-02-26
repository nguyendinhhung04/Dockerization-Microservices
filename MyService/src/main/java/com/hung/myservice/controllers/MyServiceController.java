package com.hung.myservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyServiceController {

    @GetMapping("/api/test")
    public String test() {
        return "Hello from MyService 🚀";
    }
}

