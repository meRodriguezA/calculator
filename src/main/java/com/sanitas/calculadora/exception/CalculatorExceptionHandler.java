package com.sanitas.calculadora.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.corp.calculator.TracerImpl;
import jakarta.servlet.http.HttpServletRequest;

/**
 * The Class CalculatorExceptionHandler.
 */
@RestControllerAdvice
public class CalculatorExceptionHandler {

	/** The tracer. */
	private TracerImpl tracer = new TracerImpl();

	/**
	 * Resource not found exception.
	 *
	 * @param exception the exception
	 * @param request   the request
	 * @return the calculator error msg
	 */
	@ExceptionHandler(value = CalculatorException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public CalculatorErrorMsg resourceNotFoundException(CalculatorException exception, HttpServletRequest request) {
		CalculatorErrorMsg message = new CalculatorErrorMsg(HttpStatus.BAD_REQUEST.value(), exception.getMsgError(),
				request.getRequestURI());
		tracer.trace(message);
		return message;
	}
}
