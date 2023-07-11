package com.sanitas.calculadora.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.sanitas.calculadora.component.Operations;
import com.sanitas.calculadora.exception.CalculatorException;
import com.sanitas.calculadora.model.CalculatorResponse;

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
	 * @return the calculator response
	 */
	@Override
	public CalculatorResponse calculate(BigDecimal firstParam, BigDecimal secondParam, String operator) {

		try {
			Class<?> classIns = Class.forName("com.sanitas.calculadora.component.OperationImp"
					+ operator.substring(0, 1).toUpperCase() + operator.substring(1).toLowerCase());
			Operations operationsImpl = (Operations) classIns.getConstructor().newInstance(new Object[] {});
			return new CalculatorResponse(operator.toLowerCase(), operationsImpl.doOperation(firstParam, secondParam));
		} catch (ReflectiveOperationException | RuntimeException ex) {
			throw new CalculatorException("Cal_01", "Operation not allowed");
		}

	}
}