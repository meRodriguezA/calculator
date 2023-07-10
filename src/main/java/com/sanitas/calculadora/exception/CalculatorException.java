package com.sanitas.calculadora.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Instantiates a new calculator exception.
 *
 * @param codError the cod error
 * @param msgError the msg error
 */
@AllArgsConstructor

/**
 * Gets the msg error.
 *
 * @return the msg error
 */
@Getter

/**
 * Sets the msg error.
 *
 * @param msgError the new msg error
 */
@Setter
public class CalculatorException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The cod error. */
	private String codError;

	/** The msg error. */
	private String msgError;

}
