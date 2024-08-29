package com.example.demo_spring_mvc_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class PublicController {

    @GetMapping()
    public String showHomePage(Model model){
        return "public/index";
    }

}
