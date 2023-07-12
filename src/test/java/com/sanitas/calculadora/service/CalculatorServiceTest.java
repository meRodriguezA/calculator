package com.sanitas.calculadora.service;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sanitas.calculadora.exception.CalculatorException;

import io.corp.calculator.TracerImpl;

public class CalculatorServiceTest {

	@Mock
	private TracerImpl tracer;

	@InjectMocks
	private CalculatorServiceImp calcService;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void calculatetNotAllowedOperationTest() {
		Assertions.assertThrows(CalculatorException.class, () -> {
			calcService.calculate(BigDecimal.ONE, BigDecimal.ONE, "ABC");
		});

	}

	@Test
	void calculatetAllowedOperationTest() {
		Assertions.assertEquals(BigDecimal.ONE,
				calcService.calculate(BigDecimal.ONE, BigDecimal.ZERO, "sum").getResult());
		Assertions.assertEquals(BigDecimal.ONE,
				calcService.calculate(BigDecimal.ONE, BigDecimal.ZERO, "subtract").getResult());
	}
}
