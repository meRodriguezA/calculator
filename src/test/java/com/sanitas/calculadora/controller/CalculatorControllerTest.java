package com.sanitas.calculadora.controller;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.util.ReflectionTestUtils;

import com.sanitas.calculadora.exception.CalculatorException;
import com.sanitas.calculadora.service.CalculatorService;

@SpringBootTest
public class CalculatorControllerTest {

	@Mock
	private CalculatorService calcService;

	@InjectMocks
	private CalculatorController calcController;

	@BeforeEach
	public void setUp() throws Exception {
		ReflectionTestUtils.setField(calcController, "listAllowOperationes", Arrays.asList("sum", "subtract"));
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void getOperationResultNotAllowedOperationTest() {
		Assertions.assertThrows(CalculatorException.class, () -> {
			calcController.getOperationResult(BigDecimal.ONE, BigDecimal.ONE, "ABC");
		});
	}

	@Test
	void getOperationResultAllowedOperationTest() {
		when(calcService.calculate(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(BigDecimal.ONE);
		Assertions.assertEquals(HttpStatus.OK,
				calcController.getOperationResult(BigDecimal.ONE, BigDecimal.ZERO, "SUM").getStatusCode());
	}
}
