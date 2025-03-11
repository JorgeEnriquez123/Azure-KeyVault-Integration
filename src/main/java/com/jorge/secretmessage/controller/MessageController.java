package com.jorge.secretmessage.controller;

import com.azure.security.keyvault.secrets.SecretClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MessageController {
    @Value("${main.message}")
    public String message;
    public final SecretClient secretClient;

    @GetMapping("/message")
    public String message(){
        return message;
    }

    @GetMapping("/othermessage")
    public String otherMessage(){
        return secretClient.getSecret("othermessage").getValue();
    }
}
