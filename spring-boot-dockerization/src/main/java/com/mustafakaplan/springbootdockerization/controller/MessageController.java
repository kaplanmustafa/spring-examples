package com.mustafakaplan.springbootdockerization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    @GetMapping
    public String getMessage() {
        return "Hello From Docker Image";
    }
}
