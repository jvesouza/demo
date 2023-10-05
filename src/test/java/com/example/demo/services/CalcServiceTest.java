package com.example.demo.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class CalcServiceTest {
    @InjectMocks
    private CalcService calcService;

    @Test
    public void testCalc() {
        int result = calcService.calc("add", 1, 2);
        assert result == 3;
    }
}
