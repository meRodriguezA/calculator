package com.sanitas.calculadora.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * The Class CalculatorException.
 */
@AllArgsConstructor
@Getter
@Setter
public class CalculatorException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The cod error. */
	private String codError;

	/** The msg error. */
	private String msgError;

}
