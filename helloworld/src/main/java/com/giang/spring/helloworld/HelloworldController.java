package com.giang.spring.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {
    @GetMapping("/")
    public String index() {
        return "Hello World";
    }
    @GetMapping("/2")
    public String index2() {
        return "Xin chào";
    }
}
