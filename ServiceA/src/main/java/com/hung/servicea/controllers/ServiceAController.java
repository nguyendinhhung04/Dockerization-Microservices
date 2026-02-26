package com.hung.servicea.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceAController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/api/test")
    public String callService() {
        String response = restTemplate.getForObject(
                "http://myservice:8080/api/test",
                String.class
        );
        return "ServiceA gọi → " + response;
    }
}
