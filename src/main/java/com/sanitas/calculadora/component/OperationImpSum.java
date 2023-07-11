package com.sanitas.calculadora.component;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class OperationImpSum implements Operations {

	@Override
	public BigDecimal doOperation(BigDecimal firstParam, BigDecimal secondParama) {
		return firstParam.add(secondParama);

	}

}
