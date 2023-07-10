package com.sanitas.calculadora.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.sanitas.calculadora.exception.CalculatorException;

/**
 * The Class CalculatorServiceImp.
 */
@Service
public class CalculatorServiceImp implements CalculatorService {

	/**
	 * Calculate.
	 *
	 * @param firstParam  the first param
	 * @param secondParam the second param
	 * @param operator    the operator
	 * @return the big decimal
	 */
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
			throw new CalculatorException("Cal_01", "Operation not allowed");
		}
	}

}
