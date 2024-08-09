package com.example.demo_.configuration_.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private Calculator calculator;
    @Autowired
    public Controller(Calculator calculator) {
        this.calculator = calculator;
    }
    @GetMapping("/canBacHai")
    public String tinhCanBacHai(@RequestParam("value") double x){
        return "SQRT("+x+") = "+ this.calculator.canBacHai(x);
    }
}
