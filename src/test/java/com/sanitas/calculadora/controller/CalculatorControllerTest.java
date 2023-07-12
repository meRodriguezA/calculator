package com.sanitas.calculadora.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sanitas.calculadora.exception.CalculatorException;
import com.sanitas.calculadora.exception.CalculatorExceptionHandler;
import com.sanitas.calculadora.model.CalculatorResponse;
import com.sanitas.calculadora.service.CalculatorService;

import io.corp.calculator.TracerImpl;

public class CalculatorControllerTest {

	@Mock
	private CalculatorService calcService;
	@Mock
	private TracerImpl trace;
	@InjectMocks
	private CalculatorController calcController;

	@InjectMocks
	private CalculatorExceptionHandler calExcept;

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(calcController).setControllerAdvice(calExcept).build();
	}

	@Test
	void getOperationExceptionTest() throws Exception {
		when(calcService.calculate(Mockito.any(), Mockito.any(), Mockito.any())).thenThrow(CalculatorException.class);

		this.mockMvc.perform(get("/rest/calculator/calculates").param("firstParam", "2").param("secondParam", "1")
				.param("operator", "").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());

	}

	@Test
	void getOperationResultAllowedOperationTest() {
		CalculatorResponse value = new CalculatorResponse("", BigDecimal.ONE);
		value.setOperation("SUM");
		value.setResult(BigDecimal.ONE);

		when(calcService.calculate(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(value);
		Assertions.assertEquals(HttpStatus.OK, calcController
				.getOperationResult(BigDecimal.ONE, BigDecimal.ZERO, value.getOperation()).getStatusCode());

	}
}
