package com.devcalc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.devcalc.services.CalculatorService;

@SpringBootTest
class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculator;

    @Test
    public void testAdd() {
        int a = 5;
        int b = 3;
        int expectedResult = 8;

        int result = calculator.add(a, b);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testSubtract() {
        int a = 5;
        int b = 3;
        int expectedResult = 2;

        int result = calculator.subtract(a, b);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testMultiply() {
        int a = 5;
        int b = 3;
        int expectedResult = 15;

        int result = calculator.multiply(a, b);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testDivide() {
        int a = 10;
        int b = 2;
        int expectedResult = 5;

        int result = calculator.divide(a, b);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testDivideByZero() {
        int a = 10;
        int b = 0;

        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
    }
}