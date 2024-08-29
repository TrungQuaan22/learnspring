package com.example.security_jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showLoginPage")
    public String login() {
        return "login";
    }
    @GetMapping("/show")
    public String showErrorPage(){
        return "error/403";
    }
}

