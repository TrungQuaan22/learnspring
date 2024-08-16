package com.example.rest_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    public String Hello() {
        return "Hello World";
    }
    @GetMapping("hello/vietnamese")
    public String Hello2() {
        return "Xin chào";
    }

}
