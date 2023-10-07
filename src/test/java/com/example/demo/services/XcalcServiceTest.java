package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class XcalcServiceTest {
    @InjectMocks
    private XcalcService service;

    @Test
    void testAdd() {
        int result = service.add(1, 2);
        assertEquals(3, result);

    }

    @Test
    void testDiv() {
        int result = service.div(1, 2);
        assertEquals(0, result);
    }

    @Test
    void testMul() {
        int result = service.mul(1, 2);
        assertEquals(2, result);
    }

    @Test
    void testSub() {
        int result = service.sub(1, 2);
        assertEquals(-1, result);
    }
}
