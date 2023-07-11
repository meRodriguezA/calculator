package com.sanitas.calculadora.component;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

/**
 * The Class OperationImpSum.
 */
@Component
public class OperationImpSum implements Operations {

	/**
	 * Do operation.
	 *
	 * @param firstParam   the first param
	 * @param secondParama the second parama
	 * @return the big decimal
	 */
	@Override
	public BigDecimal doOperation(BigDecimal firstParam, BigDecimal secondParama) {
		return firstParam.add(secondParama);

	}

}
