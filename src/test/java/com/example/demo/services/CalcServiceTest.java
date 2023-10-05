package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalcServiceTest {
    @InjectMocks
    private CalcService calcService;

    @Test
    public void testCalcAdd() {
        int result = calcService.calc("add", 1, 2);
        assert result == 3;
    }

    @Test
    public void testCalcSub() {
        int result = calcService.calc("sub", 1, 2);
        assert result == -1;
    }

    @Test
    public void testCalcMul() {
        int result = calcService.calc("mul", 1, 2);
        assert result == 2;
    }

    @Test
    public void testCalcDiv() {
        int result = calcService.calc("div", 1, 2);
        assert result == 0;
    }

    @Test
    public void testCalcInvalidOperand() {
        assertThrowsExactly(IllegalArgumentException.class, () -> calcService.calc("invalid", 1, 2));
}       
}
