package com.globant.example.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/inCaseOfFailureUseThis")
    public String fallback() {
        return "Keep calm and try later";
    }
}
