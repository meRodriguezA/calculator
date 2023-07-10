package com.sanitas.calculadora.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Gets the request uri.
 *
 * @return the request uri
 */
@Getter

/**
 * Sets the request uri.
 *
 * @param requestUri the new request uri
 */
@Setter

/**
 * Instantiates a new calculator error msg.
 *
 * @param statusCode the status code
 * @param message    the message
 * @param requestUri the request uri
 */
@AllArgsConstructor
public class CalculatorErrorMsg {

	/** The status code. */
	private int statusCode;

	/** The message. */
	private String message;

	/** The request uri. */
	private String requestUri;
}
