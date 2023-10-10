package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalcService {
@Autowired
private XcalcService xcalcService;

    public int calc(String operand, int a, int b) {
        int result = 0;
        switch (operand) {
            case "add":
                result = xcalcService.add(a, b);
                break;
            case "sub":
                result = xcalcService.sub(a, b);
                break;
            case "mul":
                result = xcalcService.mul(a, b);
                break;
            case "div":
                result = xcalcService.div(a, b);
                break;
            default:
                throw new IllegalArgumentException("Invalid operand: " + operand);
        }
        return result;
    }
}
