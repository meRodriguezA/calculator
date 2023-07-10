package com.sanitas.calculadora.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CalculatorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String codError;

	private String msgError;

}
