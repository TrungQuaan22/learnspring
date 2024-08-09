package com.example.demo_components.rest;

import com.example.demo_components.service.EmailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    public EmailService emailService;
    public NotificationController(EmailService emailService) {
        this.emailService = emailService;
    }
    @GetMapping("/send-email")
    public String sendEmail(){
        return this.emailService.sendMessage();
    }
}
