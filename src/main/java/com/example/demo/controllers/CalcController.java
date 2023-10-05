package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.CalcService;
import com.example.demo.to.CalcTO;

@RestController
public class CalcController {
    @Autowired
    private CalcService calcService;

    @GetMapping("/calc")
    public ResponseEntity<CalcTO> calculate(@RequestParam("operand") String operand, @RequestParam("a") int a, @RequestParam("b") int b) {
        int result = calcService.calc(operand, a, b);
        CalcTO calcTO = new CalcTO(operand, a, b, result);
        return ResponseEntity.ok(calcTO);
    }
}
