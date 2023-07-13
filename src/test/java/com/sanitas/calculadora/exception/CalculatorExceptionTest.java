package com.sanitas.calculadora.exception;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

public class CalculatorExceptionTest {

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void CalculatorExceptionFuncTest() {
		CalculatorException calc = new CalculatorException(null, null);
		calc.setCodError("error");
		calc.setMsgError("error");
		assertTrue(calc.getCodError().equalsIgnoreCase("error"));
		assertTrue(calc.getMsgError().equalsIgnoreCase("error"));
	}
}
