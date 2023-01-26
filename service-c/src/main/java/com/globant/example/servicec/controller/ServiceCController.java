package com.globant.example.servicec.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class ServiceCController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceCController.class);
    @GetMapping("/loans")
    public String get() {
        LOGGER.info("Getting loans from the database in Service C");
        try {
            LOGGER.info("Request many services ...");
            TimeUnit.MINUTES.sleep(1);
            LOGGER.info("Finished request many services ...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "GET Service C";
    }
}
