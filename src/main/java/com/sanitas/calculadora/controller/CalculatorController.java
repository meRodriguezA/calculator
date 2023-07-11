package com.sanitas.calculadora.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.calculadora.model.CalculatorResponse;
import com.sanitas.calculadora.service.CalculatorService;

import io.corp.calculator.TracerImpl;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class CalculatorController.
 */
@RestController
@RequestMapping("/rest/calculator")
@CrossOrigin

/** The Constant log. */
@Slf4j
public class CalculatorController {

	/** The calc serv. */
	@Autowired
	private CalculatorService calcServ;

	/** The tracer. */
	@Autowired
	private TracerImpl tracer;

	/**
	 * Gets the operation result.
	 *
	 * @param firstParam  the first param
	 * @param secondParam the second param
	 * @param operator    the operator
	 * @return the operation result
	 */
	@GetMapping("/calculates")
	public ResponseEntity<CalculatorResponse> getOperationResult(@RequestParam @NotNull BigDecimal firstParam,
			@RequestParam @NotNull BigDecimal secondParam, @RequestParam @NotNull @NotBlank String operator) {

		log.debug("Init getOperationResult");

		log.debug("Operation allowed");
		CalculatorResponse resultOperation = calcServ.calculate(firstParam, secondParam, operator);

		log.debug("End getOperationResult");
		tracer.trace(resultOperation);
		return new ResponseEntity<CalculatorResponse>( resultOperation, HttpStatus.OK);

	}

}
