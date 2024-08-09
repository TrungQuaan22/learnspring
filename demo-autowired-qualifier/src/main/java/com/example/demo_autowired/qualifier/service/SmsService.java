package com.example.demo_autowired.qualifier.service;

import org.springframework.stereotype.Component;

@Component
public class SmsService implements MessageInterface{
    private String smsService;
    @Override
    public String sendMessage() {
        return "SMS sending......";
    }
}
