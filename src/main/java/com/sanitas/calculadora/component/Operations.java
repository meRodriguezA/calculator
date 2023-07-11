package com.sanitas.calculadora.component;

import java.math.BigDecimal;

/**
 * The Interface Operations.
 */
public interface Operations {

	/**
	 * Do operation.
	 *
	 * @param firstParam   the first param
	 * @param secondParama the second parama
	 * @return the big decimal
	 */
	public BigDecimal doOperation(BigDecimal firstParam, BigDecimal secondParama);
}
