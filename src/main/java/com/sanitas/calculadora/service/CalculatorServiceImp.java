package com.sanitas.calculadora.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImp implements CalculatorService {

	@Override
	public BigDecimal calculate(BigDecimal firstParam, BigDecimal secondParam, String operator) {
		switch (operator) {
		case "sum": {
			return firstParam.add(secondParam);
		}
		case "subtraction": {
			return firstParam.subtract(secondParam);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + operator);
		}
	}

}
