package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {

    @GetMapping("/calc")
    public int calculate(@RequestParam("operand") String operand, @RequestParam("a") int a, @RequestParam("b") int b) {
        int result = 0;
        switch (operand) {
            case "add":
                result = a + b;
                break;
            case "sub":
                result = a - b;
                break;
            case "mul":
                result = a * b;
                break;
            case "div":
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Invalid operand: " + operand);
        }
        return result;
    }
}
