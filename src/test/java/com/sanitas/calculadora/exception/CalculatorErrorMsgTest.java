package com.sanitas.calculadora.exception;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

public class CalculatorErrorMsgTest {

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void CalculatorErrorMsgFuncTest() {
		CalculatorErrorMsg calc = new CalculatorErrorMsg(1, "error", "error");
		calc.setMessage("error");
		calc.setRequestUri("error");
		calc.setStatusCode(1);
		assertTrue(calc.getMessage().equalsIgnoreCase("error"));
		assertTrue(calc.getStatusCode() == 1);
		assertTrue(calc.getRequestUri().equalsIgnoreCase("error"));

	}

}
