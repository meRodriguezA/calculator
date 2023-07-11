package com.sanitas.calculadora.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CalculatorResponse {

	private String operation;
	private BigDecimal result;
}
