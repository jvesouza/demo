package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.CalcService;

@RestController
public class CalcController {
    @Autowired
    private CalcService calcService;

    @GetMapping("/calc")
    public int calculate(@RequestParam("operand") String operand, @RequestParam("a") int a, @RequestParam("b") int b) {
        return calcService.calc(operand, a, b);
    }
}
