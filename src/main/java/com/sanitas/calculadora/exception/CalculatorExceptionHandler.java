package com.sanitas.calculadora.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CalculatorExceptionHandler {

	@ExceptionHandler(value = CalculatorException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public CalculatorErrorMsg resourceNotFoundException(CalculatorException exception, HttpServletRequest request) {
		CalculatorErrorMsg message = new CalculatorErrorMsg(HttpStatus.BAD_REQUEST.value(), exception.getMsgError(),
				request.getRequestURI());
		return message;
	}
}
