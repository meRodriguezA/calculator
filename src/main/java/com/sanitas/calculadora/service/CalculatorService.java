package com.sanitas.calculadora.service;

import java.math.BigDecimal;

import com.sanitas.calculadora.model.CalculatorResponse;

/**
 * The Interface CalculatorService.
 */
public interface CalculatorService {

	/**
	 * Calculate.
	 *
	 * @param firstParam  the first param
	 * @param secondParam the second param
	 * @param operator    the operator
	 * @return the big decimal
	 */
	CalculatorResponse calculate(BigDecimal firstParam, BigDecimal secondParam, String operator);

}
