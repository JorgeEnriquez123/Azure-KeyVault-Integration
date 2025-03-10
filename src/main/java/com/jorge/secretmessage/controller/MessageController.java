package com.jorge.secretmessage.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {
    @Value("${secret.message}")
    public String message;

    @GetMapping
    public String message(){
        return message;
    }
}
