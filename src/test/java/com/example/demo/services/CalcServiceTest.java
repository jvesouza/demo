package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalcServiceTest {
    @InjectMocks
    private CalcService service;
    @Mock
    private XcalcService xcalcService;

    @Test
    public void testCalcAdd() {
        int result = service.calc("add", 1, 2);
        assertEquals(3, result);
    }

    @Test
    public void testCalcSub() {
        int result = service.calc("sub", 1, 2);
        assertEquals(-1, result);
    }

    @Test
    public void testCalcMul() {
        int result = service.calc("mul", 1, 2);
        assertEquals(2, result);
    }

    @Test
    public void testCalcDiv() {
        int result = service.calc("div", 1, 2);
        assertEquals(0, result);
    }

    @Test
    public void testCalcInvalidOperand() {
        assertThrowsExactly(IllegalArgumentException.class, () -> service.calc("invalid", 1, 2));
    }
}