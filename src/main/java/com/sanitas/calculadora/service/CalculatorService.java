package com.sanitas.calculadora.service;

import java.math.BigDecimal;

public interface CalculatorService {

	BigDecimal calculate(BigDecimal firstParam, BigDecimal secondParam, String operator);

}
