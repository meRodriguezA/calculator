package com.sanitas.calculadora.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.sanitas.calculadora.model.CalculatorResponse;
import com.sanitas.calculadora.service.CalculatorService;

@SpringBootTest
public class CalculatorControllerTest {

	@Mock
	private CalculatorService calcService;

	@InjectMocks
	private CalculatorController calcController;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void getOperationResultAllowedOperationTest() {
		CalculatorResponse value = new CalculatorResponse("", BigDecimal.ONE);
		value.setOperation("SUM");
		value.setResult(BigDecimal.ONE);

		when(calcService.calculate(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(value);
		Assertions.assertEquals(HttpStatus.OK,
				calcController.getOperationResult(BigDecimal.ONE, BigDecimal.ZERO, value.getOperation()).getStatusCode());
	}
}
