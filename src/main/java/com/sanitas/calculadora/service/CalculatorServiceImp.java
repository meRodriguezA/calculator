package com.sanitas.calculadora.service;

import java.lang.reflect.Constructor;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.sanitas.calculadora.component.Operations;
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

		try {
			Class<?> clazz = Class.forName("com.sanitas.calculadora.component.OperationImp" + operator);
			Constructor<?> ctor = clazz.getConstructor();
			Operations object = (Operations) ctor.newInstance(new Object[] {});
			return object.doOperation(firstParam, secondParam);
		} catch (Exception ex) {
			throw new CalculatorException("Cal_01", "Operation not allowed");
		}

	}
}