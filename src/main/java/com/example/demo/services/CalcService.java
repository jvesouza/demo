package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class CalcService {
    public int calc(String operand, int a, int b) {
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
