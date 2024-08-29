package com.example.security_jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("")
    public String home() {
        return "public/index";
    }
    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }
}
