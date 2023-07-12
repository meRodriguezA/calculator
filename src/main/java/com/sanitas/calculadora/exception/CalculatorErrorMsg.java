package com.sanitas.calculadora.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class CalculatorErrorMsg.
 */
@Getter
@Setter
@AllArgsConstructor
public class CalculatorErrorMsg {

	/** The status code. */
	private int statusCode;

	/** The message. */
	private String message;

	/** The request uri. */
	private String requestUri;
}
