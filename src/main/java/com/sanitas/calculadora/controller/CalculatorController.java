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

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/rest/calculator")
@CrossOrigin
@Slf4j
public class CalculatorController {

	@Value("#{'${calculator.allow-values}'.split(',')}")
	private List<String> listAllowOperationes;

	@Autowired
	private CalculatorService calcServ;

	@GetMapping("/calculates")
	public ResponseEntity<String> getOperationResult(@RequestParam @NotNull BigDecimal firstParam,
			@RequestParam @NotNull BigDecimal secondParam, @RequestParam @NotNull @NotBlank String operator) {

		log.debug("Init getOperationResult");
		validateOperations(firstParam, secondParam, operator);

		log.debug("Operation allowed");
		BigDecimal resultOperation = calcServ.calculate(firstParam, secondParam, operator);

		log.debug("End getOperationResult");
		return new ResponseEntity<String>("N calculate :" + resultOperation, HttpStatus.OK);
	}

	private void validateOperations(BigDecimal firstParam, BigDecimal secondParam, String operator) {
		if (!listAllowOperationes.contains(operator)) {
			log.debug("End getOperationResult KO");
			throw new CalculatorException("Cal_01", "Operation not allowed");
		}

	}

}
