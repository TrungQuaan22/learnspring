package com.example.constructor_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController
{
    private MessageInterface email;
    // Constructor injection
//    @Autowired
//    public IndexController(EmailService email){
//        this.email = email;
//    }
    // setter injection
    @Autowired
    public void setEmail(EmailService email){
        this.email = email;
    }
    @GetMapping("/send-email")
    public String sendEmail(){
        return this.email.sendMessage();
    }
}
