package com.devcalc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devcalc.services.CalculatorService;

@RestController
public class CalculatorController {

    private final CalculatorService calculator;

    CalculatorController(CalculatorService calculator) {
        this.calculator = calculator;
    }

    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return calculator.add(a, b);
    }

    @GetMapping("/subtract")
    public int subtract(@RequestParam int a, @RequestParam int b) {
        return calculator.subtract(a, b);
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam int a, @RequestParam int b) {
        return calculator.multiply(a, b);
    }

    @GetMapping("/divide")
    public int divide(@RequestParam int a, @RequestParam int b) {
        try {
            return calculator.divide(a, b);
        } catch (ArithmeticException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/sqrt")
    public double divide(@RequestParam int x) {
        try {
            return calculator.sqrt(x);
        } catch (ArithmeticException e) {
            throw new RuntimeException(e);
        }
    }
}