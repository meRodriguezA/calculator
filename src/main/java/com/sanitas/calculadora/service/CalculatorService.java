package com.sanitas.calculadora.service;

import java.math.BigDecimal;

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
	BigDecimal calculate(BigDecimal firstParam, BigDecimal secondParam, String operator);

}
