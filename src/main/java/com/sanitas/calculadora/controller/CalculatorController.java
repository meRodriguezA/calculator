package com.sanitas.calculadora.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.calculadora.exception.CalculatorException;
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

	/** The list allow operationes. */
	@Value("#{'${calculator.allow-values}'.split(',')}")
	private List<String> listAllowOperationes;

	/** The calc serv. */
	@Autowired
	private CalculatorService calcServ;

	/** The tracer. */
	private TracerImpl tracer = new TracerImpl();

	/**
	 * Gets the operation result.
	 *
	 * @param firstParam  the first param
	 * @param secondParam the second param
	 * @param operator    the operator
	 * @return the operation result
	 */
	@GetMapping("/calculates")
	public ResponseEntity<String> getOperationResult(@RequestParam @NotNull BigDecimal firstParam,
			@RequestParam @NotNull BigDecimal secondParam, @RequestParam @NotNull @NotBlank String operator) {

		log.debug("Init getOperationResult");
//		validateOperations(firstParam, secondParam, operator);

		log.debug("Operation allowed");
		BigDecimal resultOperation = calcServ.calculate(firstParam, secondParam, operator);

		log.debug("End getOperationResult");
		tracer.trace(resultOperation);
		return new ResponseEntity<String>("Value calculate: " + resultOperation, HttpStatus.OK);

	}

	/**
	 * Validate operations.
	 * 
	 * Must be includes in application value
	 *
	 * @param firstParam  the first param
	 * @param secondParam the second param
	 * @param operator    the operator
	 */
	private void validateOperations(BigDecimal firstParam, BigDecimal secondParam, String operator) {
		// check operation are allowed
		if (!listAllowOperationes.contains(operator.toLowerCase())) {
			log.debug("End getOperationResult KO");
			throw new CalculatorException("Cal_01", "Operation not allowed");
		}

	}

}
