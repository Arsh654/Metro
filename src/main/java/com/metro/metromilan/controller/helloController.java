package com.metro.metromilan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    private static Logger LOGGER = LoggerFactory.getLogger(helloController.class);
    @Value("${welocme.message}")
    private String msg;

    @GetMapping("/")
    public String hello(){
        LOGGER.info("Inside the hello controller class");
        return msg;
    }
}
