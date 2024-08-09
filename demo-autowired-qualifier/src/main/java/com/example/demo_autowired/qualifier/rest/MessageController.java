package com.example.demo_autowired.qualifier.rest;

import com.example.demo_autowired.qualifier.service.MessageInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private MessageInterface messageService;
    private MessageInterface smsService;
    @Autowired
    public MessageController(@Qualifier("emailService") MessageInterface service) {
        this.messageService = service;
    }
    @Autowired
    public void setSmsService(MessageInterface smsService) {
        this.smsService = smsService;
    }
    @GetMapping("/")
    public String sendMessage(){
        return messageService.sendMessage();
    }
    @GetMapping("/sms")
    public String sendSms(){
        return smsService.sendMessage();
    }
}
