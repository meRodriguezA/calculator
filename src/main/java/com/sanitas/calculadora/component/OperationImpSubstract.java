package com.sanitas.calculadora.component;

import java.math.BigDecimal;

public class OperationImpSubstract implements Operations {

	@Override
	public BigDecimal doOperation(BigDecimal firstParam, BigDecimal secondParama) {
		return firstParam.subtract(secondParama);

	}

}
