package com.example.thymeleaf_demo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BCCController {
    @GetMapping("/bangcuuchuong/{x}")
    public String bangcuuchuong(@PathVariable int x, Model model) {
        model.addAttribute("number", x);
        //return về tên file thymeleaf
        return "bangcuuchuong";
    }

}
